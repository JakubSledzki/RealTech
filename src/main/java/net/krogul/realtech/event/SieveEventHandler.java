package net.krogul.realtech.event;

import net.krogul.realtech.RealTech;
import net.krogul.realtech.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber(modid = RealTech.MOD_ID)
public class SieveEventHandler {

    @SubscribeEvent
    public static void onItemUseTick(LivingEntityUseItemEvent.Tick event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack usedStack = event.getItem();
        if (!usedStack.is(ModItems.ore_sieve.get())) return;
        if (!player.isInWater()) return;

        // Play sound
        if (!player.level().isClientSide()) {
            if (event.getDuration() %20 == 0) {
                player.level().playSound(null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.WATER_AMBIENT,
                    SoundSource.PLAYERS, 1.0f, 1.2f);
            }
        }

        // Spawn bubbles every 5 ticks on client side
        if (player.level().isClientSide()) {
            if (event.getDuration() % 5 == 0) {
                for (int i = 0; i < 3; i++) {
                    double x = player.getX() + (player.getRandom().nextDouble() - 0.5) * 0.6;
                    double y = player.getY() + player.getBbHeight() * 0.5;
                    double z = player.getZ() + (player.getRandom().nextDouble() - 0.5) * 0.6;
                    player.level().addParticle(
                        ParticleTypes.BUBBLE,
                        x, y, z,
                        0, 0.05, 0
                    );
                }
            }
        }
    }

    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack usedStack = event.getItem();

        // Check if player used sieve
        if (usedStack.is(ModItems.ore_sieve.get())) {
            // Check if player is in water
            if (!player.isInWater()) return;

            // Find the dirty clump in other hand
            InteractionHand otherHand = player.getUsedItemHand() == InteractionHand.MAIN_HAND ?
                InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
            ItemStack otherHandStack = player.getItemInHand(otherHand);

            if (otherHandStack.isEmpty()) return;

            // Determine which clean clump to give based on dirty clump
            ItemStack cleanClump = getCleanClump(otherHandStack);

            if (!cleanClump.isEmpty()) {
                // Remove one dirty clump
                otherHandStack.shrink(1);

                // Give clean clump
                if (!player.getInventory().add(cleanClump.copy())) {
                    player.drop(cleanClump.copy(), false);
                }

                // Play sound
                if (!player.level().isClientSide()) {
                    player.level().playSound(null,
                        player.getX(), player.getY(), player.getZ(),
                        SoundEvents.AMBIENT_UNDERWATER_EXIT,
                        SoundSource.PLAYERS, 1.0f, 1.2f);
                }

                // Damage the sieve
                EquipmentSlot slot = player.getUsedItemHand() == InteractionHand.MAIN_HAND ?
                    EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                usedStack.hurtAndBreak(1, player, slot);
            }
        }
    }

    private static ItemStack getCleanClump(ItemStack dirtyClump) {
        if (dirtyClump.is(ModItems.dirty_iron_clump.get())) {
            return new ItemStack(ModItems.clean_iron_clump.get());
        } else if (dirtyClump.is(ModItems.dirty_copper_clump.get())) {
            return new ItemStack(ModItems.clean_copper_clump.get());
        } else if (dirtyClump.is(ModItems.dirty_gold_clump.get())) {
            return new ItemStack(ModItems.clean_gold_clump.get());
        }
        return ItemStack.EMPTY;
    }
}