package net.krogul.realtech.item.custom;

import net.krogul.realtech.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;


public class Sandpaper extends Item {
    private static final int USE_DURATION = 40; // 2 second (20 ticks per second)
    
    public Sandpaper(Properties properties) {
        super(properties);
    }
    
    @Override 
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack sandpaperStack = player.getItemInHand(hand);
        
        InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ?
            InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otherHandStack = player.getItemInHand(otherHand);

        if (isUncutGem(otherHandStack)) {
                // Start the sanding process
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(sandpaperStack);
            }
        
        return InteractionResultHolder.fail(sandpaperStack);
    }

    @Override 
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return USE_DURATION;
    }

    @Override 
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH; // Animation similar to BRUSHING
    }

    private boolean isUncutGem(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.uncut_ruby_gem.get()) ||
               stack.is(ModItems.uncut_sapphire_gem.get()) ||
               stack.is(ModItems.uncut_diamond_gem.get());
    }




}
