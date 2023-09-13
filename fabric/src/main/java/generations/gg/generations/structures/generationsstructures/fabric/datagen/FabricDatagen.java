package generations.gg.generations.structures.generationsstructures.fabric.datagen;

import generations.gg.generations.structures.generationsstructures.tags.GenerationsBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class FabricDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BiomeTagsProvider::new);
	}
}

class BiomeTagsProvider extends net.minecraft.data.tags.BiomeTagsProvider {

	public BiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		tag(GenerationsBiomeTags.HAS_SCARLET_POKESHOP)
				.addTag(ConventionalBiomeTags.PLAINS);

		tag(GenerationsBiomeTags.HAS_LOOT_BALLOON)
				.addTag(BiomeTags.IS_OVERWORLD)
				.addTag(ConventionalBiomeTags.IN_OVERWORLD);
	}
}
