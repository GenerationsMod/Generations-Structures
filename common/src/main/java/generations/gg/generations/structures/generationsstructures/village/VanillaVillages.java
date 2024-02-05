package generations.gg.generations.structures.generationsstructures.village;


import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import org.jetbrains.annotations.NotNull;

public enum VanillaVillages {
    PLAINS("plains", ProcessorLists.STREET_PLAINS, GenerationsTemplatePools.GENERATIONS_PLAINS_STREET),
    DESERT("desert", ProcessorLists.EMPTY, GenerationsTemplatePools.GENERATIONS_DESERT_STREET),
    SAVANNA("savanna", ProcessorLists.STREET_SAVANNA, null),
    SNOWY("snowy", ProcessorLists.STREET_SNOWY_OR_TAIGA, null),
    TAIGA("taiga", ProcessorLists.STREET_SNOWY_OR_TAIGA, null);

    private final String name;
    private final ResourceKey<StructureProcessorList> processorList;
    private final ResourceKey<StructureTemplatePool> pool;

    VanillaVillages(String name, ResourceKey<StructureProcessorList> processorList, ResourceKey<StructureTemplatePool> pool) {
        this.name = name;
        this.processorList = processorList;
        this.pool = pool;
    }

    public String getName() {
        return name;
    }

    public @NotNull ResourceKey<StructureProcessorList> getProcessorList() {
        return processorList;
    }

    public ResourceKey<StructureTemplatePool> getPool() {
        return pool;
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
