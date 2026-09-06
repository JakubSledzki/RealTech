package net.krogul.realtech.item;

import net.krogul.realtech.RealTech;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RealTech.MOD_ID);

    public static final DeferredItem<Item> ore_sieve = ITEMS.register("ore_sieve",
            () -> new Item(new Item.Properties()));
            
    public static final DeferredItem<Item> dirty_iron_clump = ITEMS.register("dirty_iron_clump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> dirty_copper_clump = ITEMS.register("dirty_copper_clump",
            () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> dirty_gold_clump = ITEMS.register("dirty_gold_clump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> clean_iron_clump = ITEMS.register("clean_iron_clump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> clean_copper_clump = ITEMS.register("clean_copper_clump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> clean_gold_clump = ITEMS.register("clean_gold_clump",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
