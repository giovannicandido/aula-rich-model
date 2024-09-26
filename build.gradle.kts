plugins {
    id("java")
    id("jacoco")
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
    /**
     * <dependency>
     *    <groupId>javax.el</groupId>
     *    <artifactId>javax.el-api</artifactId>
     *    <version>2.2.4</version>
     * </dependency>
     * <dependency>
     *    <groupId>org.glassfish.web</groupId>
     *    <artifactId>javax.el</artifactId>
     *    <version>2.2.4</version>
     * </dependency>
     */
    implementation("org.glassfish:jakarta.el:4.0.1")
    testImplementation("org.assertj:assertj-core:3.26.3")


}

tasks.test {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}
