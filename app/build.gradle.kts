import org.cyclonedx.gradle.CycloneDxTask

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("org.cyclonedx.bom")
}

//tasks.withType<CycloneDxTask>().configureEach {
//    setSkipConfigs(listOf(
//        "debugCompileClasspath",
//        "debugAndroidTestCompileClasspath",
//        "debugUnitTestCompileClasspath",
//        "releaseUnitTestCompileClasspath",
//        "debugUnitTestRuntimeClasspath",
//        "releaseUnitTestRuntimeClasspath"
//    ))
//    setIncludeConfigs(listOf("debugRuntimeClasspath"))
//}

android {
    namespace = "com.lomovskiy.android.test.cyclonedx"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.lomovskiy.android.test.cyclonedx"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

var cycloneDxConfiguration: String? = null

fun initCycloneDxConfig() {
    if(gradle.startParameter.taskNames.contains("cyclonedxBom")) {
        cycloneDxConfiguration = "default"
    }
}

dependencies {
//    initCycloneDxConfig()
    implementation(project(path = ":android-module", configuration = "default"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}