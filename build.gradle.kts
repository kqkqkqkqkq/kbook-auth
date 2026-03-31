plugins {
	kotlin("jvm") version "2.3.0"
	kotlin("plugin.spring") version "2.3.0"
	id("org.springframework.boot") version "4.0.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("dev.detekt") version "2.0.0-alpha.2"
}

group = "ru.k"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("tools.jackson.module:jackson-module-kotlin")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

	implementation("org.springframework.boot:spring-boot-starter-liquibase")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("org.postgresql:postgresql")


//	implementation("net.devh:grpc-spring-boot-starter:3.1.1")
//	implementation("io.grpc:grpc-kotlin-stub:1.5.0")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.1")



	// test
	testImplementation("io.projectreactor:reactor-test")
	//	testImplementation("org.springframework.boot:spring-boot-starter-data-redis-reactive-test")
//	testImplementation("org.springframework.boot:spring-boot-starter-liquibase-test")
//	testImplementation("org.springframework.boot:spring-boot-starter-security-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	detektPlugins("dev.detekt:detekt-rules-ktlint-wrapper:2.0.0-alpha.2")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
	}
}

detekt {
	autoCorrect	= true
	toolVersion = "2.0.0-alpha.2"
	config.setFrom(file("config/detekt/detekt.yml"))
	buildUponDefaultConfig = true
}

tasks.withType<Test> {
	useJUnitPlatform()
}
