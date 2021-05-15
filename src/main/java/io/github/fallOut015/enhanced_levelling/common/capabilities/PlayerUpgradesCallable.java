package io.github.fallOut015.enhanced_levelling.common.capabilities;

import java.util.concurrent.Callable;

public class PlayerUpgradesCallable implements Callable<IPlayerUpgrades> {
    private static final IPlayerUpgrades PLAYER_UPGRADES;

    static {
        PLAYER_UPGRADES = new PlayerUpgrades();
    }

    @Override
    public IPlayerUpgrades call() throws Exception {
        return PLAYER_UPGRADES;
    }
}