plugins {
    id("io.github.richard-austin.wsdl2java")
    id("io.github.richard-austin.wsdl2java.internal.java-conventions-cxf3")
}

dependencies {
    implementation("javax.annotation:javax.annotation-api:1.3.2") // For the @Generated annotation from JDK8 but running in JDK9+
    testImplementation("commons-io:commons-io:2.8.0")
}

wsdl2java {
    useJakarta.set(false)
    markGenerated.set(true)
    generatedStyle.set("default")
}
