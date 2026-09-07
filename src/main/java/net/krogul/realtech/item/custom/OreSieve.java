package net.krogul.realtech.item.custom;

import net.krogul.realtech.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

public class OreSieve extends Item {
    private static final int USE_DURATION = 40; // 2 seconds (20 ticks per second)

    public OreSieve(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack sieveStack = player.getItemInHand(hand);

        // Check if player is in water
        if (player.isInWater()) {
            // Check if player has a dirty clump in the other hand
            InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ?
                InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
            ItemStack otherHandStack = player.getItemInHand(otherHand);

            if (isDirtyClump(otherHandStack)) {
                // Start the sieving process
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(sieveStack);
            }
        }

        return InteractionResultHolder.fail(sieveStack);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return USE_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH; // Animation similar to BRUSHING
    }

    private boolean isDirtyClump(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.dirty_iron_clump.get()) ||
               stack.is(ModItems.dirty_copper_clump.get()) ||
               stack.is(ModItems.dirty_gold_clump.get());
    }
}