package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.util.ModItems;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;

import java.rmi.registry.RegistryHandler;

public class IronBoots extends ArmorItem {

    public IronBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    public void addInformation(ItemStack stack, World world, java.util.List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, world, list, flag);
        list.add(new StringTextComponent(TextFormatting.DARK_BLUE + "Sink or Sink"));
        list.add(new StringTextComponent(TextFormatting.GREEN + "Allows underwater ground movement"));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

            ExampleMod.LOGGER.debug("TEST");
            if (player.isInWater()) {

                ExampleMod.LOGGER.debug("Boot conditions are met.");

                Vector3d v = player.getMotion();

                player.setMotion(v.x, v.y -0.03D, v.z);

                ExampleMod.LOGGER.debug("Motion set");
            }else if(player.isInWater() && player.isOnGround()) {

            }

    }

}
