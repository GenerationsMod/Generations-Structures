package generations.gg.generations.structures.generationsstructures.forge.datagen;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class StructureProcessorProvider implements DataProvider {
    protected final PackOutput output;
    private final PackOutput.PathProvider pathProvider;

    protected StructureProcessorProvider(PackOutput output) {
        this.output = output;
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "structure processor");
    }

    public abstract void generateStructureProcessors(Consumer<StructureProcessorType<?>> consumer);

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
        final Set<ResourceLocation> identifiers = Sets.newHashSet();
        final Set<StructureProcessorType<?>> processors = Sets.newHashSet();

        generateStructureProcessors(processors::add);

        final List<CompletableFuture<?>> futures = new ArrayList<>();

        for (StructureProcessorType<?> processor : processors) {
            final ResourceLocation id = BuiltInRegistries.STRUCTURE_PROCESSOR.getKey(processor);

            if (id == null) {
                throw new IllegalStateException("Structure processor " + processor + " has null registry name");
            }

            if (!identifiers.add(id)) {
                throw new IllegalStateException("Duplicate structure processor " + id);
            }

            JsonObject json = new JsonObject();
            json.getAsJsonArray("processors").add(id.toString());

            futures.add(DataProvider.saveStable(output, json, Path.of(id.getPath())));
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public @NotNull String getName() {
        return "Structure Processors";
    }
}
