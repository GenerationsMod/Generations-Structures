package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.frozen;

import com.mojang.serialization.Codec;
import generations.gg.generations.core.generationscore.world.level.block.GenerationsBlocks;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
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

public class FrozenShrineProcessor extends StructureProcessor {

    public static final FrozenShrineProcessor INSTANCE = new FrozenShrineProcessor();
    public static final Codec<FrozenShrineProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Integration integration = GenerationsStructures.INTEGRATION;
        if (integration.getModId() == null) return relativeBlockInfo;

        Block block = relativeBlockInfo.state().getBlock();
        if (block == GenerationsBlocks.WHITE_CASTLE_BRICK_2_SET.getSlab())
            return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), integration.getWhiteCastleBrick2SetSlabReplacement().withPropertiesOf(relativeBlockInfo.state()), relativeBlockInfo.nbt());

        return relativeBlockInfo;
    }


    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.FROZEN_SHRINE_PROCESSOR;
    }
}
