plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.legacy.kapt)

    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kim.android.cleanarchitecturedemo"

    compileSdk = 36

    defaultConfig {
        applicationId = "com.kim.android.cleanarchitecturedemo"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

  /*  buildFeatures {
        compose = true
    }*/

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

   /* kotlinOptions {
        jvmTarget = "17"
    }*/
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity.ktx)


    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.retrofit)

    implementation(libs.converter.gson)

    implementation(libs.logging.interceptor)

    // Coroutine
    implementation(libs.kotlinx.coroutines.android)

    // Life Cycle - View Model
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // okhttp
    implementation(libs.logging.interceptor.v4120)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // StateFlow lifecycle
    implementation(libs.androidx.lifecycle.runtime.compose)

    // RecyclerView
    implementation(libs.androidx.recyclerview)


}
kapt {
    correctErrorTypes = true
}