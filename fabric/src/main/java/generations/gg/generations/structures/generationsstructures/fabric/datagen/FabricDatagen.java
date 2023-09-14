package generations.gg.generations.structures.generationsstructures.fabric.datagen;

import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class FabricDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BiomeTagsProvider::new);
	}
}

class BiomeTagsProvider extends FabricTagProvider<Biome> {

	public BiomeTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
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
