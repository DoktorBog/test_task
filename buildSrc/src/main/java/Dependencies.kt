object ApplicationId {
    val application_id = "com.test.app"
}

object Modules {
    val domain = ":domain"
    val data = ":data"
}

object Releases {
    val version_code = 1
    val version_name = "1.1.1"
}

object Versions {
    val gradle = "3.1.2"

    val versions = "0.17.0"

    val compile_sdk = 28
    val min_sdk = 21
    val target_sdk = 28

    val inject = "1"

    val support = "28.0.0-alpha3"
    val maps = "12.0.0"

    val support_constraint = "1.1.2"

    val kotlin = "1.2.31"
    val anko = "0.10.4"
    val rxandroid = "2.0.2"
    val rxkotlin = "2.2.0"
    val retrofit = "2.4.0"
    val logging_interceptor = "3.10.0"
    val dagger = "2.15"
    val glide = "4.6.1"
    val rxpaper = "1.2.0"
    val rxrelay = "2.0.0"
    val moshi = "1.4.0"
    val lifecycle = "1.1.1"
    val multidex = "1.0.2"

    val junit = "4.12"
    val assertj_core = "3.9.1"
    val mockito_kotlin = "1.5.0"
}

object Libraries {
    val inject = "javax.inject:javax.inject:${Versions.inject}"

    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val anko_commons = "org.jetbrains.anko:anko-commons:${Versions.anko}"

    val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"
    val location = "com.google.android.gms:play-services-location:${Versions.maps}"


    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val rxrelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxrelay}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val rxpaper = "com.github.pakoito:RxPaper2:${Versions.rxpaper}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"

    val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val lifecycle_compiler = "android.arch.lifecycle:compiler:${Versions.lifecycle}"


    val multidex = "com.android.support:multidex:${Versions.multidex}"


    val header_adapter = "org.zakariya.stickyheaders:stickyheaders:0.7.6"

}

object SupportLibraries {
    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support}}"
    val design = "com.android.support:design:${Versions.support}"
    val cardview_v7 = "com.android.support:cardview-v7:${Versions.support}"
    val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support}"
    val chrome_custom_tabs = "com.android.support:customtabs:${Versions.support}"
    val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.support_constraint}"
}