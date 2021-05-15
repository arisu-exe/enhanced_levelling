package io.github.fallOut015.enhanced_levelling.common.capabilities;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerUpgradesProvider implements ICapabilityProvider {
    final IPlayerUpgrades playerUpgrades;

    public PlayerUpgradesProvider(final IPlayerUpgrades playerUpgrades) {
        this.playerUpgrades = playerUpgrades;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if(cap == CapabilitiesEnhancedLevelling.PLAYER_UPGRADES) {
            return (LazyOptional<T>) LazyOptional.of(() -> this.playerUpgrades);
        }
        return null;
    }
}