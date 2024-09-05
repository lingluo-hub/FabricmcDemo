package com.lingluocloud.DataGen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.AdvancementEntry;

import java.util.function.Consumer;

public class AdvancementsProvider extends FabricAdvancementProvider {

    protected AdvancementsProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }
    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        new Advancements().accept(consumer);
    }
}
