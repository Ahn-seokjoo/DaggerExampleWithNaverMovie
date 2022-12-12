plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.navermovie.daggerexamplewithnavermovie"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.navermovie.daggerexamplewithnavermovie"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(Libs.androidCore)
    implementation(Libs.appCompat)
    implementation(Libs.constraint)
    implementation(Libs.material)

    implementation(Libs.kotlin)
    implementation(Libs.retrofit)
    implementation(Libs.okHttp)
    implementation(Libs.dagger)
    implementation(Libs.daggerSupport)
    annotationProcessor(Libs.daggerAnnotationProcessor)
    implementation(Libs.coroutine)
    implementation(Libs.gson)
    implementation(Libs.fragment)
    implementation(deps.glide)
    implementation(deps.bundles.lifecycle)
}
