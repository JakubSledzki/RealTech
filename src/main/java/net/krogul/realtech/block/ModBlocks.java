package net.krogul.realtech.block;

import java.util.function.Supplier;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RealTech.MOD_ID);



    public static final DeferredBlock<Block> ore_ruby_block = registerBlock("ore_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ore_saphire_block = registerBlock("ore_saphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
            DeferredBlock<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
    }    

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
    }
}
