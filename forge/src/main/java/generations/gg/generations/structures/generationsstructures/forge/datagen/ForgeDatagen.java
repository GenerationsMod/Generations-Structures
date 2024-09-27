package generations.gg.generations.structures.generationsstructures.forge.datagen;

import biomesoplenty.api.biome.BOPBiomes;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.GenerationsProcessorLists;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructureSettings;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsStructureTags;
import generations.gg.generations.structures.generationsstructures.worldgen.structure_set.GenerationsStructureSets;
import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * This class is used to register the data generators for the mod.
 * @see GatherDataEvent
 * @author J.T. McQuigg (JT122406)
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = GenerationsStructures.MOD_ID)
public class ForgeDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        generator.addProvider(true, new GenerationsStructuresBiomeTagsProvider(output, lookup, event.getExistingFileHelper()));
        generator.addProvider(true, new GenerationsStructureTagsProvider(output, lookup, event.getExistingFileHelper()));
        generator.addProvider(true, new DatapackBuiltinEntriesProvider(output, lookup, BUILDER, Set.of(GenerationsStructures.MOD_ID)));
    }

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TEMPLATE_POOL, GenerationsTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, GenerationsStructureSettings::bootstrap)
            .add(Registries.STRUCTURE_SET, GenerationsStructureSets::bootstrap)
            .add(Registries.PROCESSOR_LIST, GenerationsProcessorLists::bootstrap);

    private static class GenerationsStructuresBiomeTagsProvider extends BiomeTagsProvider {

        public GenerationsStructuresBiomeTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsBiomeTags.IS_NOT_MOUNTAIN)
                    .addTag(BiomeTags.IS_BADLANDS).addTag(BiomeTags.IS_BEACH).addTag(BiomeTags.IS_OCEAN).addTag(BiomeTags.IS_FOREST)
                            .addTag(BiomeTags.IS_HILL).addTag(BiomeTags.IS_JUNGLE).addTag(BiomeTags.IS_TAIGA).addTag(BiomeTags.IS_RIVER)
                            .addOptionalTag(Tags.Biomes.IS_PLAINS).addOptionalTag(Tags.Biomes.IS_DESERT)
                            .addOptionalTag(fabricTagMaker("plains"));

            tag(GenerationsBiomeTags.HAS_POKECENTER)
                    .addTag(BiomeTags.IS_SAVANNA)
                    .addOptionalTag(Tags.Biomes.IS_PLAINS.location())
                    .addOptionalTag(Tags.Biomes.IS_SPARSE_OVERWORLD)
                    .addOptionalTag(fabricTagMaker("plains"));

            tag(GenerationsBiomeTags.HAS_LOOT_BALLOON)
                    .addTag(GenerationsBiomeTags.IS_NOT_MOUNTAIN);

            tag(GenerationsBiomeTags.HAS_COMET)
                    .addTag(GenerationsBiomeTags.IS_NOT_MOUNTAIN)
                    .addTag(BiomeTags.IS_END)
                    .addOptionalTag(fabricTagMaker("in_the_end"));

            tag(GenerationsBiomeTags.HAS_ISLANDS)
                    .addTag(GenerationsBiomeTags.IS_NOT_MOUNTAIN);

            tag(GenerationsBiomeTags.HAS_FROZEN_SHRINE)
                    .addOptionalTag(fabricTagMaker("icy"))
                    .add(Biomes.ICE_SPIKES, Biomes.FROZEN_PEAKS);

            tag(GenerationsBiomeTags.HAS_FIERY_SHRINE)
                    .addTag(BiomeTags.IS_NETHER)
                    .addOptionalTag(Tags.Biomes.IS_DESERT)
                    .addOptionalTag(fabricTagMaker("desert"))
                    .addOptional(BOPBiomes.VOLCANIC_PLAINS.location());

            tag(GenerationsBiomeTags.HAS_STATIC_SHRINE)
                    .addTag(BiomeTags.IS_SAVANNA);

            tag(GenerationsBiomeTags.HAS_LUGIA_SHRINE)
                    .addTag(BiomeTags.IS_MOUNTAIN)
                    .addTag(BiomeTags.IS_FOREST);

            tag(GenerationsBiomeTags.HAS_BURNED_TOWER_SHRINE)
                    .addOptionalTag(fabricTagMaker("savanna"))
                    .add(Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA);

            tag(GenerationsBiomeTags.HAS_CREATION_TRIO_SHRINE)
                    .addOptionalTag(fabricTagMaker("badlands"))
                    .add(Biomes.END_BARRENS, Biomes.WINDSWEPT_SAVANNA, Biomes.BADLANDS);

            tag(GenerationsBiomeTags.HAS_FORCES_OF_NATURE_SHRINE)
                    .addOptionalTag(fabricTagMaker("floral"))
                    .add(Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.SUNFLOWER_PLAINS);

            tag(GenerationsBiomeTags.HAS_LUNAR_DUO_SHRINE)
                    .addOptionalTag(fabricTagMaker("floral_forests"))
                    .add(Biomes.DARK_FOREST, Biomes.FLOWER_FOREST);

            tag(GenerationsBiomeTags.HAS_GROUDON_SHRINE)
                    .addOptionalTag(fabricTagMaker("desert"))
                    .add(Biomes.DESERT);

            tag(GenerationsBiomeTags.HAS_KYOGRE_SHINE)
                    .addOptionalTag(fabricTagMaker("deep_ocean"))
                    .add(Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);

            tag(GenerationsBiomeTags.HAS_REGI_SHRINE)
                    .addOptionalTag(fabricTagMaker("icy"))
                    .add(Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.ICE_SPIKES);

            tag(GenerationsBiomeTags.HAS_TAPU_SHRINE)
                    .addOptionalTag(fabricTagMaker("jungle"))
                    .add(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE);
        }
    }

    private static class GenerationsStructureTagsProvider extends StructureTagsProvider {

        public GenerationsStructureTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsStructureTags.POKESHOP)
                    .addOptional(GenerationsStructuresKeys.SCARLET_POKECENTER.location())
                    .addOptional(GenerationsStructuresKeys.LARGE_POKECENTER.location());
            tag(GenerationsStructureTags.LOOT_BALLOONS)
                    .addOptional(GenerationsStructuresKeys.POKE_BALLOON.location())
                    .addOptional(GenerationsStructuresKeys.GREAT_BALLOON.location())
                    .addOptional(GenerationsStructuresKeys.ULTRA_BALLOON.location())
                    .addOptional(GenerationsStructuresKeys.MASTER_BALLOON.location())
                    .addOptional(GenerationsStructuresKeys.BEAST_BALLOON.location())
                    .addOptional(GenerationsStructuresKeys.MEOWTH_BALLOON.location());
            tag(GenerationsStructureTags.SHRINES)
                    .addOptional(GenerationsStructuresKeys.FROZEN_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.FIERY_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.STATIC_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.LUGIA_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.FROZEN_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.BURNED_TOWER_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.CREATION_TRIO_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.LUNAR_DUO_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.FORCES_OF_NATURE_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.GROUDON_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.KYOGRE_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.REGI_SHRINE.location())
                    .addOptional(GenerationsStructuresKeys.TAPU_SHRINE.location());

            tag(GenerationsStructureTags.GENERATIONS_STRUCTURES)
                    .addTag(GenerationsStructureTags.POKESHOP)
                    .addTag(GenerationsStructureTags.LOOT_BALLOONS)
                    //.addTag(GenerationsStructureTags.GYMS)
                    .addTag(GenerationsStructureTags.SHRINES)
                    .addOptional(GenerationsStructuresKeys.COMET.location())
                    .addOptional(GenerationsStructuresKeys.ISLANDS.location());

        }
    }

    private static ResourceLocation fabricTagMaker(String name) {
        return new ResourceLocation("c", name);
    }

}
