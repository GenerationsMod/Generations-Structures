package generations.gg.generations.structures.generationsstructures.structures;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public class GenerationsStructureSettings {

    public static void bootstrap(BootstapContext<Structure> context) {

    }

    private static void registerJigsaw(BootstapContext<Structure> context, ResourceKey<Structure> structure, Structure.StructureSettings settings, ResourceKey<StructureTemplatePool> pool, int min, int mac){
        context.register(structure, new JigsawStructure(settings, context.lookup(Registries.TEMPLATE_POOL).getOrThrow(pool)));
    }
}
