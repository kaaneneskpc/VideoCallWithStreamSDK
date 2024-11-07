# Video Call App with Stream SDK

A Jetpack Compose video calling app utilizing the Stream SDK to enable real-time video and chat functionalities. This app demonstrates how to integrate Stream's Video SDK into an Android application using modern development practices.

# Introduction
This project showcases how to build a video calling application in Jetpack Compose using the Stream SDK. It leverages Stream's powerful APIs to provide seamless video communication and chat features within the app.

# Features
<li>Real-time video calling</li>
<li>In-app chat messaging</li>
<li>Toggle camera on/off</li>
<li>User-friendly UI with Jetpack Compose</li>
<li>Easy integration with Stream SDK</li>

</br>

## App Contents
### All Screens
| Chat Screen | Camera On | Camera Off |
| --------- | ------ | ------ |
|<img src="https://github.com/user-attachments/assets/d06ba978-7215-41e1-bfab-072dc3497cca" width = "1400px"/>|<img src="https://github.com/user-attachments/assets/f50323f8-7f8d-46f0-b719-2f8fefdf4c27" width = "1400px"/>|<img src="https://github.com/user-attachments/assets/1a77ce91-8f0f-4878-90be-e3cf1bff2b28" width = "1400px"/>|

</br>

# Prerequisites
<li>Android Studio Bumblebee or later</li>
<li>Minimum SDK level 24</li>
<li>Kotlin 1.8 or higher</li>
<li>An account on <a href="https://getstream.io/">Stream</a> to obtain API keys</li>

</br>

## Installation

Clone the repository
```kotlin
git clone https://github.com/your_username/your_repository.git
```
Open In Android Studio, Click on File > Open and select the cloned project directory.

Add the dependency to your `libs.versions.toml` file:

```kotlin
[versions]
agp = "8.7.1"
kotlin = "2.0.0"
coreKtx = "1.13.1"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
lifecycleRuntimeKtx = "2.8.6"
activityCompose = "1.9.3"
composeBom = "2024.04.01"
stream = "0.5.8"
koin = "3.5.3"
composeNavigation = "2.8.0-beta01"
serialization = "1.6.3"

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
stream-video = { module = "io.getstream:stream-video-android-core", version.ref = "stream" }
stream-video-android-ui-compose = { module = "io.getstream:stream-video-android-ui-compose", version.ref = "stream" }
navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "composeNavigation" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "serialization"}
koin-android = { group = "io.insert-koin", name = "koin-android", version.ref = "koin" }
koin-core = { group = "io.insert-koin", name = "koin-core", version.ref = "koin" }
koin-androidx-compose = { group = "io.insert-koin", name = "koin-androidx-compose", version.ref = "koin" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }

[bundles]
koin = ["koin-core", "koin-android", "koin-androidx-compose"]
stream = ["stream-video", "stream-video-android-ui-compose"]
```

Add the dependency to your `build.gradle.kts` file:

```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.videoappwithstreamsdk"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.videoappwithstreamsdk"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.bundles.koin)
    implementation(libs.bundles.stream)

    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

}

```

## Stream SDK Implementation

- ### APIs and SDKs to Build In-App Chat Video & Feeds Faster.
Stream's platform empowers developers with the flexibility and scalability they need to build rich conversations and engaging communities Go to the link and get your key with "Start Coding Free". https://getstream.io

<p align="center" width="100%">
    <img width="100%" src="https://github.com/user-attachments/assets/a3c4a73c-55c3-430f-9617-ededbc5e6b8e"> 
</p>

- ### You can also watch the video for how to implement sdk to your project

https://github.com/user-attachments/assets/553fedb3-2101-40cb-92b0-e2ce1152ed28 

# License
This project is licensed under the MIT License.

# Acknowledgments
Stream SDK for providing the video and chat services.
Jetpack Compose for the modern UI toolkit.

# Contact
For questions or suggestions, feel free to reach out:

<ul>Email: <a href="mailto:kaaneneskpc1@gmail.com">Kaan Enes KAPICI</a></ul>
<ul>GitHub: <a href="https://www.github.com/kaaneneskpc">kaaneneskpc</a></ul>

