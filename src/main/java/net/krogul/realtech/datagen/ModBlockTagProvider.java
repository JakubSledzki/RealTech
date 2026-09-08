package net.krogul.realtech.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider{
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper){
        super(output, lookupProvider, RealTech.MOD_ID, existingFileHelper);
    }

    @Override 
    protected void  addTags(HolderLookup.Provider provider){
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ore_ruby_block.get())
                .add(ModBlocks.ore_sapphire_block.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ore_ruby_block.get())
                .add(ModBlocks.ore_sapphire_block.get());

    }





}

