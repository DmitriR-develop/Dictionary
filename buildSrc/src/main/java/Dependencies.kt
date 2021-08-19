import org.gradle.api.JavaVersion

object Config {
    const val application_id = "com.dmitri.dictionary"
    const val compile_sdk = 30
    const val min_sdk = 21
    const val target_sdk = 30
    const val build_tools_version = "30.0.3"
    val java_version = JavaVersion.VERSION_1_8
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val core = ":core"
    const val app = ":app"
    const val model = ":model"
    const val repository = ":repository"
    const val historyScreen = ":historyScreen"
    const val descriptionScreen = ":descriptionScreen"
}

object Versions {
    //Design
    const val appcompat = "1.4.0-alpha03"
    const val constraint = "2.1.0"
    const val swiperefresh = "1.1.0"
    const val material = "1.4.0"

    //Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.4.32"
    const val coroutinesCore = "1.3.8"
    const val coroutinesAndroid = "1.4.1"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "4.9.1"
    const val adapterCoroutines = "0.9.2"

    //Koin
    const val koinAndroid = "2.0.1"
    const val koinViewModel = "2.0.1"

    //Picasso
    const val picasso = "2.5.2"

    //Room
    const val roomKtx = "2.4.0-alpha04"
    const val runtime = "2.4.0-alpha04"
    const val roomCompiler = "2.4.0-alpha04"

    //Test
    const val jUnit = "4.13.2"
    const val jUnitAndroid = "1.1.3"

    //const val runner = "1.2.0"
    const val espressoCore = "3.4.0"

    //Google Play
    const val googlePlayCore = "1.10.0"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val swiperefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefresh}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapter_coroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}

object Koin {
    const val koin_android = "org.koin:koin-android:${Versions.koinAndroid}"
    const val koin_viewmodel =  "org.koin:koin-androidx-viewmodel:${Versions.koinViewModel}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val junit_android = "androidx.test.ext:junit:${Versions.jUnitAndroid}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object GooglePlay {
    const val googlePlayCore = "com.google.android.play:core:${Versions.googlePlayCore}"
}