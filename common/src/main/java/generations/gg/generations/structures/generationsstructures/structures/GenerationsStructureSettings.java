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
        registerStructure(context, GenerationsStructuresKeys.POKE_BALLOON, balloonJigsawStructure(poolHolderGetter.getOrThrow(GenerationsTemplatePools.POKE_BALLOON), biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LOOT_BALLOON)));
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
                1,
                UniformHeight.of(VerticalAnchor.absolute(250), VerticalAnchor.belowTop(150)),
                false
        ));
        registerStructure(context, GenerationsStructuresKeys.SCARLET_POKECENTER, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_SCARLET_POKECENTER),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.SCARLET_POKECENTER),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        registerStructure(context, GenerationsStructuresKeys.SPIKE,
                createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_SPIKE),
                        Map.of(),
                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.SPIKE),
                1,
                UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.belowTop(100)),
                false
        ));

        registerStructure(context, GenerationsStructuresKeys.FROZEN_SHRINE, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_FROZEN_SHRINE),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.FROZEN_SHRINE),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        registerStructure(context, GenerationsStructuresKeys.FIERY_SHRINE, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_FIERY_SHRINE),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.FIERY_SHRINE),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        registerStructure(context, GenerationsStructuresKeys.STATIC_SHRINE, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_STATIC_SHRINE),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.STATIC_SHRINE),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        registerStructure(context, GenerationsStructuresKeys.LUGIA_SHRINE, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_LUGIA_SHRINE),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.BEARD_THIN
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.LUGIA_SHRINE),
                1,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                Heightmap.Types.WORLD_SURFACE_WG
        ));

        registerStructure(context, GenerationsStructuresKeys.ISLANDS, createJigsaw(
                new Structure.StructureSettings(
                        biomeHolderGetter.getOrThrow(GenerationsBiomeTags.HAS_ISLANDS),
                        Map.of(),
                        GenerationStep.Decoration.SURFACE_STRUCTURES,
                        TerrainAdjustment.NONE
                ),
                poolHolderGetter.getOrThrow(GenerationsTemplatePools.ISLANDS),
                1,
                UniformHeight.of(VerticalAnchor.absolute(150), VerticalAnchor.belowTop(100)),
                false
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

    private static JigsawStructure createJigsaw(Structure.StructureSettings settings, Holder<StructureTemplatePool> startPool, int maxDepth,
                                                HeightProvider startHeight, boolean useExpansionHack){
        return new JigsawStructure(settings, startPool, maxDepth, startHeight, useExpansionHack);
    }

    private static JigsawStructure createJigsaw(Structure.StructureSettings settings, Holder<StructureTemplatePool> startPool, int maxDepth,
                                                HeightProvider startHeight, Heightmap.Types projectStartToHeightmap){
        return new JigsawStructure(settings, startPool, maxDepth, startHeight, false, projectStartToHeightmap);
    }

    private static JigsawStructure balloonJigsawStructure(Holder<StructureTemplatePool> poolHolderGetter, HolderSet<Biome> biomeHolderGetter){
        return createJigsaw(new Structure.StructureSettings(biomeHolderGetter, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
                poolHolderGetter, 1, UniformHeight.of(VerticalAnchor.absolute(180), VerticalAnchor.belowTop(110)), false);
    }
}
