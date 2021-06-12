import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	dependencies {
		classpath("org.postgresql:postgresql:42.2.21")
	}

	repositories {
		mavenCentral()
		jcenter()
	}
}

plugins {
	java
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	id("io.gitlab.arturbosch.detekt") version "1.17.1"
	id("org.springframework.boot") version "2.5.1"
	id("com.github.jk1.dependency-license-report") version "1.16"
	id("org.sonarqube") version "3.3"
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
	implementation("io.micrometer:micrometer-registry-elastic:1.7.0")
	implementation("org.postgresql:postgresql:42.2.21")
	implementation(platform("org.springframework.boot:spring-boot-dependencies:2.5.1"))
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.10")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
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
