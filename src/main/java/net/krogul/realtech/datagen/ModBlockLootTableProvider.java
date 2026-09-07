package net.krogul.realtech.datagen;

import java.util.Set;

import net.krogul.realtech.block.ModBlocks;
import net.krogul.realtech.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override 
    protected void generate() {
        // Implement your loot table generation logic here
        add(ModBlocks.ore_ruby_block.get(),
            block -> createOreDrop(ModBlocks.ore_ruby_block.get(), ModItems.uncut_ruby_gem.get()));

        add(ModBlocks.ore_sapphire_block.get(),
            block -> createOreDrop(ModBlocks.ore_sapphire_block.get(), ModItems.uncut_sapphire_gem.get()));

    }

    protected LootTable.Builder createMultipleOreDrop(Block pBlock, Item item, int minDrops, int maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override 
    protected Iterable<Block> getKnownBlocks() {
        // Return a list of known blocks for which loot tables should be generated
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
    
}