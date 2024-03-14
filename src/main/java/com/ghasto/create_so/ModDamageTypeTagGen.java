package com.ghasto.create_so;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.data.PortingLibTagsProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypeTagGen extends PortingLibTagsProvider<DamageType> {
	ModDamageTypeTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
						ExistingFileHelper existingFileHelper) {
		super(output, Registries.DAMAGE_TYPE, lookupProvider, existingFileHelper);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider provider) {
		tag(DamageTypeTags.BYPASSES_ARMOR)
				.add(ModDamageTypes.SANDPAPER);
	}

	@NotNull
	@Override
	public String getName() {
		return "Create Sandpaper Overhaul's Damage Type Tags";
	}
}
