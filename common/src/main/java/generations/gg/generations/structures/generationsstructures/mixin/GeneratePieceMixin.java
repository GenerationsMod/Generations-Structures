package generations.gg.generations.structures.generationsstructures.mixin;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(JigsawPlacement.Placer.class)
public abstract class GeneratePieceMixin {

    @Unique
    private boolean hasGenerationsStructure;
    @Final
    @Shadow
    private Registry<StructureTemplatePool> pools;


    @ModifyArg(method = "tryPlacingChildren", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;getHolder(Lnet/minecraft/resources/ResourceKey;)Ljava/util/Optional;"))
    private ResourceKey<StructureTemplatePool> limitVillageStructures(ResourceKey<StructureTemplatePool> resourceKey) {
        if (hasGenerationsStructure || !GenerationsStructures.CONFIG.villageStructureGeneration.AllowStructuresInVillages)
            return resourceKey;

        String poolPath = resourceKey.location().getPath();
        if (poolPath.endsWith("/streets")) {
            if (poolPath.contains("plains")) {
                ResourceKey<StructureTemplatePool> generationsPoolKey = GenerationsTemplatePools.GENERATIONS_PLAINS_STREET;
                if (pools.getHolder(generationsPoolKey).isPresent()) {
                    hasGenerationsStructure = true;
                    return generationsPoolKey;
                }
            } else if (poolPath.contains("desert")) {
                ResourceKey<StructureTemplatePool> generationsPoolKey = GenerationsTemplatePools.GENERATIONS_DESERT_STREET;
                if (pools.getHolder(generationsPoolKey).isPresent()) {
                    hasGenerationsStructure = true;
                    return generationsPoolKey;
                }
            }
        }

        return resourceKey;
    }
}
