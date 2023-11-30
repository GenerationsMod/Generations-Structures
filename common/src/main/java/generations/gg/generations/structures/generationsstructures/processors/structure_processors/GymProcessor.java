package generations.gg.generations.structures.generationsstructures.processors.structure_processors;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
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

/**
 * Processor for the Generations Gyms
 * This processor is used to replace blocks from other mods with blocks from the mod/vanilla
 * @see StructureProcessor
 * @author J.T. McQuigg (JT122406)
 */
public class GymProcessor extends StructureProcessor {

    public static final GymProcessor INSTANCE = new GymProcessor();
    public static final Codec<GymProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Integration integration = GenerationsStructures.INTEGRATION;
        if (integration.getModId() == null) return relativeBlockInfo;

        Block block = relativeBlockInfo.state().getBlock();
        if (block == Blocks.OAK_LEAVES)
            return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), integration.getOakLeavesReplacement().withPropertiesOf(relativeBlockInfo.state()), relativeBlockInfo.nbt());

        return relativeBlockInfo;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.GYM_PROCESSOR;
    }
}
