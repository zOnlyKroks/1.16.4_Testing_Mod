package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.items.HoverBoots;
import com.example.examplemod.items.IronBoots;
import com.example.examplemod.items.MoonPearl;
import com.example.examplemod.items.TeleportItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    @SuppressWarnings("deprecation")
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS , "examplemod");

    public static final RegistryObject<Item> MOON_PEARL = ITEMS.register("moon_pearl", () -> new MoonPearl((new Item.Properties()).group(ExampleMod.TAB)));
    public static final RegistryObject<Item> TP_ITEM = ITEMS.register("tp_item", () -> new TeleportItem((new Item.Properties()).group(ExampleMod.TAB)));

    public static RegistryObject<ArmorItem> IRON_BOOTS_2 = ITEMS.register("iron_boots_2", () -> new IronBoots((IArmorMaterial) ArmorMaterial.IRON, EquipmentSlotType.FEET, (new Item.Properties()).group(ExampleMod.TAB)));
    public static RegistryObject<ArmorItem> HOVER_BOOTS = ITEMS.register("hover_boots", () -> new HoverBoots((IArmorMaterial) ArmorMaterial.IRON, EquipmentSlotType.FEET, (new Item.Properties()).group(ExampleMod.TAB)));

}
