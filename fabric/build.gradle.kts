import com.hypherionmc.modpublisher.properties.CurseEnvironment
import com.hypherionmc.modpublisher.properties.ModLoader

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.hypherionmc.modutils.modpublisher") version "2.+"
}

architectury {
    platformSetupLoomIde()
    fabric()
}

val minecraftVersion = project.properties["minecraft_version"] as String

configurations {
    create("common")
    create("shadowCommon")
    compileClasspath.get().extendsFrom(configurations["common"])
    runtimeClasspath.get().extendsFrom(configurations["common"])
    getByName("developmentFabric").extendsFrom(configurations["common"])
}

loom.accessWidenerPath.set(project(":common").loom.accessWidenerPath)

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${project.properties["fabric_loader_version"]}")
    modApi("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_api_version"]}+$minecraftVersion")

    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowCommon"(project(":common", "transformProductionFabric")) { isTransitive = false }

    modRuntimeOnly("me.djtheredstoner:DevAuth-fabric:${project.properties["devauth_version"]}")

    // Generations-Core Fabric
    modApi("generations.gg.generations.core:Generations-Core-Fabric:${project.properties["generations-core_version"]}") { isChanging = true }
    modRuntimeOnly("dev.architectury:architectury-fabric:${project.properties["architectury_version"]}")
    modRuntimeOnly("earth.terrarium:botarium-fabric-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    modApi("com.cobblemon:fabric:${project.properties["cobblemon_version"]}")
    modRuntimeOnly("net.fabricmc:fabric-language-kotlin:1.10.16+kotlin.1.9.21")

    //BiomeMod Integration
    modApi("com.github.glitchfiend:TerraBlender-fabric:$minecraftVersion-${project.properties["terrablender_version"]}")
    //modCompileOnly("curse.maven:oh-the-biomes-youll-go-fabric-391378:${project.properties["BYGFabric_version"]}")
    //modCompileOnly("curse.maven:CorgiLib-693313:4681375")
    //modCompileOnly("software.bernie.geckolib:geckolib-fabric-$minecraftVersion:${project.properties["geckolib_version"]}")

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
        exclude(".cache/**", "architectury.common.json")
        configurations = listOf(project.configurations.getByName("shadowCommon"))
        archiveClassifier.set("dev-shadow")
    }

    remapJar {
        injectAccessWidener.set(true)
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
        curseforge(project.properties["curseforge_token"].toString())
        modrinth(project.properties["modrinth_token"].toString())
        github(project.properties["github_token"].toString())
    }

    curseID.set("944403")
    modrinthID.set("e1GvDbBX")  //TODO I need to change this later
    githubRepo.set("https://github.com/GenerationsMod/Generations-Structures")
    versionType.set("beta")
    version.set(project.version.toString())
    displayName.set(tasks.remapJar.get().archiveBaseName.get() + '-' + version)
    changelog.set("test changelog")
    artifact.set(tasks.remapJar)
    gameVersions = listOf(minecraftVersion)
    setLoaders(ModLoader.FABRIC, ModLoader.QUILT)
    setCurseEnvironment(CurseEnvironment.BOTH)
    val depends = mutableListOf(
        "fabric-api",
        "architectury-api",
        "generations"
    )
    curseDepends.required = depends
    modrinthDepends.required = depends
}

publishing {
    publications.create<MavenPublication>("mavenFabric") {
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