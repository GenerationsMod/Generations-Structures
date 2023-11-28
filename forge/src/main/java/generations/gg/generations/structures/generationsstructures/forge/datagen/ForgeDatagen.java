package generations.gg.generations.structures.generationsstructures.forge.datagen;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructureSettings;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsStructureTags;
import generations.gg.generations.structures.generationsstructures.worldgen.structureset.GenerationsStructureSets;
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
        generator.addProvider(false, new GenerationsStructuresBiomeTagsProvider(output, lookup, event.getExistingFileHelper()));
        generator.addProvider(false, new GenerationsStructureTagsProvider(output, lookup, event.getExistingFileHelper()));
        generator.addProvider(true, new DatapackBuiltinEntriesProvider(output, lookup, BUILDER, Set.of(GenerationsStructures.MOD_ID)));
    }

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TEMPLATE_POOL, GenerationsTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, GenerationsStructureSettings::bootstrap)
            .add(Registries.STRUCTURE_SET, GenerationsStructureSets::bootstrap);

    private static class GenerationsStructuresBiomeTagsProvider extends BiomeTagsProvider {

        public GenerationsStructuresBiomeTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsBiomeTags.HAS_SCARLET_POKESHOP)
                    .addTag(BiomeTags.IS_OVERWORLD)
                    .addOptionalTag(Tags.Biomes.IS_PLAINS.location())
                    .addOptionalTag(fabricTagMaker("plains"));

            tag(GenerationsBiomeTags.HAS_LOOT_BALLOON)
                    .addTag(BiomeTags.IS_OVERWORLD)
                    .addOptionalTag(fabricTagMaker("in_overworld"));

            tag(GenerationsBiomeTags.HAS_COMET)
                    .addTag(BiomeTags.IS_OVERWORLD)
                    .addTag(BiomeTags.IS_END)
                    .addOptionalTag(fabricTagMaker("in_overworld"))
                    .addOptionalTag(fabricTagMaker("in_the_end"));

            tag(GenerationsBiomeTags.HAS_SPIKE)
                    .addTag(BiomeTags.IS_NETHER)
                    .addOptionalTag(fabricTagMaker("in_nether"));
        }
    }

    private static class GenerationsStructureTagsProvider extends StructureTagsProvider {

        public GenerationsStructureTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsStructures.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(GenerationsStructureTags.POKESHOP).add(GenerationsStructuresKeys.SCARLET_POKESHOP);
            tag(GenerationsStructureTags.LOOT_BALLOONS)
                    .add(GenerationsStructuresKeys.NORMAL_BALLOON)
                    .add(GenerationsStructuresKeys.GREAT_BALLOON)
                    .add(GenerationsStructuresKeys.ULTRA_BALLOON)
                    .add(GenerationsStructuresKeys.MASTER_BALLOON)
                    .add(GenerationsStructuresKeys.BEAST_BALLOON)
                    .add(GenerationsStructuresKeys.MEOWTH_BALLOON);
            tag(GenerationsStructureTags.COMET)
                    .add(GenerationsStructuresKeys.COMET);
            tag(GenerationsStructureTags.SPIKE)
                    .add(GenerationsStructuresKeys.SPIKE);
        }
    }

    private static ResourceLocation fabricTagMaker(String name) {
        return new ResourceLocation("c", name);
    }

}
