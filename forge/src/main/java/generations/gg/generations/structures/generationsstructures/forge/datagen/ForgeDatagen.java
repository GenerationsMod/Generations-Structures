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

            tag(GenerationsBiomeTags.HAS_SCARLET_POKECENTER)
                    .addTag(BiomeTags.IS_OVERWORLD)
                    .addOptionalTag(Tags.Biomes.IS_PLAINS.location())
                    .addOptionalTag(fabricTagMaker("plains"));

            tag(GenerationsBiomeTags.HAS_LOOT_BALLOON)
                    .addTag(GenerationsBiomeTags.IS_NOT_MOUNTAIN);

            tag(GenerationsBiomeTags.HAS_COMET)
                    .addTag(GenerationsBiomeTags.IS_NOT_MOUNTAIN)
                    .addTag(BiomeTags.IS_END)
                    .addOptionalTag(fabricTagMaker("in_the_end"));

            tag(GenerationsBiomeTags.HAS_SPIKE)
                    .addTag(BiomeTags.IS_NETHER)
                    .addOptionalTag(fabricTagMaker("in_nether"));

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
        }
    }

    private static class GenerationsStructureTagsProvider extends StructureTagsProvider {

        public GenerationsStructureTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsStructureTags.POKESHOP).addOptional(GenerationsStructuresKeys.SCARLET_POKECENTER.location());
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
                    .addOptional(GenerationsStructuresKeys.LUGIA_SHRINE.location());

            tag(GenerationsStructureTags.GENERATIONS_STRUCTURES)
                    .addTag(GenerationsStructureTags.POKESHOP)
                    .addTag(GenerationsStructureTags.LOOT_BALLOONS)
                    //.addTag(GenerationsStructureTags.GYMS)
                    .addTag(GenerationsStructureTags.SHRINES)
                    .addOptional(GenerationsStructuresKeys.COMET.location())
                    .addOptional(GenerationsStructuresKeys.SPIKE.location())
                    .addOptional(GenerationsStructuresKeys.ISLANDS.location());

        }
    }

    private static ResourceLocation fabricTagMaker(String name) {
        return new ResourceLocation("c", name);
    }

}
