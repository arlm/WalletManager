plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.navigation.safe.args)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "br.com.alexandremarcondes.walletmanager"
    compileSdk = 35

    android.buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "br.com.alexandremarcondes.walletmanager"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}

dependencies {
    implementation(kotlin("reflect"))

    implementation(libs.bundles.android.core)
    implementation(libs.bundles.android.activity)
    implementation(libs.bundles.android.navigation)
    implementation(libs.bundles.android.lifecycle)

    implementation(libs.bundles.android.material.core)
    implementation(libs.bundles.android.material.icons)
    implementation(libs.bundles.android.material.material3)

    implementation(libs.bundles.android.compose.core)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.compose.livedata)
    implementation(libs.activity.compose)
    implementation(libs.splashscreen.core)

    implementation(libs.wear.tooling.preview)

    testImplementation(libs.bundles.tests.core)
    androidTestImplementation(libs.bundles.android.tests)

    debugImplementation(libs.bundles.android.compose.tooling)

    implementation(libs.glide)
}
