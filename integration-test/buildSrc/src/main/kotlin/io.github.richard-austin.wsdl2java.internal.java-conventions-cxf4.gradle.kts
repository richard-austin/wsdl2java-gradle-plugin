plugins {
    id("java")
    id("io.github.richard-austin.wsdl2java.internal.java-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.apache.cxf:cxf-bom:4.0.2"))
    testRuntimeOnly("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
