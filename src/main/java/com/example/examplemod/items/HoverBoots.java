package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.NBTCompoundTagArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.Timer;

public class HoverBoots extends ArmorItem {

    public HoverBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    final Timer timer = new Timer();

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
                if(world.getGameTime() % 1300 == 0) {
                    BlockPos down = player.getPosition().down();
                    Block blockState = world.getBlockState(down).getBlock();
                    double y = player.getPositionVec().getY();
                    long yRounded = Math.round(y);
                    if (blockState == Blocks.AIR ||
                            blockState == Blocks.CAVE_AIR ||
                            blockState == Blocks.VOID_AIR ||
                            (double)yRounded != y) {
                        double x = player.getMotion().x;
                        double z = player.getMotion().z;
                        player.setMotion(x, 0, z);

                    }
                }else if(world.getGameTime() < 5 * 20) {
                    player.sendMessage(new StringTextComponent("Hover Disabled"), Util.DUMMY_UUID);
        }
    }
}
