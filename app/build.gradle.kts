plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.android.cryptoapp"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    Libraries.dependencies.forEach {
        implementation(it)
    }

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.extJUnit)
    androidTestImplementation(TestDependencies.espresso)

    kapt(Libraries.hiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}