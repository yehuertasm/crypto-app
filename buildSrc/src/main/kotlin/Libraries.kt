object Libraries {
    private val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    private val appCompact by lazy { "androidx.appcompat:appcompat:${Versions.appCompact}" }
    private val activityKtx by lazy { "androidx.activity:activity-ktx:${Versions.activityKtx}" }
    private val material by lazy { "com.google.android.material:material:${Versions.material}" }
    private val constrainLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    private val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    private val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
    private val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }

    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }

    val dependencies = arrayOf(
        core,
        appCompact,
        activityKtx,
        material,
        constrainLayout,
        hilt,
        hiltViewModel,
        multidex
    )
}

object TestDependencies {
    val jUnit5Engine by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}" }
    val jUnitExt by lazy { "androidx.test.ext:junit:${Versions.jUnitExt}" }
    private val jUnit5 by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}" }
    private val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    private val kotlinTest by lazy { "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}" }
    private val kotlinTestJunit by lazy { "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}" }

    val suiteTest = arrayOf(
        mockk,
        jUnit5,
        jUnitExt,
        kotlinTest,
        kotlinTestJunit
    )
}

