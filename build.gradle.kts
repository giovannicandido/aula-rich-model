plugins {
    id("java")
}

group = "br.com.fundatec"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

}

tasks.test {
    useJUnitPlatform()
}