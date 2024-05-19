package ugi.more_layered_blocks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import ugi.more_layered_blocks.MoreLayeredBlocks;

public class ModItems {

    public static final Item SAND_PILE = registerItem("sand_pile",
            new Item(new FabricItemSettings()));

    public static final Item RED_SAND_PILE = registerItem("red_sand_pile",
            new Item(new FabricItemSettings()));

    public static final Item GRAVEL_PILE = registerItem("gravel_pile",
            new Item(new FabricItemSettings()));

    public static final Item DIRT_PILE = registerItem("dirt_pile",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreLayeredBlocks.MOD_ID, name), item);
    }


    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.MORE_LAYERED_BLOCKS, SAND_PILE);
        addToItemGroup(ModItemGroup.MORE_LAYERED_BLOCKS, RED_SAND_PILE);
        addToItemGroup(ModItemGroup.MORE_LAYERED_BLOCKS, GRAVEL_PILE);
        addToItemGroup(ModItemGroup.MORE_LAYERED_BLOCKS, DIRT_PILE);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add((item)));
    }

    public static void registerModItems() {
        addItemsToItemGroup();
    }
}
