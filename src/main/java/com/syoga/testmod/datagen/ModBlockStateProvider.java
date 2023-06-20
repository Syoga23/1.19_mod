package com.syoga.testmod.datagen;

import com.syoga.testmod.TestMod;
import com.syoga.testmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ROTTEN_BLOCK);
        blockWithItem(ModBlocks.VOIDIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_VOIDIUM_ORE);
        blockWithItem(ModBlocks.NETHERRACK_VOIDIUM_ORE);
        blockWithItem(ModBlocks.ENDSTONE_VOIDIUM_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}