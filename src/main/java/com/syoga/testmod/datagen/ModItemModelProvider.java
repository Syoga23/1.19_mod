package com.syoga.testmod.datagen;

import com.syoga.testmod.TestMod;
import com.syoga.testmod.block.ModBlocks;
import com.syoga.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ROTTIUM);
        simpleItem(ModItems.VOIDIUM);
        saplingItem(ModBlocks.EBONY_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "block/" + item.getId().getPath()));

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "item/" + item.getId().getPath()));

    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "item/" + item.getId().getPath()));

    }

}
