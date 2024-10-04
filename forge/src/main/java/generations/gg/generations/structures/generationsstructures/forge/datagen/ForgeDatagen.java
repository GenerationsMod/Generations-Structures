package generations.gg.generations.structures.generationsstructures.forge.datagen;

import biomesoplenty.api.biome.BOPBiomes;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.GenerationsProcessorLists;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructureSettings;
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
        GenerationsStructureSets.init();
        generator.addProvider(true, new DatapackBuiltinEntriesProvider(output, lookup, BUILDER, Set.of(GenerationsStructures.MOD_ID)));
    }

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TEMPLATE_POOL, context -> GenerationsTemplatePools.TEMPLATE_POOL_FACTORIES.forEach((key, factory) -> context.register(key, factory.generate(context))))
            .add(Registries.STRUCTURE, context -> GenerationsStructureSettings.STRUCTURE_FACTORIES.forEach((key, factory) -> context.register(key, factory.generate(context))))
            .add(Registries.STRUCTURE_SET, context -> GenerationsStructureSets.STRUCTURE_SET_FACTORIES.forEach((key, factory) -> context.register(key, factory.generate(context.lookup(Registries.STRUCTURE)))))
            .add(Registries.PROCESSOR_LIST, context -> GenerationsProcessorLists.STRUCTURE_PROCESSOR_LIST_FACTORIES.forEach((key, factory) -> context.register(key, factory.generate(context.lookup(Registries.PROCESSOR_LIST)))));

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
        }
    }

    private static class GenerationsStructureTagsProvider extends StructureTagsProvider {

        public GenerationsStructureTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsStructureTags.POKESHOP)
                    .addOptional(GenerationsStructureSettings.SCARLET_POKECENTER.location())
                    .addOptional(GenerationsStructureSettings.LARGE_POKECENTER.location());
            tag(GenerationsStructureTags.LOOT_BALLOONS)
                    .addOptional(GenerationsStructureSettings.POKE_BALLOON.location())
                    .addOptional(GenerationsStructureSettings.GREAT_BALLOON.location())
                    .addOptional(GenerationsStructureSettings.ULTRA_BALLOON.location())
                    .addOptional(GenerationsStructureSettings.MASTER_BALLOON.location())
                    .addOptional(GenerationsStructureSettings.BEAST_BALLOON.location())
                    .addOptional(GenerationsStructureSettings.MEOWTH_BALLOON.location());
            tag(GenerationsStructureTags.SHRINES)
                    .addOptional(GenerationsStructureSettings.FROZEN_SHRINE.location())
                    .addOptional(GenerationsStructureSettings.FIERY_SHRINE.location())
                    .addOptional(GenerationsStructureSettings.STATIC_SHRINE.location());

            tag(GenerationsStructureTags.GENERATIONS_STRUCTURES)
                    .addTag(GenerationsStructureTags.POKESHOP)
                    .addTag(GenerationsStructureTags.LOOT_BALLOONS)
                    //.addTag(GenerationsStructureTags.GYMS)
                    .addTag(GenerationsStructureTags.SHRINES)
                    .addOptional(GenerationsStructureSettings.COMET.location())
                    .addOptional(GenerationsStructureSettings.ISLANDS.location());

        }
    }

    private static ResourceLocation fabricTagMaker(String name) {
        return new ResourceLocation("c", name);
    }

}
