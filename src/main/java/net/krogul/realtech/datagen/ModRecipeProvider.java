package net.krogul.realtech.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.block.ModBlocks;
import net.krogul.realtech.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.server.ReloadableServerRegistries.Holder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder  {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries){
        super(output, registries);
    }
    
    @Override
    protected void buildRecipes(RecipeOutput recipeOutput){

        // Ore Sieve Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ore_sieve.get())
                .pattern("sss")
                .pattern("lll")
                .define('s', Items.STICK)
                .define('l', Items.STRING)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        // Sandpaper Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.sandpaper.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("sp ")
                .define('s', ItemTags.SAND)
                .define('p', Items.PAPER)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(recipeOutput);

        // Iron Ingot from Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.clean_iron_clump.get()), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200)
                .unlockedBy(getHasName(ModItems.clean_iron_clump.get()), has(ModItems.clean_iron_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.IRON_INGOT) + "_from_smelting");

        // Iron Ingot from Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.clean_iron_clump.get()), RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100)
                .unlockedBy(getHasName(ModItems.clean_iron_clump.get()), has(ModItems.clean_iron_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.IRON_INGOT) + "_from_blasting");

        // Copper Ingot from Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.clean_copper_clump.get()), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200)
                .unlockedBy(getHasName(ModItems.clean_copper_clump.get()), has(ModItems.clean_copper_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.COPPER_INGOT) + "_from_smelting");

        // Copper Ingot from Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.clean_copper_clump.get()), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100)
                .unlockedBy(getHasName(ModItems.clean_copper_clump.get()), has(ModItems.clean_copper_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.COPPER_INGOT) + "_from_blasting");

        // Gold Ingot from Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.clean_gold_clump.get()), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200)
                .unlockedBy(getHasName(ModItems.clean_gold_clump.get()), has(ModItems.clean_gold_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.GOLD_INGOT) + "_from_smelting");

        // Gold Ingot from Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.clean_gold_clump.get()), RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100)
                .unlockedBy(getHasName(ModItems.clean_gold_clump.get()), has(ModItems.clean_gold_clump.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(Items.GOLD_INGOT) + "_from_blasting");

        // Ruby from Ore Block Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ore_ruby_block.get()), RecipeCategory.MISC, ModItems.ruby_gem.get(), 1.0f, 200)
                .unlockedBy(getHasName(ModBlocks.ore_ruby_block.get()), has(ModBlocks.ore_ruby_block.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":ruby_gem_from_smelting");

        // Sapphire from Ore Block Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ore_sapphire_block.get()), RecipeCategory.MISC, ModItems.sapphire_gem.get(), 1.0f, 200)
                .unlockedBy(getHasName(ModBlocks.ore_sapphire_block.get()), has(ModBlocks.ore_sapphire_block.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":sapphire_gem_from_smelting");

        // Ruby from Ore Block Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ore_ruby_block.get()), RecipeCategory.MISC, ModItems.ruby_gem.get(), 1.0f, 100)
                .unlockedBy(getHasName(ModBlocks.ore_ruby_block.get()), has(ModBlocks.ore_ruby_block.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":ruby_gem_from_blasting");

        // Sapphire from Ore Block Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ore_sapphire_block.get()), RecipeCategory.MISC, ModItems.sapphire_gem.get(), 1.0f, 100)
                .unlockedBy(getHasName(ModBlocks.ore_sapphire_block.get()), has(ModBlocks.ore_sapphire_block.get()))
                .save(recipeOutput, RealTech.MOD_ID + ":sapphire_gem_from_blasting");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, RealTech.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
