object Libraries {
    private val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    private val appCompact by lazy { "androidx.appcompat:appcompat:${Versions.appCompact}" }
    private val activityKtx by lazy { "androidx.activity:activity-ktx:${Versions.activityKtx}" }
    private val material by lazy { "com.google.android.material:material:${Versions.material}" }
    private val constrainLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    private val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    private val hiltViewModel by lazy {  "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
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
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val extJUnit by lazy { "androidx.test.ext:junit:${Versions.testJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
}

