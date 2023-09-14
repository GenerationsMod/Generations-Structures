package generations.gg.generations.structures.generationsstructures.fabric.datagen;

import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import generations.gg.generations.structures.generationsstructures.tags.GenerationsStructureTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.concurrent.CompletableFuture;

public class FabricDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(GenerationsBiomeTagsProvider::new);
		pack.addProvider(GenerationsStructureTagsProvider::new);
	}


	private static class GenerationsBiomeTagsProvider extends FabricTagProvider<Biome> {

		public GenerationsBiomeTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, Registries.BIOME, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider arg) {
			getOrCreateTagBuilder(GenerationsBiomeTags.HAS_SCARLET_POKESHOP)
					.forceAddTag(ConventionalBiomeTags.PLAINS);

			getOrCreateTagBuilder(GenerationsBiomeTags.HAS_LOOT_BALLOON)
					.forceAddTag(BiomeTags.IS_OVERWORLD)
					.forceAddTag(ConventionalBiomeTags.IN_OVERWORLD);
		}
	}

	private static class GenerationsStructureTagsProvider extends FabricTagProvider<Structure> {
		public GenerationsStructureTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, Registries.STRUCTURE, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider arg) {
			tag(GenerationsStructureTags.POKESHOP)
					.add(GenerationsStructuresKeys.SCARLET_POKESHOP);
			tag(GenerationsStructureTags.LOOT_BALLOON)
					.add(GenerationsStructuresKeys.NORMAL_BALLOON)
					.add(GenerationsStructuresKeys.GREAT_BALLOON)
					.add(GenerationsStructuresKeys.ULTRA_BALLOON)
					.add(GenerationsStructuresKeys.MASTER_BALLOON)
					.add(GenerationsStructuresKeys.BEAST_BALLOON)
					.add(GenerationsStructuresKeys.MEOWTH_BALLOON);
		}
	}
}
