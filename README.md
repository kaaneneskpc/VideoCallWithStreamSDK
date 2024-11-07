# Video Call With Stream SDK

- ###  This project about a video calling app in Jetpack Compose with Using Stream SDK.

</br>

## App Contents
### All Screens
| Chat Screen | Camera On | Camera Off |
| --------- | ------ | ------ |
|<img src="https://github.com/user-attachments/assets/d06ba978-7215-41e1-bfab-072dc3497cca" width = "1400px"/>|<img src="https://github.com/user-attachments/assets/f50323f8-7f8d-46f0-b719-2f8fefdf4c27"  width = "1400px"/>|<img src="https://github.com/user-attachments/assets/1a77ce91-8f0f-4878-90be-e3cf1bff2b28"  width = "1400px"/>|
</br>

## Installation

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
