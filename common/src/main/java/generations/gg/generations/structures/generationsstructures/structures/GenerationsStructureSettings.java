package generations.gg.generations.structures.generationsstructures.structures;

import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;
import java.util.Optional;

public class GenerationsStructureSettings {

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> poolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);

        registerStructure(context, GenerationsStructuresKeys.BEAST_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.BEAST_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.GREAT_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.GREAT_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.MASTER_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.MASTER_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.NORMAL_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.NORMAL_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.ULTRA_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.ULTRA_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.MEOWTH_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.MEOWTH_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
        registerStructure(context, GenerationsStructuresKeys.COMET, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_COMET),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.NONE
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.COMET),
                Optional.empty(),
                1,
                UniformHeight.of(VerticalAnchor.absolute(250), VerticalAnchor.belowTop(150)),
                false,
                Optional.empty(),
                80
        ));
        registerStructure(context, GenerationsStructuresKeys.SCARLET_POKESHOP, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_SCARLET_POKESHOP),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.SCARLET_POKESHOP),
                Optional.empty(),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                false,
                Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                80
        ));
        registerStructure(context, GenerationsStructuresKeys.SPIKE, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_SPIKE),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.NONE
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.SPIKE),
                Optional.empty(),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(10)),
                false,
                Optional.empty(),
                75
        ));
    }

    private static void registerStructure(BootstapContext<Structure> context, ResourceKey<Structure> structureResourceKey, Structure structure){
        context.register(structureResourceKey, structure);
    }

    private static JigsawStructure createJigsaw(Structure.StructureSettings settings, Holder<StructureTemplatePool> startPool,
                                                Optional<ResourceLocation> startJigsawName, int maxDepth,
                                                HeightProvider startHeight, boolean useExpansionHack,
                                                Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceToCenter){
        return new JigsawStructure(settings, startPool, startJigsawName, maxDepth, startHeight, useExpansionHack, projectStartToHeightmap, maxDistanceToCenter);
    }

    private static JigsawStructure balloonJigsawStructure(Holder<StructureTemplatePool> poolHolderGetter, HolderSet<Biome> biomeHolderGetter){
        return new JigsawStructure(new Structure.StructureSettings(
                biomeHolderGetter,
                Map.of(),
                GenerationStep.Decoration.SURFACE_STRUCTURES,
                TerrainAdjustment.NONE
        ),
                poolHolderGetter,
                Optional.empty(),
                1,
                UniformHeight.of(VerticalAnchor.absolute(260), VerticalAnchor.belowTop(160)),
                false,
                Optional.empty(),
                80);
    }
}
