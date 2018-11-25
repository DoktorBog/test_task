package com.test.presentation.common

import com.test.presentation.BuildConfig


object Constants {

    object Network {
        private const val DEBUG_HOST = "smartbox.software"
        private const val DEBUG_HTTP_SCHEME = "http"

        private const val PRODUCTION_HOST = DEBUG_HOST
        private const val PRODUCTION_HTTP_SCHEME = DEBUG_HTTP_SCHEME

        private const val appApiBaseUrlTemplate = "%s://%s/tt/"

        val host = if (BuildConfig.DEBUG) DEBUG_HOST else PRODUCTION_HOST
        val httpScheme = if (BuildConfig.DEBUG) DEBUG_HTTP_SCHEME else PRODUCTION_HTTP_SCHEME

        val appApiBaseUrl = appApiBaseUrlTemplate.format(httpScheme, host)
    }


}