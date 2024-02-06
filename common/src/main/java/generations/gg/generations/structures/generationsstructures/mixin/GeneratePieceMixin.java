package generations.gg.generations.structures.generationsstructures.mixin;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.village.VanillaVillages;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.joml.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(JigsawPlacement.Placer.class)
public abstract class GeneratePieceMixin {

    @Unique
    private boolean hasPokeCenter;

    @Unique
    private boolean hasPokeMart;

    @Final
    @Shadow
    private Registry<StructureTemplatePool> pools;

    @Unique
    private int randomCheck = 0;

    @Unique
    private int randomInt = -1;


    @ModifyArg(method = "tryPlacingChildren", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;getHolder(Lnet/minecraft/resources/ResourceKey;)Ljava/util/Optional;"))
    private ResourceKey<StructureTemplatePool> limitVillageStructures(ResourceKey<StructureTemplatePool> resourceKey) {
        if ((hasPokeCenter && hasPokeMart) || !GenerationsStructures.CONFIG.villageStructureGeneration.AllowStructuresInVillages)
            return resourceKey;

        GenerationsStructures.LOGGER.info(resourceKey.location().getPath());
        /*
        GenerationsStructures.LOGGER.info("randomInt = " + randomInt);
        if (randomInt == -1) {
            randomInt = new Random().nextInt(3);
            randomCheck = 0;
        }

         */

        String poolPath = resourceKey.location().getPath();
        if (poolPath.endsWith("/streets")) {
            /*
            if (randomCheck != randomInt) {
                randomCheck++;
                return resourceKey;
            }

             */
            VanillaVillages village;
            if ((village = VanillaVillages.containsName(poolPath)) != null) {
                if (village != VanillaVillages.PLAINS && village != VanillaVillages.DESERT)
                    return resourceKey;
                GenerationsStructures.LOGGER.info("We are in a village we can spawn shit in");
                GenerationsStructures.LOGGER.info(hasPokeCenter);
                if (!hasPokeCenter && pools.getHolder(village.getPools().getPokeCenter()).isPresent()) {
                    GenerationsStructures.LOGGER.info("Spawning PokeCenter");
                    //reset();
                    hasPokeCenter = true;
                    GenerationsStructures.LOGGER.info(village.getPools().getPokeCenter().toString());
                    return village.getPools().getPokeCenter();
                }

                if (!hasPokeMart && pools.getHolder(village.getPools().getPokeMart()).isPresent()){
                    GenerationsStructures.LOGGER.info("Spawning PokeMart");
                    //reset();
                    hasPokeMart = true;
                    GenerationsStructures.LOGGER.info(village.getPools().getPokeMart().toString());
                    return village.getPools().getPokeMart();
                }
            }
        }

        return resourceKey;
    }


    @Unique
    private void reset(){
        randomInt = -1;
        randomCheck = 0;
    }
}


