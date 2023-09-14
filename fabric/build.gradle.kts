plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

architectury {
    platformSetupLoomIde()
    fabric()
}

val minecraftVersion = project.properties["minecraft_version"] as String

sourceSets.main.get().resources.srcDirs(mutableListOf(
    project(":common").file("src/main/generated/resources").absolutePath,
    project(":fabric").file("src/main/generated/resources").absolutePath)
)

loom.runs.create("datagen") {
    server()
    name("Data Generation")
    vmArg("-Dfabric-api.datagen")
    vmArg("-Dfabric-api.datagen.output-dir=${project(":fabric").file("src/main/generated/resources").absolutePath}")
    vmArg("-Dfabric-api.datagen.modid=generations_structures")

    runDir("build/datagen")
}

configurations {
    create("common")
    create("shadowCommon")
    compileClasspath.get().extendsFrom(configurations["common"])
    runtimeClasspath.get().extendsFrom(configurations["common"])
    getByName("developmentFabric").extendsFrom(configurations["common"])
}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${project.properties["fabric_loader_version"]}")
    modApi("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_api_version"]}+$minecraftVersion")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowCommon"(project(":common", "transformProductionFabric")) { isTransitive = false }

    modRuntimeOnly("me.djtheredstoner:DevAuth-fabric:${project.properties["devauth_version"]}")

    // Generations-Core Fabric
    modApi("generations.gg.generations.core:Generations-Core-Fabric:${project.properties["generations-core_version"]}")
    modRuntimeOnly("earth.terrarium:botarium-fabric-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    modApi("com.cobblemon:fabric:${project.properties["cobblemon_version"]}")

    //BiomeMod Integration
    modApi("com.github.glitchfiend:TerraBlender-fabric:$minecraftVersion-${project.properties["terrablender_version"]}")
    modCompileOnly("curse.maven:Oh The Biomes You'll Go Refabricated-391378:${project.properties["BYGFabric_version"]}")
    modCompileOnly("curse.maven:CorgiLib-693313:4583679")
    modCompileOnly("software.bernie.geckolib:geckolib-fabric-$minecraftVersion:${project.properties["geckolib_version"]}")

    //Yungs API
    modApi("com.yungnickyoung.minecraft.yungsapi:YungsApi:1.20-Fabric-${project.properties["YUNGAPI_version"]}")
}

tasks {
    base.archivesName.set(base.archivesName.get() + "-Fabric")
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to project.version))
        }
    }

    shadowJar {
        configurations = listOf(project.configurations.getByName("shadowCommon"))
        archiveClassifier.set("dev-shadow")
        exclude("generations/gg/generations/structures/generationsstructures/fabric/datagen/**")
    }

    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
        dependsOn(shadowJar)
    }

    jar.get().archiveClassifier.set("dev")

    sourcesJar {
        val commonSources = project(":common").tasks.sourcesJar
        dependsOn(commonSources)
        from(commonSources.get().archiveFile.map { zipTree(it) })
    }
}

components {
    java.run {
        if (this is AdhocComponentWithVariants)
            withVariantsFromConfiguration(project.configurations.shadowRuntimeElements.get()) { skip() }
    }
}

publishing {
    publications.create<MavenPublication>("mavenCommon") {
        artifactId = "${project.properties["archives_base_name"]}" + "-Fabric"
        from(components["java"])
    }

    repositories {
        mavenLocal()
        maven {
            val releasesRepoUrl = "https://maven.generations.gg/releases"
            val snapshotsRepoUrl = "https://maven.generations.gg/snapshots"
            url = uri(if (project.version.toString().endsWith("SNAPSHOT") || project.version.toString().startsWith("0")) snapshotsRepoUrl else releasesRepoUrl)
            name = "Generations-Repo"
            credentials {
                username = project.properties["repoLogin"]?.toString()
                password = project.properties["repoPassword"]?.toString()
            }
        }
    }
}