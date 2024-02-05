package generations.gg.generations.structures.generationsstructures.village;


import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import org.jetbrains.annotations.NotNull;

public enum VanillaVillages {
    PLAINS("plains", ProcessorLists.STREET_PLAINS, GenerationsTemplatePools.GENERATIONS_PLAINS_STREET, BiomeTags.HAS_VILLAGE_PLAINS),
    DESERT("desert", ProcessorLists.EMPTY, GenerationsTemplatePools.GENERATIONS_DESERT_STREET, BiomeTags.HAS_VILLAGE_DESERT),
    SAVANNA("savanna", ProcessorLists.STREET_SAVANNA, null, BiomeTags.HAS_VILLAGE_SAVANNA),
    SNOWY("snowy", ProcessorLists.STREET_SNOWY_OR_TAIGA, null, BiomeTags.HAS_VILLAGE_SNOWY),
    TAIGA("taiga", ProcessorLists.STREET_SNOWY_OR_TAIGA, null, BiomeTags.HAS_VILLAGE_TAIGA);

    private final String name;
    private final ResourceKey<StructureProcessorList> processorList;
    private final ResourceKey<StructureTemplatePool> pool;
    private final TagKey<Biome> hasVillage;

    VanillaVillages(String name, ResourceKey<StructureProcessorList> processorList, ResourceKey<StructureTemplatePool> pool, TagKey<Biome> hasVillage) {
        this.name = name;
        this.processorList = processorList;
        this.pool = pool;
        this.hasVillage = hasVillage;
    }

    public String getName() {
        return name;
    }

    public @NotNull ResourceKey<StructureProcessorList> getProcessorList() {
        return processorList;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPool() {
        return pool;
    }

    public @NotNull TagKey<Biome> getVillageTag() {
        return hasVillage;
    }

    private static final VanillaVillages[] VALUES = values();

    public static VanillaVillages byName(String name) {
        for (VanillaVillages vanillaVillages : VALUES)
            if (vanillaVillages.getName().equals(name))
                return vanillaVillages;
        return null;
    }

    public static VanillaVillages containsName(String name) {
        for (VanillaVillages vanillaVillages : VALUES)
            if (name.contains(vanillaVillages.getName()))
                return vanillaVillages;
        return null;
    }

}
