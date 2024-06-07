plugins {
  id("java")
  id("idea")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

repositories {
  mavenCentral()
}

dependencies {
    listOf("hive-service").forEach { name ->
        implementation("org.apache.hive:${name}:3.1.2")
    }
    listOf("aws-java-sdk-sts", "aws-java-sdk-s3", "aws-java-sdk-bom").forEach { mod ->
        compileOnly("com.amazonaws:${mod}:1.11.860")
    }
    listOf("trino-spi", "trino-plugin-toolkit", "trino-hive").forEach { name ->
        compileOnly("io.trino:${name}:418")
    }
    compileOnly("org.slf4j:slf4j-api:1.7.36")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.mockito:mockito-core:3.7.7")
    testImplementation("com.amazonaws:aws-java-sdk-core:1.11.1000")
}

tasks.test {
    useJUnitPlatform()
}