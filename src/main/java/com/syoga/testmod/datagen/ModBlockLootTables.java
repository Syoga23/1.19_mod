package com.syoga.testmod.datagen;

import com.syoga.testmod.block.ModBlocks;
import com.syoga.testmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ROTTEN_BLOCK.get());

        add(ModBlocks.VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()));
        add(ModBlocks.DEEPSLATE_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()));
        add(ModBlocks.NETHERRACK_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()));
        add(ModBlocks.ENDSTONE_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}