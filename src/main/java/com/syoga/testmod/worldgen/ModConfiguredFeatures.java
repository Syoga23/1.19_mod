package com.syoga.testmod.worldgen;

import com.syoga.testmod.TestMod;
import com.syoga.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_VOIDIUM_ORE_KEY = registerKey("voidium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_VOIDIUM_ORE_KEY = registerKey("end_voidium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_VOIDIUM_ORE_KEY = registerKey("nether_voidium_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldVoidiumOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.VOIDIUM_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateReplaceables,
                ModBlocks.DEEPSLATE_VOIDIUM_ORE.get().defaultBlockState()));

        register(context, EBONY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                new StraightTrunkPlacer(5, 0, 0),
                BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, OVERWORLD_VOIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(
                overworldVoidiumOres, 5));
        register(context, END_VOIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables,
                ModBlocks.ENDSTONE_VOIDIUM_ORE.get().defaultBlockState(),3));
        register(context, NETHER_VOIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHERRACK_VOIDIUM_ORE.get().defaultBlockState(),7));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TestMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?,
            ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
