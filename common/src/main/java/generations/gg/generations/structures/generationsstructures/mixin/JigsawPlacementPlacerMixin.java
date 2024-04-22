package generations.gg.generations.structures.generationsstructures.mixin;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.village.VanillaVillages;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(JigsawPlacement.Placer.class)
public abstract class JigsawPlacementPlacerMixin {

    @Final
    @Shadow
    private Registry<StructureTemplatePool> pools;

    @Shadow @Final private RandomSource random;
    @Unique
    private boolean hasPokeCenter;
    @Unique
    private boolean hasPokeMart;

    @Unique
    private boolean shouldForcePoke() {
        return GenerationsStructures.CONFIG.villageStructureGeneration.AllowStructuresInVillages;
    }

    @ModifyArg(method = "tryPlacingChildren", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;getHolder(Lnet/minecraft/resources/ResourceKey;)Ljava/util/Optional;"))
    private ResourceKey<StructureTemplatePool> modifyPoolKey(ResourceKey<StructureTemplatePool> key) {
        if (!shouldForcePoke() || (hasPokeCenter && hasPokeMart) || random.nextBoolean()) return key;
        String poolPath = key.location().getPath();
        if (poolPath.endsWith("/streets")) {
            VanillaVillages village = VanillaVillages.containsName(poolPath);
            if (!hasPokeCenter && pools.getHolder(village.getPokeCenterStreets()).isPresent()) {
                hasPokeCenter = true;
                return village.getPokeCenterStreets();
            } else if (!hasPokeMart && pools.getHolder(village.getPokeMartStreets()).isPresent()) {
                hasPokeMart = true;
                return village.getPokeMartStreets();
            }
        }

        return key;
    }

}
