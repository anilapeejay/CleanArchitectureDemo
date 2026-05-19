plugins {
    alias(libs.plugins.android.application)
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

}