plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinParcelize)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navigationSafeArgs)
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "app.akilesh.qacc"
        minSdkVersion(29)
        targetSdkVersion(30)
        versionCode = 14
        versionName = "1.91"
        vectorDrawables.useSupportLibrary = true
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/**")
        resources.excludes.add("/kotlin/**")
        resources.excludes.add("/okhttp3/**")
        resources.excludes.add("/org/bouncycastle/**")
    }
}

dependencies {
    implementation(fileTree(mapOf( "dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.coreKtx)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.preferenceKtx)
    implementation(Libraries.paletteKtx)

    // Room components
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)

    // Lifecycle components
    implementation(Libraries.lifecycleLiveData)
    implementation(Libraries.lifecycleCommon)

    // ViewModel Kotlin support
    implementation(Libraries.lifecycleViewModel)

    // Coroutines
    api(Libraries.coroutines)

    // Navigation component
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUI)

    implementation(Libraries.activityKtx)
    implementation(Libraries.fragmentKtx)

    implementation(Libraries.materialComponents)

    implementation(Libraries.libSuCore)
    implementation(Libraries.libsuIO)

    implementation(Libraries.assentCore)
    implementation(Libraries.assentRationales)
    implementation(Libraries.assentCoroutines)

    implementation(Libraries.appUpdater)

    debugImplementation(Libraries.whatTheStack)

    implementation(Libraries.workManager)

    implementation(Libraries.recyclerView)
    implementation(Libraries.rvSelection)

    implementation(Libraries.viewpager2)

    implementation(Libraries.andColorPicker)

    api(Libraries.bcProvider)
    api(Libraries.bcPKIX)

    implementation(Libraries.paging)
}
