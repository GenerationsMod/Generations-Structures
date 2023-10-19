architectury {
    common("forge", "fabric")
    platformSetupLoomIde()
}

val minecraftVersion = project.properties["minecraft_version"] as String

sourceSets.main.get().resources.srcDir("src/main/generated/resources")

dependencies {
    // We depend on fabric loader here to use the fabric @Environment annotations
    // Do NOT use other classes from fabric loader
    modImplementation("net.fabricmc:fabric-loader:${project.properties["fabric_loader_version"]}")

    modCompileOnly("generations.gg.generations.core:Generations-Core-Common:${project.properties["generations-core_version"]}") { isChanging = true }
    modCompileOnly("earth.terrarium:botarium-common-$minecraftVersion:${project.properties["botarium_version"]}")

    //Cobblemon
    modCompileOnly("com.cobblemon:mod:${project.properties["cobblemon_version"]}") { isChanging = true }

    //BiomeMod Integration
    modCompileOnly("curse.maven:Oh The Biomes You'll Go-247560:${project.properties["BYGForge_version"]}")
    modCompileOnly("com.github.glitchfiend:TerraBlender-common:$minecraftVersion-${project.properties["terrablender_version"]}")

    //Yungs API
    modCompileOnly("com.yungnickyoung.minecraft.yungsapi:YungsApi:1.20-Common-${project.properties["YUNGAPI_version"]}")
}

publishing {
    publications.create<MavenPublication>("mavenCommon") {
        artifactId = "${project.properties["archives_base_name"]}" + "-Common"
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
