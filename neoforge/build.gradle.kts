import com.hypherionmc.modpublisher.properties.CurseEnvironment
import com.hypherionmc.modpublisher.properties.ModLoader
import com.hypherionmc.modpublisher.properties.ReleaseType

plugins {
    id("com.gradleup.shadow")
    id("com.hypherionmc.modutils.modpublisher") version "2.+"
}

architectury {
    platformSetupLoomIde()
    neoForge()
}

val minecraftVersion = project.properties["minecraft_version"] as String

configurations {
    create("common")
    "common" {
        isCanBeResolved = true
        isCanBeConsumed = false
    }
    create("shadowBundle")
    compileClasspath.get().extendsFrom(configurations["common"])
    runtimeClasspath.get().extendsFrom(configurations["common"])
    getByName("developmentForge").extendsFrom(configurations["common"])
    "shadowBundle" {
        isCanBeResolved = true
        isCanBeConsumed = false
    }
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)

//    forge {
//        convertAccessWideners.set(true)
//        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
//        mixinConfig("GenerationsStructures-common.mixins.json")
//    }

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
    if ((project.properties["use_neoforge"] as String).toBoolean())
        forge("net.neoforged:forge:$minecraftVersion-${project.properties["neoforge_version"]}")
    else forge("net.minecraftforge:forge:$minecraftVersion-${project.properties["forge_version"]}")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowBundle"(project(":common", "transformProductionForge"))

    modLocalRuntime("me.djtheredstoner:DevAuth-forge-latest:${project.properties["devauth_version"]}")

    // Generations-Core Forge
//    modApi("generations.gg.generations.core:Generations-Core-forge:${project.properties["generations-core_version"]}@jar") { isChanging = true }
    modApi(implementation("curse.maven:generations-core-860936:7305007"))

    //Cobblemon
    implementation("thedarkcolour:kotlinforforge-neoforge:5.5.0")
    modApi("com.cobblemon:neoforge:${project.properties["cobblemon_version"]}")

    modApi("tech.jt-dev:MoreStructureProcessors-neoforgeforge:${project.properties["moreprocessors_version"]}") { isChanging = true }

    //BiomeMod Integration
    modLocalRuntime("com.github.glitchfiend:TerraBlender-neoforge:$minecraftVersion-${project.properties["terrablender_version"]}")
    modCompileOnly("com.github.glitchfiend:BiomesOPlenty-neoforge:$minecraftVersion-${project.properties["BOP_version"]}")
    modLocalRuntime("com.github.glitchfiend:GlitchCore-neoforge:$minecraftVersion-${project.properties["GlitchCore_version"]}")
    modRuntimeOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    modApi("net.potionstudios:Oh-The-Biomes-Weve-Gone-NeoForge:${project.properties["BWG_version"]}")
    implementation("com.eliotlash.mclib:mclib:20")
    forgeRuntimeLibrary("com.eliotlash.mclib:mclib:20")

    //WorldEdit
    modLocalRuntime("curse.maven:worldedit-225608:5830452")
}

tasks {
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
        configurations = listOf(project.configurations.getByName("shadowBundle"))
        archiveClassifier.set("dev-shadow")
    }

    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
        dependsOn(shadowJar)
    }
}

publisher {
    apiKeys {
        curseforge(getPublishingCredentials().first)
        modrinth(getPublishingCredentials().second)
        github(project.properties["github_token"].toString())
    }

    curseID.set("944403")
    modrinthID.set("vuBdsrzF")
    githubRepo.set("https://github.com/GenerationsMod/Generations-Structures")
    setReleaseType(ReleaseType.RELEASE)
    projectVersion.set(project.version.toString() + "-${project.name}")
    displayName.set(base.archivesName.get() + "-${project.version}")
    changelog.set(projectDir.toPath().parent.resolve("CHANGELOG.md").toFile().readText())
    artifact.set(tasks.remapJar)
    setGameVersions(minecraftVersion)
    setLoaders(ModLoader.FORGE, ModLoader.NEOFORGE)
    setCurseEnvironment(CurseEnvironment.BOTH)
    setJavaVersions(JavaVersion.VERSION_17, JavaVersion.VERSION_18, JavaVersion.VERSION_19, JavaVersion.VERSION_20, JavaVersion.VERSION_21, JavaVersion.VERSION_22)
    val depends = mutableListOf("generations-core", "more-structure-processors")
    val softDepends = mutableListOf("biomes-o-plenty", "oh-the-biomes-weve-gone")
    curseDepends.required.set(depends)
    curseDepends.optional.set(softDepends)
    modrinthDepends.required.set(depends)
    modrinthDepends.optional.set(softDepends)
}

private fun getPublishingCredentials(): Pair<String?, String?> {
    val curseForgeToken = (project.findProperty("curseforge_token") ?: System.getenv("CURSEFORGE_TOKEN") ?: "") as String?
    val modrinthToken = (project.findProperty("modrinth_token") ?: System.getenv("MODRINTH_TOKEN") ?: "") as String?
    return Pair(curseForgeToken, modrinthToken)
}