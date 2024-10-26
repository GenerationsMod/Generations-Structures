import com.hypherionmc.modpublisher.properties.CurseEnvironment
import com.hypherionmc.modpublisher.properties.ModLoader
import com.hypherionmc.modpublisher.properties.ReleaseType

plugins {
    id("com.gradleup.shadow")
    id("com.hypherionmc.modutils.modpublisher") version "2.+"
}

architectury {
    platformSetupLoomIde()
    fabric()
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
    getByName("developmentFabric").extendsFrom(configurations["common"])
    "shadowBundle" {
        isCanBeResolved = true
        isCanBeConsumed = false
    }
}

loom.accessWidenerPath.set(project(":common").loom.accessWidenerPath)

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${project.properties["fabric_loader_version"]}")
    modApi("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_api_version"]}+$minecraftVersion")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowBundle"(project(":common", "transformProductionFabric"))

    modLocalRuntime("me.djtheredstoner:DevAuth-fabric:${project.properties["devauth_version"]}")

    // Generations-Core Fabric
    modApi("generations.gg.generations.core:Generations-Core-fabric:${project.properties["generations-core_version"]}") { isChanging = true }
    modRuntimeOnly("dev.architectury:architectury-fabric:${project.properties["architectury_version"]}")
    modRuntimeOnly("earth.terrarium.botarium:botarium-fabric-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    modApi("com.cobblemon:fabric:${project.properties["cobblemon_version"]}")
    modRuntimeOnly("net.fabricmc:fabric-language-kotlin:1.12.1+kotlin.2.0.20")

    modApi("tech.jt-dev:MoreStructureProcessors-fabric:${project.properties["moreprocessors_version"]}") { isChanging = true }

    //BiomeMod Integration
    modLocalRuntime("com.github.glitchfiend:TerraBlender-fabric:$minecraftVersion-${project.properties["terrablender_version"]}")
    modApi("net.potionstudios:Oh-The-Biomes-Weve-Gone-Fabric:${project.properties["BWG_version"]}")
    modApi("com.github.glitchfiend:BiomesOPlenty-fabric:$minecraftVersion-${project.properties["BOP_version"]}")
    modLocalRuntime("com.github.glitchfiend:GlitchCore-fabric:$minecraftVersion-${project.properties["GlitchCore_version"]}")
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to project.version))
        }
    }

    shadowJar {
        exclude(".cache/**", "architectury.common.json")
        configurations = listOf(project.configurations.getByName("shadowBundle"))
        archiveClassifier.set("dev-shadow")
    }

    remapJar {
        injectAccessWidener.set(true)
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
    setReleaseType(ReleaseType.BETA)
    projectVersion.set(project.version.toString() + "-${project.name}")
    displayName.set(base.archivesName.get() + "-${project.version}")
    changelog.set(projectDir.toPath().parent.resolve("CHANGELOG.md").toFile().readText())
    artifact.set(tasks.remapJar)
    setGameVersions(minecraftVersion)
    setLoaders(ModLoader.FABRIC, ModLoader.QUILT)
    setCurseEnvironment(CurseEnvironment.BOTH)
    setJavaVersions(JavaVersion.VERSION_17, JavaVersion.VERSION_18, JavaVersion.VERSION_19, JavaVersion.VERSION_20, JavaVersion.VERSION_21, JavaVersion.VERSION_22)
    val depends = mutableListOf("fabric-api", "generations-core", "more-structure-processors")
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