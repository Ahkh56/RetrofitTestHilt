plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.genesis.domain"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Dependency on the core module for the Resource class
    implementation(project(":core"))

    // Javax for @Inject annotation
    implementation(libs.javax.inject)

    // Coroutines for Flow
    implementation(libs.kotlinx.coroutines.core)

    // Retrofit for HttpException
    implementation(libs.retrofit)

    testImplementation(libs.junit)
}
