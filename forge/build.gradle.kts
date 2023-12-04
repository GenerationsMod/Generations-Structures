import me.hypherionmc.modpublisher.plugin.ModPublisherGradleExtension.ApiKeys

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("me.hypherionmc.modutils.modpublisher") version "1.+"
}

architectury {
    platformSetupLoomIde()
    forge()
}

val minecraftVersion = project.properties["minecraft_version"] as String

configurations {
    create("common")
    create("shadowCommon")
    compileClasspath.get().extendsFrom(configurations["common"])
    runtimeClasspath.get().extendsFrom(configurations["common"])
    getByName("developmentForge").extendsFrom(configurations["common"])
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)

    forge {
        convertAccessWideners.set(true)
        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
    }

    runs.create("data") {
        data()
        programArgs("--all", "--mod", "generations_structures")
        programArgs("--output", project(":common").file("src/main/generated/resources").absolutePath)
        programArgs("--existing", project(":common").file("src/main/resources").absolutePath)
    }
}

repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge/")
}

dependencies {
    forge("net.minecraftforge:forge:$minecraftVersion-${project.properties["forge_version"]}")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowCommon"(project(":common", "transformProductionForge")) { isTransitive = false }

    modRuntimeOnly("me.djtheredstoner:DevAuth-forge-latest:${project.properties["devauth_version"]}")

    // Generations-Core Forge
    modApi("generations.gg.generations.core:Generations-Core-Forge:${project.properties["generations-core_version"]}@jar") { isChanging = true }
    modRuntimeOnly("dev.architectury:architectury-forge:${project.properties["architectury_version"]}")
    modRuntimeOnly("earth.terrarium:botarium-forge-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    implementation("thedarkcolour:kotlinforforge:4.7.0")
    modApi("com.cobblemon:forge:${project.properties["cobblemon_version"]}")

    //BiomeMod Integration
    modApi("com.github.glitchfiend:TerraBlender-forge:$minecraftVersion-${project.properties["terrablender_version"]}")
    modApi("com.github.glitchfiend:BiomesOPlenty:$minecraftVersion-${project.properties["BOP_version"]}")
    modCompileOnly("maven.modrinth:biomesyougo:${project.properties["BYGForge_version"]}")
    //modRuntimeOnly("curse.maven:CorgiLib-693313:4681375")
    //modRuntimeOnly("software.bernie.geckolib:geckolib-forge-$minecraftVersion:${project.properties["geckolib_version"]}")

    //Yungs API
    modApi("com.yungnickyoung.minecraft.yungsapi:YungsApi:1.20-Forge-${project.properties["YUNGAPI_version"]}")
}

tasks {
    base.archivesName.set(base.archivesName.get() + "-Forge")
    processResources {
        inputs.property("version", project.version)

        filesMatching("META-INF/mods.toml") {
            expand(mapOf("version" to project.version))
        }
    }

    shadowJar {
        exclude("fabric.mod.json",
            "generations/gg/generations/structures/generationsstructures/forge/datagen/**",
            ".cache/**", "architectury.common.json")
        configurations = listOf(project.configurations.getByName("shadowCommon"))
        archiveClassifier.set("dev-shadow")
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

publisher {
    val apiKeys = ApiKeys()
    apiKeys.curseforge = project.properties["curseforge_token"].toString()
    apiKeys.modrinth = project.properties["modrinth_token"].toString()
    apiKeys.github = project.properties["github_token"].toString()

    curseID = "944403"
    modrinthID = "e1GvDbBX"  //TODO I need to change this later
    githubRepo = "https://github.com/GenerationsMod/Generations-Structures"
    versionType = "beta"
    version = project.version.toString()
    displayName = tasks.remapJar.get().archiveBaseName.get() + '-' + version
    changelog = "test changelog"
    artifact = tasks.remapJar
    gameVersions = listOf(minecraftVersion)
    loaders = listOf("forge")
    curseEnvironment = "both"
    val depends = mutableListOf(
        "architectury-api",
        "generations"
    )
    curseDepends.required = depends
    modrinthDepends.required = depends
}

publishing {
    publications.create<MavenPublication>("mavenForge") {
        artifactId = "${project.properties["archives_base_name"]}" + "-Forge"
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