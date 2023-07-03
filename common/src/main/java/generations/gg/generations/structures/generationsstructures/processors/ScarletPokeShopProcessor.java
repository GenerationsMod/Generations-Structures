package generations.gg.generations.structures.generationsstructures.processors;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ScarletPokeShopProcessor extends StructureProcessor {
    public static final ScarletPokeShopProcessor INSTANCE = new ScarletPokeShopProcessor();
    public static final Codec<ScarletPokeShopProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader level, BlockPos blockPos, BlockPos pos, StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo, StructurePlaceSettings settings) {
        return null;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.SCARLET_POKESHOP_PROCESSOR;
    }
}
