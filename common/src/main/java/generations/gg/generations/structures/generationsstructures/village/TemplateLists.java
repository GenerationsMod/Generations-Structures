package generations.gg.generations.structures.generationsstructures.village;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

public class TemplateLists {
    private final ResourceKey<StructureTemplatePool> POKECENTER;
    private final ResourceKey<StructureTemplatePool> POKEMART;

    public TemplateLists(@NotNull ResourceKey<StructureTemplatePool> POKECENTER, @NotNull ResourceKey<StructureTemplatePool> POKEMART) {
        this.POKECENTER = POKECENTER;
        this.POKEMART = POKEMART;
    }

    public static TemplateLists of(@NotNull ResourceKey<StructureTemplatePool> POKECENTER, @NotNull ResourceKey<StructureTemplatePool> POKEMART) {
        return new TemplateLists(POKECENTER, POKEMART);
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeCenter() {
        return POKECENTER;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeMart() {
        return POKEMART;
    }
}
