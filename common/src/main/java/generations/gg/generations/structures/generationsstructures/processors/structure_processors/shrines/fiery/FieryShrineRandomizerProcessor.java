package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FieryShrineRandomizerProcessor extends StructureProcessor {

    public static final FieryShrineRandomizerProcessor INSTANCE = new FieryShrineRandomizerProcessor();
    public static final Codec<FieryShrineRandomizerProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Block block = relativeBlockInfo.state().getBlock();
        if (GenerationsStructures.CONFIG.randomization.randomizeFieryShrineBlocks)
            if (block == Blocks.POLISHED_BLACKSTONE || block == Blocks.POLISHED_BLACKSTONE_BRICKS || block == Blocks.BLACKSTONE || block == Blocks.GILDED_BLACKSTONE)
                return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), randomizeBaseBlocks(block).defaultBlockState(), relativeBlockInfo.nbt());
            else if (block == Blocks.NETHER_BRICKS || block == Blocks.CRACKED_NETHER_BRICKS)
                return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), randomizeNetherBricks(block).defaultBlockState(), relativeBlockInfo.nbt());


        return relativeBlockInfo;
    }

    private Block randomizeBaseBlocks(Block block) {
        switch (new Random().nextInt(5)) {
            case 0 -> {
                return Blocks.POLISHED_BLACKSTONE;
            }
            case 1 -> {
                return Blocks.POLISHED_BLACKSTONE_BRICKS;
            }
            case 2 -> {
                return Blocks.BLACKSTONE;
            }
            case 3 -> {
                return Blocks.GILDED_BLACKSTONE;
            }
            default -> {
                return block;
            }
        }
    }

    private Block randomizeNetherBricks(Block block) {
        switch (new Random().nextInt(2)) {
            case 0 -> {
                return Blocks.NETHER_BRICKS;
            }
            case 1 -> {
                return Blocks.CRACKED_NETHER_BRICKS;
            }
            default -> {
                return block;
            }
        }
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.FIERY_SHRINE_RANDOMIZER_PROCESSOR;
    }
}
