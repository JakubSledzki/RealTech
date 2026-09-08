package net.krogul.realtech.datagen;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RealTech.MOD_ID, exFileHelper);
    }

    @Override 
    protected void registerStatesAndModels() {
        // Register block states and models here
        blockWithItem(ModBlocks.ore_ruby_block);
        blockWithItem(ModBlocks.ore_sapphire_block);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    
}
