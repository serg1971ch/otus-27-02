
plugins {
    id("java")
}

dependencies {
    implementation ("com.google.guava:guava")
}

//tasks {
//    named<ShadowJar>("shadowJar") {
//        archiveBaseName.set("gradleHelloWorld")
//        archiveVersion.set("0.1")
//        archiveClassifier.set("")
//        manifest {
//            attributes(mapOf("Main-Class" to "ru.otus.HelloOtus"))
//        }
//    }
//
//    build {
//        dependsOn(shadowJar)
//    }
//}
