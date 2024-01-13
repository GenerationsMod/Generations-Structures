package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FieryShrineRandomizerProcessor extends StructureProcessor {

    public static final FieryShrineRandomizerProcessor INSTANCE = new FieryShrineRandomizerProcessor();
    public static final Codec<FieryShrineRandomizerProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Block block = relativeBlockInfo.state().getBlock();
        if (GenerationsStructures.CONFIG.randomization.randomizeFieryShrineBlocks)
            return relativeBlockInfo;


        return relativeBlockInfo;
    }


    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.FIERY_SHRINE_RANDOMIZER_PROCESSOR;
    }
}
