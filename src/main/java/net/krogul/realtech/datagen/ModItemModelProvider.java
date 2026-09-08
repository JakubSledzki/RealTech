package net.krogul.realtech.datagen;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;



public class ModItemModelProvider extends ItemModelProvider{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, RealTech.MOD_ID, existingFileHelper);

    }
    
    @Override 
    protected void registerModels(){
        basicItem(ModItems.clean_copper_clump.get());
        basicItem(ModItems.dirty_copper_clump.get());
        basicItem(ModItems.clean_iron_clump.get());
        basicItem(ModItems.dirty_iron_clump.get());
        basicItem(ModItems.clean_gold_clump.get());
        basicItem(ModItems.dirty_gold_clump.get());
        basicItem(ModItems.ore_sieve.get());
        basicItem(ModItems.ruby_gem.get());
        basicItem(ModItems.sapphire_gem.get());
        basicItem(ModItems.uncut_diamond_gem.get());
        basicItem(ModItems.uncut_ruby_gem.get());
        basicItem(ModItems.uncut_sapphire_gem.get());
        basicItem(ModItems.sandpaper.get());


    }
}


    
    

