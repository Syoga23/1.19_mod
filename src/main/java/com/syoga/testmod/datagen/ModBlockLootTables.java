package com.syoga.testmod.datagen;

import com.syoga.testmod.block.ModBlocks;
import com.syoga.testmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ROTTEN_BLOCK.get());

        this.add(ModBlocks.VOIDIUM_ORE.get(), (block) ->
                createOreDrop(ModBlocks.VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
        add(ModBlocks.DEEPSLATE_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
        add(ModBlocks.NETHERRACK_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
        add(ModBlocks.ENDSTONE_VOIDIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_VOIDIUM_ORE.get(), ModItems.VOIDIUM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 7.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());


        this.add(ModBlocks.EBONY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
