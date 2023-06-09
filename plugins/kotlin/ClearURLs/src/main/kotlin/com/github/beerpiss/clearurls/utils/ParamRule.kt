package com.github.beerpiss.clearurls.utils

import f0.w as HttpUrl;

data class ParamRule(
    val param: Regex,
    val host: Regex? = null,
) {
    companion object {
        val DEFAULT_RULES = listOf(
            ParamRule(Regex("""^action_object_map$""")),
            ParamRule(Regex("""^action_type_map$""")),
            ParamRule(Regex("""^action_ref_map$""")),
            ParamRule(Regex("""^aff_platform$""")),
            ParamRule(Regex("""^aff_trace_key$""")),
            ParamRule(Regex("""^btsid$""")),
            ParamRule(Regex("""^ws_ab_test$""")),
            ParamRule(Regex("""^sc_cid$""")),
            ParamRule(Regex("""^mkt_tok$""")),
            ParamRule(Regex("""^trk$""")),
            ParamRule(Regex("""^trkCampaign$""")),
            ParamRule(Regex("""^ga_.+?$""")),
            ParamRule(Regex("""^gclid$""")),
            ParamRule(Regex("""^gclsrc$""")),
            ParamRule(Regex("""^hmb_campaign$""")),
            ParamRule(Regex("""^hmb_medium$""")),
            ParamRule(Regex("""^hmb_source$""")),
            ParamRule(Regex("""^spReportId$""")),
            ParamRule(Regex("""^spJobID$""")),
            ParamRule(Regex("""^spUserID$""")),
            ParamRule(Regex("""^spMailingID$""")),
            ParamRule(Regex("""^itm_.+?$""")),
            ParamRule(Regex("""^s_cid$""")),
            ParamRule(Regex("""^elqTrackId$""")),
            ParamRule(Regex("""^elqTrack$""")),
            ParamRule(Regex("""^assetType$""")),
            ParamRule(Regex("""^assetId$""")),
            ParamRule(Regex("""^recipientId$""")),
            ParamRule(Regex("""^campaignId$""")),
            ParamRule(Regex("""^siteId$""")),
            ParamRule(Regex("""^mc_cid$""")),
            ParamRule(Regex("""^mc_eid$""")),
            ParamRule(Regex("""^pk_.+?$""")),
            ParamRule(Regex("""^sc_campaign$""")),
            ParamRule(Regex("""^sc_channel$""")),
            ParamRule(Regex("""^sc_content$""")),
            ParamRule(Regex("""^sc_medium$""")),
            ParamRule(Regex("""^sc_outcome$""")),
            ParamRule(Regex("""^sc_geo$""")),
            ParamRule(Regex("""^sc_country$""")),
            ParamRule(Regex("""^nr_email_referer$""")),
            ParamRule(Regex("""^vero_conv$""")),
            ParamRule(Regex("""^vero_id$""")),
            ParamRule(Regex("""^yclid$""")),
            ParamRule(Regex("""^_openstat$""")),
            ParamRule(Regex("""^mbid$""")),
            ParamRule(Regex("""^cmpid$""")),
            ParamRule(Regex("""^cid$""")),
            ParamRule(Regex("""^c_id$""")),
            ParamRule(Regex("""^campaign_id$""")),
            ParamRule(Regex("""^Campaign$""")),
            ParamRule(Regex("""^fb_action_ids$""")),
            ParamRule(Regex("""^fb_action_types$""")),
            ParamRule(Regex("""^fb_ref$""")),
            ParamRule(Regex("""^fb_source$""")),
            ParamRule(Regex("""^fbclid$""")),
            ParamRule(Regex("""^gs_l$""")),
            ParamRule(Regex("""^_hsenc$""")),
            ParamRule(Regex("""^_hsmi$""")),
            ParamRule(Regex("""^__hssc$""")),
            ParamRule(Regex("""^__hstc$""")),
            ParamRule(Regex("""^hsCtaTracking$""")),
            ParamRule(Regex("""^tt_medium$""")),
            ParamRule(Regex("""^tt_content$""")),
            ParamRule(Regex("""^wt_zmc$""")),
            ParamRule(Regex("""^utm_source$""")),
            ParamRule(Regex("""^utm_content$""")),
            ParamRule(Regex("""^utm_medium$""")),
            ParamRule(Regex("""^utm_campaign$""")),
            ParamRule(Regex("""^utm_term$""")),
            ParamRule(Regex("""^spm$"""), Regex("""^(www\.)?(.+?\.)?aliexpress\.com$""")),
            ParamRule(Regex("""^scm$"""), Regex("""^(www\.)?(.+?\.)?aliexpress\.com$""")),
            ParamRule(Regex("""^algo_expid$"""), Regex("""^(www\.)?(.+?\.)?aliexpress\..+?$""")),
            ParamRule(Regex("""^algo_pvid$"""), Regex("""^(www\.)?(.+?\.)?aliexpress\..+?$""")),
            ParamRule(Regex("""^pd_rd_.+?$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^_encoding$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^psc$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^tag$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^ref_$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^pf_rd_.+?$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^pf$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^crid$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^keywords$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^sprefix$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^sr$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^ie$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^node$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^qid$"""), Regex("""^(www\.)?amazon\..+?$""")),
            ParamRule(Regex("""^callback$"""), Regex("""^(www\.)?bilibili\.com$""")),
            ParamRule(Regex("""^cvid$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^form$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^sk$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^sp$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^sc$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^qs$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^pq$"""), Regex("""^(www\.)?bing\.com$""")),
            ParamRule(Regex("""^hash$"""), Regex("""^(www\.)?ebay\..+?$""")),
            ParamRule(Regex("""^refsrc$"""), Regex("""^(www\.)?facebook\.com$""")),
            ParamRule(Regex("""^hrc$"""), Regex("""^(www\.)?facebook\.com$""")),
            ParamRule(Regex("""^gs_lcp$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^ved$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^ei$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^sei$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^gws_rd$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^gs_gbg$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^gs_mss$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^gs_rn$"""), Regex("""^(www\.)?google\..+?$""")),
            ParamRule(Regex("""^source$"""), Regex("""^(www\.)?sourceforge\.net$""")),
            ParamRule(Regex("""^position$"""), Regex("""^(www\.)?sourceforge\.net$""")),
            ParamRule(Regex("""^t$"""), Regex("""^(www\.)?(.+?)?twitter\.com$""")),
            ParamRule(Regex("""^s$"""), Regex("""^(www\.)?(.+?)?twitter\.com$""")),
            ParamRule(Regex("""^ref_.+?$"""), Regex("""^(www\.)?(.+?)?twitter\.com$""")),
            ParamRule(Regex("""^lr$"""), Regex("""^(www\.)?yandex\..+?$""")),
            ParamRule(Regex("""^redircnt$"""), Regex("""^(www\.)?yandex\..+?$""")),
            ParamRule(Regex("""^feature$"""), Regex("""^(www\.)?youtube\.com$""")),
            ParamRule(Regex("""^kw$"""), Regex("""^(www\.)?youtube\.com$""")),
            ParamRule(Regex("""^si$"""), Regex("""^(www\.)?open\.spotify\.com$""")),
        )
    }
}
