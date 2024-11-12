package generations.gg.generations.structures.generationsstructures.village;

import generations.gg.generations.structures.generationsstructures.worldgen.template_pool.GenerationsTemplatePools;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

public enum VanillaVillages {
    PLAINS("plains", GenerationsTemplatePools.PLAINS_VILLAGE_POKECENTER, GenerationsTemplatePools.PLAINS_VILLAGE_POKEMART, GenerationsTemplatePools.PLAINS_VILLAGE_POKECENTER_STREETS, GenerationsTemplatePools.PLAINS_VILLAGE_POKEMART_STREETS, BiomeTags.HAS_VILLAGE_PLAINS),
    DESERT("desert", GenerationsTemplatePools.DESERT_VILLAGE_POKECENTER, GenerationsTemplatePools.DESERT_VILLAGE_POKEMART, GenerationsTemplatePools.DESERT_VILLAGE_POKECENTER_STREETS, GenerationsTemplatePools.DESERT_VILLAGE_POKEMART_STREETS, BiomeTags.HAS_VILLAGE_DESERT);
    //SAVANNA("savanna", GenerationsTemplatePools.SAVANNA_VILLAGE_POKECENTER, GenerationsTemplatePools.SAVANNA_VILLAGE_POKEMART, GenerationsTemplatePools.SAVANNA_VILLAGE_POKECENTER_STREETS, GenerationsTemplatePools.SAVANNA_VILLAGE_POKEMART_STREETS, BiomeTags.HAS_VILLAGE_SAVANNA),
    //SNOWY("snowy", GenerationsTemplatePools.SNOWY_VILLAGE_POKECENTER, GenerationsTemplatePools.SNOWY_VILLAGE_POKEMART, GenerationsTemplatePools.SNOWY_VILLAGE_POKECENTER_STREETS, GenerationsTemplatePools.SNOWY_VILLAGE_POKEMART_STREETS, BiomeTags.HAS_VILLAGE_SNOWY),
    //TAIGA("taiga", GenerationsTemplatePools.TAIGA_VILLAGE_POKECENTER, GenerationsTemplatePools.TAIGA_VILLAGE_POKEMART, GenerationsTemplatePools.TAIGA_VILLAGE_POKECENTER_STREETS, GenerationsTemplatePools.TAIGA_VILLAGE_POKEMART_STREETS, BiomeTags.HAS_VILLAGE_TAIGA);

    private final String name;
    private final ResourceKey<StructureTemplatePool> pokecenter;
    private final ResourceKey<StructureTemplatePool> pokemart;
    private final ResourceKey<StructureTemplatePool> pokecenterStreets;
    private final ResourceKey<StructureTemplatePool> pokemartStreets;
    private final TagKey<Biome> hasVillage;

    VanillaVillages(String name, ResourceKey<StructureTemplatePool> pokecenter, ResourceKey<StructureTemplatePool> pokemart, ResourceKey<StructureTemplatePool> pokecenterStreets, ResourceKey<StructureTemplatePool> pokemartStreets, TagKey<Biome> hasVillage) {
        this.name = name;
        this.pokecenter = pokecenter;
        this.pokemart = pokemart;
        this.pokecenterStreets = pokecenterStreets;
        this.pokemartStreets = pokemartStreets;
        this.hasVillage = hasVillage;
    }

    public String getName() {
        return name;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeCenter() {
        return pokecenter;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeMart() {
        return pokemart;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeCenterStreets() {
        return pokecenterStreets;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getPokeMartStreets() {
        return pokemartStreets;
    }

    public @NotNull TagKey<Biome> getVillageTag() {
        return hasVillage;
    }

    public @NotNull ResourceKey<StructureTemplatePool> getVillagePool(String pool) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation("village/plains/" + pool));
    }

    private static final VanillaVillages[] VALUES = values();

    public static VanillaVillages byName(String name) {
        for (VanillaVillages vanillaVillages : VALUES)
            if (vanillaVillages.getName().equals(name))
                return vanillaVillages;
        return null;
    }

    public static VanillaVillages containsName(String name) {
        for (VanillaVillages vanillaVillages : VALUES)
            if (name.contains(vanillaVillages.getName()))
                return vanillaVillages;
        return null;
    }
}