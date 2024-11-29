package generations.gg.generations.structures.generationsstructures.structures;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;
import java.util.Optional;

public class GenerationsStructureSettings {

    public static final Map<ResourceKey<Structure>, StructureFactory> STRUCTURE_FACTORIES = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<Structure> BEAST_BALLOON = register("loot_balloon/beast", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.BEAST_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> GREAT_BALLOON = register("loot_balloon/great", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.GREAT_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> MASTER_BALLOON = register("loot_balloon/master", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.MASTER_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> POKE_BALLOON = register("loot_balloon/poke", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.POKE_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> ULTRA_BALLOON = register("loot_balloon/ultra", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.ULTRA_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> MEOWTH_BALLOON = register("loot_balloon/meowth", (context) ->
            balloonJigsawStructure(context, GenerationsTemplatePools.MEOWTH_BALLOON, GenerationsBiomeTags.HAS_LOOT_BALLOON));

    public static final ResourceKey<Structure> COMET = register("comet", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_COMET), TerrainAdjustment.NONE),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.COMET), 1,
                    UniformHeight.of(VerticalAnchor.absolute(250), VerticalAnchor.belowTop(150)), false));

    public static final ResourceKey<Structure> SCARLET_POKECENTER = register("scarlet_pokecenter", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_POKECENTER), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.SCARLET_POKECENTER), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> LARGE_POKECENTER = register("large_pokecenter", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_POKECENTER), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.LARGE_POKECENTER), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> FROZEN_SHRINE = register("shrines/frozen", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_FROZEN_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.FROZEN_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> FIERY_SHRINE = register("shrines/fiery", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_FIERY_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.FIERY_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> STATIC_SHRINE = register("shrines/static", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_STATIC_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.STATIC_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> LUGIA_SHRINE = register("shrines/lugia", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_LUGIA_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.LUGIA_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> REGI_SHRINE = register("shrines/regi", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_REGI_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.REGI_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> CREATION_TRIO_SHRINE = register("shrines/creation_trio", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_CREATION_TRIO_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.CREATION_TRIO_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> GROUDON_SHRINE = register("shrines/groudon", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_GROUDON_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.GROUDON_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> FORCES_OF_NATURE_SHRINE = register("shrines/forces_of_nature", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_FORCES_OF_NATURE_SHRINE), TerrainAdjustment.NONE),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.FORCES_OF_NATURE_SHRINE), 1,
                    BiasedToBottomHeight.of(VerticalAnchor.absolute(80), VerticalAnchor.belowTop(135), 1), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> TAPU_SHRINE = register("shrines/tapu", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_TAPU_SHRINE), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.TAPU_SHRINE), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> HAUNTED_MANSION = register("shrines/haunted_mansion", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_HAUNTED_MANSION), TerrainAdjustment.BEARD_THIN),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.HAUNTED_MANSION), 1,
                    ConstantHeight.of(VerticalAnchor.absolute(1)), Heightmap.Types.WORLD_SURFACE_WG));

    public static final ResourceKey<Structure> ISLANDS = register("islands", (context) ->
            createJigsaw(structure(context.lookup(Registries.BIOME).getOrThrow(GenerationsBiomeTags.HAS_ISLANDS), TerrainAdjustment.NONE),
                    context.lookup(Registries.TEMPLATE_POOL).getOrThrow(GenerationsTemplatePools.ISLANDS), 1,
                    UniformHeight.of(VerticalAnchor.absolute(150), VerticalAnchor.belowTop(100)), false));

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

    private static JigsawStructure balloonJigsawStructure(BootstapContext<Structure> context, ResourceKey<StructureTemplatePool> templatePool, TagKey<Biome> biomeTag){
        return createJigsaw(new Structure.StructureSettings(context.lookup(Registries.BIOME).getOrThrow(biomeTag), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
                context.lookup(Registries.TEMPLATE_POOL).getOrThrow(templatePool), 1, BiasedToBottomHeight.of(VerticalAnchor.absolute(80), VerticalAnchor.belowTop(135), 1), Heightmap.Types.WORLD_SURFACE_WG);
    }

    private static ResourceKey<Structure> register(String id, StructureFactory factory) {
        ResourceKey<Structure> structureSetResourceKey = GenerationsStructures.key(Registries.STRUCTURE, id);
        STRUCTURE_FACTORIES.put(structureSetResourceKey, factory);
        return structureSetResourceKey;
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> tag, TerrainAdjustment adj) {
        return Structures.structure(tag, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, adj);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> tag, Map<MobCategory, StructureSpawnOverride> spawnOverrides, TerrainAdjustment adj) {
        return Structures.structure(tag, spawnOverrides, GenerationStep.Decoration.SURFACE_STRUCTURES, adj);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> tag, GenerationStep.Decoration decoration, TerrainAdjustment adj) {
        return Structures.structure(tag, Map.of(), decoration, adj);
    }

    @FunctionalInterface
    public interface StructureFactory {
        Structure generate(BootstapContext<Structure> structureFactoryBootstapContext);
    }

    public static void structures() {
        GenerationsStructures.LOGGER.info("Registering Generations-Structures Structures and Structure Settings");
    }
}
