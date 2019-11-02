// Apply the java plugin to add support for Java
plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
}

dependencies {
    // Guava primitives
    compile("com.google.guava:guava:27.0.1-jre")

    // Annotation
    implementation ("org.jetbrains:annotations:16.0.3")

    // JUnit Jupiter test framework
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.0")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

tasks {
    test {
        maxHeapSize = "128m"
        useJUnitPlatform()
    }
}

application {
    // Define the main class for the application
    mainClassName = "ru.mail.polis.ads.SolveTemplate"
}
