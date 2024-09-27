package generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.burnedTower;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BurnedTowerShrineRandomizerProcessor extends StructureProcessor {

    public static final BurnedTowerShrineRandomizerProcessor INSTANCE = new BurnedTowerShrineRandomizerProcessor();
    public static final Codec<BurnedTowerShrineRandomizerProcessor> CODEC = Codec.unit(() -> INSTANCE);


    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos blockPos, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
        // Block block = relativeBlockInfo.state().getBlock();
        // if (GenerationsStructures.CONFIG.randomization.randomizeStaticShrineBlocks)

        return relativeBlockInfo;
    }



    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.BURNED_TOWER_SHRINE_RANDOMIZER_PROCESSOR;
    }
}
