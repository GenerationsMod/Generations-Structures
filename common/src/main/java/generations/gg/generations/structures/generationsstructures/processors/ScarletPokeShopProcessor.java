package generations.gg.generations.structures.generationsstructures.processors;

import com.mojang.serialization.Codec;
import generations.gg.generations.core.generationscore.world.level.block.GenerationsWood;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
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
 * Processor for the Scarlet PokeShop structure
 * This processor is used to replace blocks from other mods with blocks from the mod/vanilla
 * @see StructureProcessor
 * @author J.T. McQuigg (JT122406)
 */
public class ScarletPokeShopProcessor extends StructureProcessor {
    public static final ScarletPokeShopProcessor INSTANCE = new ScarletPokeShopProcessor();
    public static final Codec<ScarletPokeShopProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader level, BlockPos blockPos, BlockPos pos, StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo, StructurePlaceSettings settings) {
        Integration integration = GenerationsStructures.INTEGRATION;
        Block block = relativeBlockInfo.state.getBlock();
        if (block == Blocks.BIRCH_TRAPDOOR)
            return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos, integration.getBirchTrapdoorReplacement().withPropertiesOf(relativeBlockInfo.state), relativeBlockInfo.nbt);
        else if (block == GenerationsWood.GHOST_TRAPDOOR.get())
            return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos, integration.getGhostTrapdoorReplacement().withPropertiesOf(relativeBlockInfo.state), relativeBlockInfo.nbt);

        return relativeBlockInfo;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return StructureProcessors.SCARLET_POKESHOP_PROCESSOR;
    }
}
