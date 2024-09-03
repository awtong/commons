plugins {
    id("java")
}

group = "awt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.validation:jakarta.validation-api:3.1.0")

    runtimeOnly("org.hibernate.validator:hibernate-validator:9.0.0.Beta2")

    testImplementation(platform("org.junit:junit-bom:5.11.0"))
    testImplementation(platform("org.mockito:mockito-bom:5.13.0"))

    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}