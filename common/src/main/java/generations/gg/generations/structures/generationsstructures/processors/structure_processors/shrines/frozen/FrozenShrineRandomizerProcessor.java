package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.frozen;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
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

public class FrozenShrineRandomizerProcessor extends StructureProcessor {

    public static final FrozenShrineRandomizerProcessor INSTANCE = new FrozenShrineRandomizerProcessor();
    public static final Codec<FrozenShrineRandomizerProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Block block = relativeBlockInfo.state().getBlock();
        if (GenerationsStructures.CONFIG.randomization.randomizeFrozenShrineBlocks)
            if (block == Blocks.SNOW_BLOCK || block == Blocks.WHITE_CONCRETE_POWDER || block == Blocks.WHITE_CONCRETE || block == Blocks.WHITE_WOOL)
                relativeBlockInfo = new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), randomizeBlock(block).defaultBlockState(), relativeBlockInfo.nbt());

        return relativeBlockInfo;
    }

    public static Block randomizeBlock(Block block) {
        int random = new Random().nextInt(6);
        switch (random) {
            case 0, 1 -> {
                return Blocks.SNOW_BLOCK;
            }
            case 2 -> {
                return Blocks.WHITE_CONCRETE_POWDER;
            }
            case 3 -> {
                return Blocks.WHITE_CONCRETE;
            }
            case 4 -> {
                return Blocks.WHITE_WOOL;
            }
            default -> {
                return block;
            }
        }
    }


    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.FROZEN_SHRINE_RANDOMIZER_PROCESSOR;
    }
}
