import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	dependencies {
		classpath("org.postgresql:postgresql:42.2.18")
	}

	repositories {
		mavenCentral()
		jcenter()
	}
}

plugins {
	java
	kotlin("jvm") version "1.4.21-2"
	kotlin("plugin.spring") version "1.4.21-2"
	id("io.gitlab.arturbosch.detekt") version "1.15.0"
	id("org.springframework.boot") version "2.4.2"
	id("com.github.jk1.dependency-license-report") version "2.0"
	id("org.sonarqube") version "3.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.postgresql:postgresql")
	implementation("net.logstash.logback:logstash-logback-encoder:6.6")
	implementation("io.micrometer:micrometer-registry-elastic:1.6.3")
	implementation("org.postgresql:postgresql:42.2.18")
	implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.2"))
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.21-2")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testImplementation("org.assertj:assertj-core:3.19.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
