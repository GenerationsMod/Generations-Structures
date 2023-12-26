package generations.gg.generations.structures.generationsstructures.randomizer;

import net.minecraft.world.level.block.Block;

public class VendingMachineRandomizer {
    private static final Block[] vendingMachines = new Block[] {
            //TODO: Add Vending Machines (Waiting for Water)
    };
    public static Block getRandomVendingMachine() {
        return vendingMachines[(int) (Math.random() * vendingMachines.length)];
    }
}
