buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:${Versions.androidJUnit5}")
    }
}

allprojects{
    plugins.withType(JavaLibraryPlugin::class) {
        tasks.getByName("test", Test::class) {
            useJUnitPlatform()
            testLogging {
                exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                events("passed", "failed", "skipped", "standardOut", "standardError")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
