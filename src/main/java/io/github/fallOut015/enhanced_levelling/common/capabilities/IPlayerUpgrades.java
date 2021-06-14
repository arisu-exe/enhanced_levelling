package io.github.fallOut015.enhanced_levelling.common.capabilities;

public interface IPlayerUpgrades {
    int getUpgradePoints();
    void setUpgradePoints(int upgradePoints);

    UpgradeableAttribute getHealth();
    UpgradeableAttribute getHunger();
    UpgradeableAttribute getArmor();
    UpgradeableAttribute getBreathing();

    String serialize();
    void deserialize(String serialized);
}