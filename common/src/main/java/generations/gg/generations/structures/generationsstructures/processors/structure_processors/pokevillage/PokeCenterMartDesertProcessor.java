package generations.gg.generations.structures.generationsstructures.processors.structure_processors.pokevillage;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import generations.gg.generations.structures.generationsstructures.village.VanillaVillages;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PokeCenterMartDesertProcessor extends StructureProcessor {

    public static final PokeCenterMartDesertProcessor INSTANCE = new PokeCenterMartDesertProcessor();
    public static final Codec<PokeCenterMartDesertProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        if (level.getBiome(blockPos).is(VanillaVillages.DESERT.getVillageTag())) {
            Block block = relativeBlockInfo.state().getBlock();
            if (block.defaultBlockState().is(BlockTags.LEAVES))
                return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), Blocks.CACTUS.withPropertiesOf(relativeBlockInfo.state()), relativeBlockInfo.nbt());
            else if (block.defaultBlockState().is(BlockTags.FLOWER_POTS))
                return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), Blocks.POTTED_CACTUS.defaultBlockState(), relativeBlockInfo.nbt());
        }

        return relativeBlockInfo;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.POKECENTER_MART_DESERT_PROCESSOR;
    }
}
