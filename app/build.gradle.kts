plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinParcelize)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navigationSafeArgs)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "app.akilesh.qacc"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 15
        versionName = "1.92"
        vectorDrawables.useSupportLibrary = true

        javaCompileOptions.annotationProcessorOptions.arguments(
            mapOf("room.incremental" to "true")
        )
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules-debug.pro")
        }
    }
    packagingOptions {
        exclude("META-INF/**")
        exclude("/kotlin/**")
        exclude("/okhttp3/**")
        exclude("/org/bouncycastle/**")
    }
}

dependencies {
    implementation(fileTree(mapOf( "dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.30")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.5.0-alpha05")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.palette:palette-ktx:1.0.0")

    // Room components
    implementation("androidx.room:room-runtime:2.4.0")
    implementation("androidx.room:room-ktx:2.3.0-alpha04")
    kapt("androidx.room:room-compiler:2.4.0")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0")

    // ViewModel Kotlin support
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("androidx.activity:activity-ktx:1.2.0-rc01")
    implementation("androidx.fragment:fragment-ktx:1.3.0-rc01")

    implementation("com.google.android.material:material:1.3.0-beta01")

    implementation("com.github.topjohnwu.libsu:core:3.0.2")
    implementation("com.github.topjohnwu.libsu:io:3.0.2")

    implementation("com.afollestad.assent:core:3.0.0-RC4")
    implementation("com.afollestad.assent:rationales:3.0.0-RC4")
    implementation("com.afollestad.assent:coroutines:3.0.0-RC4")

    implementation("com.github.javiersantos:AppUpdater:2.7")

    debugImplementation("com.github.haroldadmin:WhatTheStack:0.2.0")

    implementation("androidx.work:work-runtime-ktx:2.4.0")

    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0-rc03")

    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation("codes.side:andcolorpicker:0.5.0")

    api("org.bouncycastle:bcprov-jdk15on:1.67")
    api("org.bouncycastle:bcpkix-jdk15on:1.67")

    implementation("androidx.paging:paging-runtime-ktx:3.0.0-alpha11")
}
