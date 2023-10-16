plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
//    id ("com.google.gms.google-services")
}

android {
    namespace = "io.jadu.statshunter"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.jadu.statshunter"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions{
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

implementation("androidx.compose.material3:material3:1.1.2")
    //    implementation ("androidx.compose.material:material:1.5.3")
//    implementation ("androidx.compose.compiler:compiler:1.5.3")
//    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.3")
//    implementation ("androidx.activity:activity-compose:1.8.0")
//    debugImplementation ("androidx.compose.ui:ui-tooling:1.6.0-alpha07")

    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation ("androidx.compose.runtime:runtime")
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.foundation:foundation")
    implementation ("androidx.compose.foundation:foundation-layout")
    implementation ("androidx.compose.material:material")
    implementation ("androidx.compose.runtime:runtime-livedata")
    implementation ("androidx.compose.ui:ui-tooling")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val lifecycleVersion = "2.6.2"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    //di
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.44")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    //glide
    implementation("com.github.bumptech.glide:glide:4.15.1")

    //room
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

    //navigation for compose
    val  nav_version = "2.7.4"
    implementation ("androidx.navigation:navigation-compose:$nav_version")

    //viewpager


}
kapt {
    correctErrorTypes = true
}
