package com.github.beerpiss.clearurls

import android.content.Context
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.api.SettingsAPI
import com.aliucord.entities.Plugin
import com.aliucord.patcher.before
import com.discord.widgets.chat.MessageContent
import com.discord.widgets.chat.MessageManager
import com.discord.widgets.chat.input.ChatInputViewModel
import com.github.beerpiss.clearurls.utils.ParamRule

import f0.w as HttpUrl

@AliucordPlugin(requiresRestart = false /* Whether your plugin requires a restart after being installed/updated */)
class ClearURLs : Plugin() {

    private val textContentField = MessageContent::class.java.getDeclaredField("textContent").apply {
        isAccessible = true
    }

    private fun replacer(match: String): String {
        // HttpUrl.Builder().parse(null, match)
        val builder = HttpUrl.a().e(null, match)
        val host = builder.e

        val regexes = rules.mapNotNull {
            if (it.host == null || host.matches(it.host)) {
                it.param
            } else {
                null
            }
        }

        // h: encodedQueryNamesAndValues
        for (i in builder.h!!.size - 2 downTo 0 step 2) {
            val paramName = builder.h!![i]
            if (regexes.any { regex -> paramName.matches(regex) }) {
                builder.h!!.removeAt(i + 1)
                builder.h!!.removeAt(i)
                if (builder.h!!.isEmpty()) {
                    builder.h = null
                }
            }
        }

        // builder.build().toString()
        return builder.b().toString()
    }

    override fun start(context: Context) {
        mSettings = settings

        patcher.before<ChatInputViewModel>(
            "sendMessage",
            Context::class.java,
            MessageManager::class.java,
            MessageContent::class.java,
            List::class.java,
            Boolean::class.javaPrimitiveType!!,
            Function1::class.java,
        ) {
            try {
                val content = it.args[2] as MessageContent? ?: return@before
                val plainText = content.textContent

                if (!basicUrlRegex.containsMatchIn(plainText)) {
                    return@before
                }

                val cleanedPlainText = plainText.replace(fullUrlRegex) { match ->
                    replacer(match.value)
                }

                textContentField.set(content, cleanedPlainText)
            } catch (ignored: Throwable) {
                logger.error(ignored)
            }
        }
    }

    override fun stop(context: Context) {
        // Remove all patches
        patcher.unpatchAll()
    }

    val basicUrlRegex = Regex("""https?:\/\/""")

    val fullUrlRegex = Regex("""(https?:\/\/[^\s<]+[^<.,:;"'>)|\]\s])""")

    companion object {
        lateinit var mSettings: SettingsAPI
        var rules = ParamRule.DEFAULT_RULES
    }
}
