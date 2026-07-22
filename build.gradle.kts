plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "2.1.1"
}

group = "io.github.richard-austin"
version = "2.0.3"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// The integration test folder is an input to the unit test in the root project
// Register these files as inputs
tasks.withType<Test>().configureEach {
    inputs
        .files(layout.projectDirectory.dir("integration-test").asFileTree.matching {
            exclude("**/build/**")
            exclude("**/gradle/**")
        })
        .withPathSensitivity(PathSensitivity.RELATIVE)
    useJUnitPlatform()
    systemProperty("GRADLE_ROOT_FOLDER", projectDir.absolutePath)
    systemProperty("GRADLE_PLUGIN_VERSION", version)
}

tasks.withType<Wrapper> {
    gradleVersion = "9.6.1"
}

dependencies {
    compileOnly("org.apache.cxf:cxf-tools-wsdlto-core:4.2.2")
    testImplementation("commons-io:commons-io:2.14.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.3")
}

gradlePlugin {
    website.set("https://github.com/richard-austin/wsdl2java-gradle-plugin")
    vcsUrl.set("https://github.com/richard-austin/wsdl2java-gradle-plugin.git")
    plugins {
        create("wsdl2JavaPlugin") {
            id = "io.github.richard-austin.wsdl2java"
            displayName = "Gradle Wsdl2Java plugin"
            tags.set(listOf("wsdl2java", "cxf", "wsimport"))
            implementationClass = "io.github.richard_austin.wsdl2java.Wsdl2JavaPlugin"
            description = "This is a fork of com.github.bjornvester.wsdl2java version 2.0.2, modified to support Gradle 10.\n" +
                    "upgraded to use Gradle 9.6.1 and for compatibility with Gradle 10."
       }
    }
}
