package com.syoga.testmod;

import com.mojang.logging.LogUtils;
import com.syoga.testmod.block.ModBlocks;
import com.syoga.testmod.item.ModCreativeModeTabs;
import com.syoga.testmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    //very important comment

    public TestMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ROTTIUM);
            event.accept(ModItems.VOIDIUM);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.ROTTEN_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.VOIDIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_VOIDIUM_ORE);
            event.accept(ModBlocks.NETHERRACK_VOIDIUM_ORE);
            event.accept(ModBlocks.ENDSTONE_VOIDIUM_ORE);
        }

        if (event.getTab() == ModCreativeModeTabs.TESTMOD_TAB) {
            event.accept(ModItems.ROTTIUM);
            event.accept(ModItems.VOIDIUM);

            event.accept(ModBlocks.ROTTEN_BLOCK);
            event.accept(ModBlocks.VOIDIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_VOIDIUM_ORE);
            event.accept(ModBlocks.NETHERRACK_VOIDIUM_ORE);
            event.accept(ModBlocks.ENDSTONE_VOIDIUM_ORE);

        }

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
        }
    }
}
