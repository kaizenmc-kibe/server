plugins {
    alias(libs.plugins.shadow) apply false
}

allprojects {
    group = "com.minecraft"
    version = "1.0.0"
}

subprojects {
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
    }

    dependencies {
        "compileOnly"(rootProject.libs.lombok)
        "annotationProcessor"(rootProject.libs.lombok)
        "testCompileOnly"(rootProject.libs.lombok)
        "testAnnotationProcessor"(rootProject.libs.lombok)
        "testImplementation"(platform(rootProject.libs.junit.bom))
        "testImplementation"(rootProject.libs.junit.jupiter)
        "testRuntimeOnly"(rootProject.libs.junit.launcher)
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release = 17
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
