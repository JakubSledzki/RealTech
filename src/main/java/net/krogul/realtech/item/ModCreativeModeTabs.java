package net.krogul.realtech.item;

import java.util.function.Supplier;

import net.krogul.realtech.RealTech;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RealTech.MOD_ID);

    public static final Supplier<CreativeModeTab> REALTECH_TAB = CREATIVE_MODE_TAB.register("realtech_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ore_sieve.get()))
                    .title(Component.translatable("RealTech"))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.ore_sieve.get());
                        output.accept(ModItems.sandpaper.get());
                        output.accept(ModItems.dirty_iron_clump.get());
                        output.accept(ModItems.dirty_copper_clump.get());
                        output.accept(ModItems.dirty_gold_clump.get());
                        output.accept(ModItems.clean_iron_clump.get());
                        output.accept(ModItems.clean_copper_clump.get());
                        output.accept(ModItems.clean_gold_clump.get());
                        output.accept(ModItems.ruby_gem.get());
                        output.accept(ModItems.saphire_gem.get());
                        output.accept(ModItems.uncut_ruby_gem.get());
                        output.accept(ModItems.uncut_saphire_gem.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}