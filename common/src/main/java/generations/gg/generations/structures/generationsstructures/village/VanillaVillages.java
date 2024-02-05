package generations.gg.generations.structures.generationsstructures.village;


import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import org.jetbrains.annotations.NotNull;

public enum VanillaVillages {
    PLAINS("plains", ProcessorLists.STREET_PLAINS),
    DESERT("desert", ProcessorLists.EMPTY),
    SAVANNA("savanna", ProcessorLists.STREET_SAVANNA),
    SNOWY("snowy", ProcessorLists.STREET_SNOWY_OR_TAIGA),
    TAIGA("taiga", ProcessorLists.STREET_SNOWY_OR_TAIGA);

    private final String name;
    private final ResourceKey<StructureProcessorList> processorList;

    VanillaVillages(String name, ResourceKey<StructureProcessorList> processorList) {
        this.name = name;
        this.processorList = processorList;
    }

    public String getName() {
        return name;
    }

    public @NotNull ResourceKey<StructureProcessorList> getProcessorList() {
        return processorList;
    }

}
