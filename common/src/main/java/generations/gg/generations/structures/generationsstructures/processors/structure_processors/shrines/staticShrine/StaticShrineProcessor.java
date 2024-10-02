package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StaticShrineProcessor extends StructureProcessor {

    public static final StaticShrineProcessor INSTANCE = new StaticShrineProcessor();
    public static final Codec<StaticShrineProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        Integration integration = GenerationsStructures.INTEGRATION;
        if (integration.getModId() == null) return relativeBlockInfo;

        Block block = relativeBlockInfo.state().getBlock();

        return relativeBlockInfo;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.STATIC_SHRINE_PROCESSOR;
    }
}
