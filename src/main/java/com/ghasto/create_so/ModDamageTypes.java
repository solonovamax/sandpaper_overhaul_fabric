package com.ghasto.create_so;

import com.simibubi.create.foundation.damageTypes.DamageTypeBuilder;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class ModDamageTypes {
	public static final ResourceKey<DamageType> SANDPAPER = key("sandpaper");

	public static DamageSource sandpaper(Level level) {
		return source(SANDPAPER, level);
	}

	private static DamageSource source(ResourceKey<DamageType> key, LevelReader level) {
		Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
		return new DamageSource(registry.getHolderOrThrow(key));
	}

	private static ResourceKey<DamageType> key(String path) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateSandpaperOverhaul.ID, path));
	}

	public static void bootstrap(BootstapContext<DamageType> ctx) {
		new DamageTypeBuilder(SANDPAPER)
				.exhaustion(2.0f)
				.register(ctx);
	}
}
