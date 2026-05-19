plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.legacy.kapt) apply false
    id("com.google.dagger.hilt.android") version "2.59.2" apply false
}