plugins {
    id("io.github.richard-austin.wsdl2java")
    id("io.github.richard-austin.wsdl2java.internal.java-conventions-cxf4")
}

dependencies {
    implementation("io.github.threeten-jaxb:threeten-jaxb-core:2.1.0")
}

wsdl2java {
    bindingFile.set(layout.projectDirectory.file("src/main/bindings/bindings.xml"))
}
