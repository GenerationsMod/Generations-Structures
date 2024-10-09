architectury {
    common("forge", "fabric")
    platformSetupLoomIde()
}

val minecraftVersion = project.properties["minecraft_version"] as String

loom.accessWidenerPath.set(file("src/main/resources/generations_structures.accesswidener"))

sourceSets.main.get().resources.srcDir("src/main/generated/resources")

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${project.properties["fabric_loader_version"]}")

    modCompileOnly("generations.gg.generations.core:Generations-Core-common:${project.properties["generations-core_version"]}") { isChanging = true }
    modCompileOnly("earth.terrarium.botarium:botarium-common-$minecraftVersion:${project.properties["botarium_version"]}")
    modCompileOnly("tech.jt-dev:MoreStructureProcessors-common:${project.properties["moreprocessors_version"]}") { isChanging = true }

    //Cobblemon
    modCompileOnly("com.cobblemon:mod:${project.properties["cobblemon_version"]}")

    //BiomeMod Integration
    modCompileOnly("net.potionstudios:Oh-The-Biomes-Weve-Gone-Common:${project.properties["BWG_version"]}")
    modCompileOnly("com.github.glitchfiend:BiomesOPlenty-common:$minecraftVersion-${project.properties["BOP_version"]}")
}
