import com.hypherionmc.modpublisher.properties.CurseEnvironment
import com.hypherionmc.modpublisher.properties.ModLoader
import com.hypherionmc.modpublisher.properties.ReleaseType

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.hypherionmc.modutils.modpublisher") version "2.+"
}

architectury {
    platformSetupLoomIde()
    forge()
}

val minecraftVersion = project.properties["minecraft_version"] as String
val jarName = base.archivesName.get() + "-Forge"

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
    if ((project.properties["use_neoforge"] as String).toBoolean())
        forge("net.neoforged:forge:$minecraftVersion-${project.properties["neoforge_version"]}")
    else forge("net.minecraftforge:forge:$minecraftVersion-${project.properties["forge_version"]}")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowCommon"(project(":common", "transformProductionForge")) { isTransitive = false }

    modRuntimeOnly("me.djtheredstoner:DevAuth-forge-latest:${project.properties["devauth_version"]}")

    // Generations-Core Forge
    modApi("generations.gg.generations.core:Generations-Core-Forge:${project.properties["generations-core_version"]}@jar") { isChanging = true }
    modRuntimeOnly("dev.architectury:architectury-forge:${project.properties["architectury_version"]}")
    modRuntimeOnly("earth.terrarium.botarium:botarium-forge-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    implementation("thedarkcolour:kotlinforforge:4.10.0")
    modApi("com.cobblemon:forge:${project.properties["cobblemon_version"]}")

    //BiomeMod Integration
    modApi("com.github.glitchfiend:TerraBlender-forge:$minecraftVersion-${project.properties["terrablender_version"]}")
    modApi("com.github.glitchfiend:BiomesOPlenty:$minecraftVersion-${project.properties["BOP_version"]}")
    modRuntimeOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

tasks {
    base.archivesName.set(jarName)
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
    apiKeys {
        curseforge(getPublishingCredentials().first)
        modrinth(getPublishingCredentials().second)
        github(project.properties["github_token"].toString())
    }

    curseID.set("944403")
    modrinthID.set("vuBdsrzF")
    githubRepo.set("https://github.com/GenerationsMod/Generations-Structures")
    setReleaseType(ReleaseType.BETA)
    projectVersion.set(project.version.toString())
    displayName.set("$jarName-${projectVersion.get()}")
    changelog.set("test changelog")
    artifact.set(tasks.remapJar)
    setGameVersions(minecraftVersion)
    setLoaders(ModLoader.FORGE, ModLoader.NEOFORGE)
    setCurseEnvironment(CurseEnvironment.SERVER)
    setJavaVersions(JavaVersion.VERSION_17, JavaVersion.VERSION_18)
    val depends = mutableListOf("generations-core")
    val softDepends = mutableListOf("biomes-o-plenty")
    curseDepends.required.set(depends)
    curseDepends.optional.set(softDepends)
    modrinthDepends.required.set(depends)
    modrinthDepends.optional.set(softDepends)
}


publishing {
    publications.create<MavenPublication>("mavenForge") {
        artifactId = jarName
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
                username = getGensCredentials().first
                password = getGensCredentials().second
            }
        }
    }
}

private fun getGensCredentials(): Pair<String?, String?> {
    val username = (project.findProperty("gensUsername") ?: System.getenv("GENS_USERNAME") ?: "") as String?
    val password = (project.findProperty("gensPassword") ?: System.getenv("GENS_PASSWORD") ?: "") as String?
    return Pair(username, password)
}

private fun getPublishingCredentials(): Pair<String?, String?> {
    val curseForgeToken = (project.findProperty("curseforge_token") ?: System.getenv("CURSEFORGE_TOKEN") ?: "") as String?
    val modrinthToken = (project.findProperty("modrinth_token") ?: System.getenv("MODRINTH_TOKEN") ?: "") as String?
    return Pair(curseForgeToken, modrinthToken)
}