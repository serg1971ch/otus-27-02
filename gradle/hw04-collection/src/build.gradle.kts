plugins {
    id ("java")
}

sourceCompatibility = JavaVersion.VERSION_17
targetCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation ("org.junit.jupiter:junit-jupiter-engine")
    testImplementation ("org.junit.jupiter:junit-jupiter-params")
    testImplementation ("org.assertj:assertj-core")
    testImplementation ("org.mockito:mockito-core")
    testImplementation ("org.mockito:mockito-junit-jupiter")
}

test {
    useJUnitPlatform()
}
