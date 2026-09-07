package net.krogul.realtech.event;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber(modid = RealTech.MOD_ID)
public class SandpaperEventHandler {

    @SubscribeEvent
    public static void onItemUseTick(LivingEntityUseItemEvent.Tick event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack usedStack = event.getItem();
        if (!usedStack.is(ModItems.sandpaper.get())) return;

        // Play sound
        if (!player.level().isClientSide()) {
            if (event.getDuration() % 10 == 0) {
                player.level().playSound(null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.GRINDSTONE_USE,
                    SoundSource.PLAYERS, 0.4f, 1.2f);
            }
        }
    }

    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack usedStack = event.getItem();

        // Check if player used sandpaper
        if (usedStack.is(ModItems.sandpaper.get())) {

            // Find the uncut gem in other hand
            InteractionHand otherHand = player.getUsedItemHand() == InteractionHand.MAIN_HAND ?
                InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
            ItemStack otherHandStack = player.getItemInHand(otherHand);

            if (otherHandStack.isEmpty()) return;

            // Determine which polished gem to give based on uncut gem
            ItemStack cutGem = getCutGem(otherHandStack);

            if (!cutGem.isEmpty()) {
                // Remove one uncut gem
                otherHandStack.shrink(1);

                // Give polished gem
                if (!player.getInventory().add(cutGem.copy())) {
                    player.drop(cutGem.copy(), false);
                }

                // Damage the sandpaper
                EquipmentSlot slot = player.getUsedItemHand() == InteractionHand.MAIN_HAND ?
                    EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                usedStack.hurtAndBreak(1, player, slot);
            }
        }
    }

    private static ItemStack getCutGem(ItemStack uncutGem) {
        if (uncutGem.is(ModItems.uncut_ruby_gem.get())) {
            return new ItemStack(ModItems.ruby_gem.get());
        } else if (uncutGem.is(ModItems.uncut_sapphire_gem.get())) {
            return new ItemStack(ModItems.sapphire_gem.get());
        } else if (uncutGem.is(ModItems.uncut_diamond_gem.get())) {
            return new ItemStack(Items.DIAMOND);
        }
        return ItemStack.EMPTY;
    }
}
