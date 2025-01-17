plugins {
    kotlin("multiplatform")
    id("com.android.library")

    id(Dependencies.IOS_KMP_NATIVE) version Dependencies.IOS_KMP_NATIVE_VERSION
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.KOIN_CORE)
                implementation(Dependencies.COROUTINES)
            }
        }
        val androidMain by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    compileSdk = Dependencies.COMPILE_SDK_VERSION
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Dependencies.MIN_SDK_VERSION
        targetSdk = Dependencies.COMPILE_SDK_VERSION
    }
}
