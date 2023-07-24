package generations.gg.generations.structures.generationsstructures.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.yungsapi.api.YungJigsawManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.Optional;
import java.util.function.Function;


/**
 * An extended version of {@link com.yungnickyoung.minecraft.yungsapi.world.structure.YungJigsawStructure}
 * with additional checks for terrain necessary for spawning structures in the End.
 */
public class EndJigsawStructure extends Structure {

    public static final int MAX_TOTAL_STRUCTURE_RADIUS = 128;
    public static final Codec<EndJigsawStructure> CODEC = RecordCodecBuilder.<EndJigsawStructure>mapCodec(builder -> builder
                    .group(
                            settingsCodec(builder),
                            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                            ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                            Codec.intRange(0, 128).fieldOf("size").forGetter(structure -> structure.maxDepth),
                            HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                            IntProvider.codec(0, 15).optionalFieldOf("x_offset_in_chunk", ConstantInt.of(0)).forGetter(structure -> structure.xOffsetInChunk),
                            IntProvider.codec(0, 15).optionalFieldOf("z_offset_in_chunk", ConstantInt.of(0)).forGetter(structure -> structure.zOffsetInChunk),
                            Codec.BOOL.optionalFieldOf("use_expansion_hack", false).forGetter(structure -> structure.useExpansionHack),
                            Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                            Codec.intRange(1, MAX_TOTAL_STRUCTURE_RADIUS).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                            Codec.INT.optionalFieldOf("max_y").forGetter(structure -> structure.maxY),
                            Codec.INT.optionalFieldOf("min_y").forGetter(structure -> structure.minY),
                            Codec.INT.fieldOf("terrain_radius_check_distance").forGetter(structure -> structure.terrainRadiusCheckDistance),
                            ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("num_radius_checks", 1).forGetter(structure -> structure.numRadiusChecks))
                    .apply(builder, EndJigsawStructure::new))
            .flatXmap(verifyRange(), verifyRange())
            .codec();

    private static Function<EndJigsawStructure, DataResult<EndJigsawStructure>> verifyRange() {
        return structure -> {
            int vanillaEdgeBuffer = switch (structure.terrainAdaptation()) {
                case NONE -> 0;
                case BURY, BEARD_THIN, BEARD_BOX -> 12;
            };
            if (structure.maxDistanceFromCenter + vanillaEdgeBuffer > 128)
                return DataResult.error(() -> "YUNG Structure size including terrain adaptation must not exceed 128");

            return DataResult.success(structure);
        };
    }

    public final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    public final int maxDepth;
    public final HeightProvider startHeight;
    public final IntProvider xOffsetInChunk;
    public final IntProvider zOffsetInChunk;
    public final boolean useExpansionHack;
    public final Optional<Heightmap.Types> projectStartToHeightmap;
    public final int maxDistanceFromCenter;
    public final Optional<Integer> maxY;
    public final Optional<Integer> minY;
    public final int terrainRadiusCheckDistance;
    public final int numRadiusChecks;

    public EndJigsawStructure(
            StructureSettings structureSettings,
            Holder<StructureTemplatePool> startPool,
            Optional<ResourceLocation> startJigsawName,
            int maxDepth,
            HeightProvider startHeight,
            IntProvider xOffsetInChunk,
            IntProvider zOffsetInChunk,
            boolean useExpansionHack,
            Optional<Heightmap.Types> projectStartToHeightmap,
            int maxBlockDistanceFromCenter,
            Optional<Integer> maxY,
            Optional<Integer> minY,
            int terrainRadiusCheckDistance,
            int numRadiusChecks
    ) {
        super(structureSettings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.maxDepth = maxDepth;
        this.startHeight = startHeight;
        this.xOffsetInChunk = xOffsetInChunk;
        this.zOffsetInChunk = zOffsetInChunk;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxBlockDistanceFromCenter;
        this.maxY = maxY;
        this.minY = minY;
        this.terrainRadiusCheckDistance = terrainRadiusCheckDistance;
        this.numRadiusChecks = numRadiusChecks;
    }

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        // Normal logic copied from YungJigsawStructure
        ChunkPos chunkPos = context.chunkPos();
        RandomSource randomSource = context.random();
        int startY = this.startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        BlockPos startPos = new BlockPos(chunkPos.getBlockX(this.xOffsetInChunk.sample(randomSource)), startY, chunkPos.getBlockZ(this.zOffsetInChunk.sample(randomSource)));

        // Additional terrain checks required for End structures to spawn properly
        if (!isTerrainValid(context, startPos)) return Optional.empty();


        return YungJigsawManager.assembleJigsawStructure(
                context,
                this.startPool,
                this.startJigsawName,
                this.maxDepth,
                startPos,
                this.useExpansionHack,
                this.projectStartToHeightmap,
                this.maxDistanceFromCenter,
                this.maxY,
                this.minY
        );
    }

    protected boolean isTerrainValid(GenerationContext context, BlockPos startPos) {
        // Terrain height is required to be at least 45 blocks above the dimension's minY.
        // For the End, this ensures we never attempt to spawn a structure in the void.
        int requiredTerrainY = context.chunkGenerator().getMinY() + 45;

        // Validate terrain at the structure's position
        if (getTerrainHeight(context, startPos.getX(), startPos.getZ()) < requiredTerrainY) return false;


        // Validate the structure's surrounding terrain based on the terrainRadiusCheckDistance and numRadiusChecks
        float deltaDistance = (float) terrainRadiusCheckDistance / numRadiusChecks;
        for (int i = numRadiusChecks; i > 0; i--)
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                // Compute the location at which we will check for solid terrain
                Vector3f offsetPos = direction.step();
                offsetPos.mul(deltaDistance * i);

                // Compute & validate terrain height at target position
                if (getTerrainHeight(context, startPos.getX() + (int) offsetPos.x(), startPos.getZ() + (int) offsetPos.z()) < requiredTerrainY) return false;
            }

        return true;
    }

    private static int getTerrainHeight(GenerationContext context, int x, int z) {
        return context.chunkGenerator().getFirstOccupiedHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
    }

    @Override
    public @NotNull StructureType<?> type() {
        return GenerationsStructureTypes.END_JIGSAW;
    }
}
