package generations.gg.generations.structures.generationsstructures.processors;

import com.mojang.serialization.Codec;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.burnedTower.BurnedTowerShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.creationTrio.CreationTrioShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.forcesOfNature.ForcesOfNatureShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.frozen.FrozenShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.GymProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.PokeCenterProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.ScarletPokeCenterProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.groudon.GroudonShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.kyogre.KyogreShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.lugia.LugiaShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.lunarDuo.LunarDuoShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.regi.RegiShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.tapu.TapuShrineRandomizerProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import org.jetbrains.annotations.NotNull;

/**
 * Structure processor types for Generations Structures
 * @see StructureProcessorType
 * @author J.T. McQuigg (JT122406)
 */
public class StructureProcessors {
    public static final StructureProcessorType<ScarletPokeCenterProcessor> SCARLET_POKECENTER_PROCESSOR = register("scarlet_pokeshop_processor", ScarletPokeCenterProcessor.CODEC);
    public static final StructureProcessorType<GymProcessor> GYM_PROCESSOR = register("gym_processor", GymProcessor.CODEC);
    public static final StructureProcessorType<PokeCenterProcessor> POKECENTER_PROCESSOR = register("pokecenter_processor", PokeCenterProcessor.CODEC);
    public static final StructureProcessorType<FrozenShrineProcessor> FROZEN_SHRINE_PROCESSOR = register("shrines/frozen_shrine_processor", FrozenShrineProcessor.CODEC);
    public static final StructureProcessorType<FieryShrineRandomizerProcessor> FIERY_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/fiery_shrine_randomizer_processor", FieryShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<FieryShrineProcessor> FIERY_SHRINE_PROCESSOR = register("shrines/fiery_shrine_processor", FieryShrineProcessor.CODEC);
    public static final StructureProcessorType<StaticShrineRandomizerProcessor> STATIC_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/static_shrine_randomizer_processor", StaticShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<StaticShrineProcessor> STATIC_SHRINE_PROCESSOR = register("shrines/static_shrine_processor", StaticShrineProcessor.CODEC);
    public static final StructureProcessorType<LugiaShrineRandomizerProcessor> LUGIA_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/lugia_shrine_randomizer_processor", LugiaShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<BurnedTowerShrineRandomizerProcessor> BURNED_TOWER_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/burned_tower_shrine_randomizer_processor", BurnedTowerShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<CreationTrioShrineRandomizerProcessor> CREATION_TRIO_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/cration_trio_shrine_randomizer_processor", CreationTrioShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<LunarDuoShrineRandomizerProcessor> LUNAR_DUO_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/lunar_duo_shrine_randomizer_processor",LunarDuoShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<ForcesOfNatureShrineRandomizerProcessor> FORCES_OF_NATURE_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/forces_of_nature_shrine_randomizer_processor", ForcesOfNatureShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<GroudonShrineRandomizerProcessor> GROUDON_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/groudon_shrine_randomizer_processor", GroudonShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<KyogreShrineRandomizerProcessor> KYOGRE_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/kyogre_shrine_randomizer_processor", KyogreShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<RegiShrineRandomizerProcessor> REGI_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/regi_shrine_randomizer_processor", RegiShrineRandomizerProcessor.CODEC);
    public static final StructureProcessorType<TapuShrineRandomizerProcessor> TAPU_SHRINE_RANDOMIZER_PROCESSOR = register("shrines/tapu_shrine_randomizer_processor", TapuShrineRandomizerProcessor.CODEC);



    /**
     * Registers all custom structure processor types.
     */
    public static void init() {
        GenerationsStructures.LOGGER.info("Registering Custom Structure Processors");
    }

    /**
     * Utility method for registering custom structure processor types.
     * @param id The id of the structure processor type
     * @param codec The codec for the structure processor type
     * @return The registered structure processor type
     */
    private static <P extends StructureProcessor> @NotNull StructureProcessorType<P> register(String id, Codec<P> codec) {
        StructureProcessorType<P> processorType = () -> codec;
        return Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, GenerationsStructures.id(id), processorType);
    }
}
