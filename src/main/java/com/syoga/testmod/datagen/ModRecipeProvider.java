package com.syoga.testmod.datagen;

import com.syoga.testmod.block.ModBlocks;
import com.syoga.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModItems.VOIDIUM.get()), RecipeCategory.MISC,
                ModItems.ROTTIUM.get(), 0.7f, 200,"rottium");

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTIUM.get(), RecipeCategory.MISC,
                ModBlocks.ROTTEN_BLOCK.get());
    }
}
