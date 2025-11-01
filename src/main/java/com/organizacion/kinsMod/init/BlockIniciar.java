package com.organizacion.kinsMod.init;

import com.organizacion.kinsMod.pe;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.management.MBeanServerInvocationHandler;
import java.util.function.Supplier;

public class BlockIniciar {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, pe.MODID);

    public static final RegistryObject<Block> EJEMPLO_BLOCK= register(
            "ejemplo_block",()->new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(2.5f).requiresCorrectToolForDrops()),new Item.Properties()
                    .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
                    .stacksTo(64)

    );

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> sup, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, sup);
        InitItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
