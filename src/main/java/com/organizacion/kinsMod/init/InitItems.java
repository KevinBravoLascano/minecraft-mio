package com.organizacion.kinsMod.init;

import com.organizacion.kinsMod.pe;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister <Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, pe.MODID

    );
    public static final RegistryObject<Item> POKEBALL = ITEMS.register(
            "pokebola",()-> new ThrowablePotionItem(new Item.Properties()
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().alwaysEat().build())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .fireResistant()

            )
    );
    public static final RegistryObject<SwordItem> ESPADADRAGON = ITEMS.register(
            "dragon_sword_fire",()-> new SwordItem(
                    Tiers.DIAMOND,
                    5,
                    3.5f,

                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()
            )

    );
    public static final RegistryObject<Item> MENU_ITEM = ITEMS.register("menu_item",
            () -> new ItemMenu(new Item.Properties().stacksTo(1)));

}
