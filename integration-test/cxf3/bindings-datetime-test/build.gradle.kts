plugins {
    id("io.github.richard-austin.wsdl2java")
    id("io.github.richard-austin.wsdl2java.internal.java-conventions-cxf3")
}

dependencies {
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.github.threeten-jaxb:threeten-jaxb-core:1.2")
}

wsdl2java {
    bindingFile.set(layout.projectDirectory.file("src/main/bindings/bindings.xml"))
    useJakarta.set(false)
}
