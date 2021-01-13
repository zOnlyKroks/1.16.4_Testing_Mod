package com.example.examplemod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class TeleportItem extends Item {

    public TeleportItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote()) {
            if(worldIn.getDimensionType().equals(DimensionType.OVERWORLD)) {
                playerIn.sendMessage(new StringTextComponent("You may use the Dragon Egg or Netherrack on a Stick"), Util.DUMMY_UUID);
            }else{
                playerIn.changeDimension(worldIn.getServer().getWorld(World.OVERWORLD), new ITeleporter() {});
            }
            return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
        }
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
