plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.max"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation ("org.mockito:mockito-core")
	implementation ("org.springframework.boot:spring-boot-starter-webflux")

	implementation ("com.fasterxml.jackson.core:jackson-core:2.17.2")
	implementation ("com.fasterxml.jackson.core:jackson-databind:2.17.2")
	implementation ("com.fasterxml.jackson.core:jackson-annotations:2.17.2")
	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0")
	implementation ("org.springframework.boot:spring-boot-starter")





}


tasks.withType<Test> {
	useJUnitPlatform()
}
