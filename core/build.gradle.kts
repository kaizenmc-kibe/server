plugins {
    `java-library`
}

dependencies {
    api(libs.bundles.serialization)
    api(libs.jedis)
    implementation(libs.mariadb)
}
