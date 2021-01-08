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
	kotlin("jvm") version "1.4.0"
	kotlin("plugin.spring") version "1.4.0"
	id("io.gitlab.arturbosch.detekt") version "1.15.0"
	id("org.springframework.boot") version "2.4.1"
	id("com.github.jk1.dependency-license-report") version "1.16"
	id("org.sonarqube") version "3.0"
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
	implementation("net.logstash.logback:logstash-logback-encoder:6.5")
	implementation("io.micrometer:micrometer-registry-elastic:1.6.2")
	implementation("org.postgresql:postgresql:42.2.14")
	implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.1"))
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.21")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testImplementation("org.assertj:assertj-core:3.18.1")
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
