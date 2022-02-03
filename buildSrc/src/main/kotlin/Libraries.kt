object Libraries {
    private val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    private val appCompact by lazy { "androidx.appcompat:appcompat:${Versions.appCompact}" }
    private val activityKtx by lazy { "androidx.activity:activity-ktx:${Versions.activityKtx}" }
    private val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
    private val material by lazy { "com.google.android.material:material:${Versions.material}" }
    private val constrainLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    private val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    private val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
    private val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }
    private val rxJava by lazy { "io.reactivex.rxjava3:rxjava:${Versions.rxJava}" }
    private val rxAndroid by lazy { "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}" }
    private val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    private val room by lazy { "androidx.room:room-runtime:${Versions.room}" }
    private val roomExtensions by lazy { "androidx.room:room-ktx:${Versions.room}" }
    private val roomRx by lazy { "androidx.room:room-rxjava3:${Versions.room}" }

    val moshiCodegen by lazy { "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }

    val dependencies = arrayOf(
        core,
        appCompact,
        activityKtx,
        fragment,
        material,
        constrainLayout,
        hilt,
        hiltViewModel,
        multidex,
        rxJava,
        rxAndroid,
        moshi,
        room,
        roomExtensions,
        roomRx
    )
}

object TestDependencies {
    val jUnit5Engine by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}" }
    val jUnitExtKtx by lazy { "androidx.test.ext:junit:${Versions.jUnitExtKtx}" }
    val testCoreKtx by lazy { "androidx.test:core-ktx:${Versions.testCoreKtx}" }
    private val jUnit5 by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}" }
    private val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    private val kotlinTest by lazy { "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}" }
    private val kotlinReflect by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}" }
    private val kotlinTestJunit by lazy { "org.jetbrains.kotlin:kotlin-test-junit5:${Versions.kotlin}" }
    private val roomTesting by lazy { "androidx.room:room-testing:${Versions.room}" }

    val suiteTest = arrayOf(
        mockk,
        jUnit5,
        jUnitExtKtx,
        testCoreKtx,
        kotlinTest,
        kotlinReflect,
        kotlinTestJunit,
        roomTesting
    )
}

