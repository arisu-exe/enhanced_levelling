package io.github.fallOut015.enhanced_levelling.common.capabilities;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.ForgeRegistries;

import javax.management.Attribute;

public class PlayerUpgrades implements IPlayerUpgrades {
    int upgradePoints;

    final UpgradeableAttribute health;
    final UpgradeableAttribute hunger;
    final UpgradeableAttribute armor;
    final UpgradeableAttribute breathing;

    PlayerUpgrades() {
        this.upgradePoints = 0;

        this.health = new UpgradeableAttribute(Attributes.MAX_HEALTH, 0, 167);
        this.hunger = new UpgradeableAttribute(null, 0, 167);
        this.armor = new UpgradeableAttribute(Attributes.ARMOR, 38, 167);
        this.breathing = new UpgradeableAttribute(null, 38, 167);
    }

    @Override
    public int getUpgradePoints() {
        return this.upgradePoints;
    }
    @Override
    public void setUpgradePoints(int upgradePoints) {
        this.upgradePoints = upgradePoints;
    }

    public final UpgradeableAttribute getHealth() {
        return this.health;
    }
    public final UpgradeableAttribute getHunger() {
        return this.hunger;
    }
    public final UpgradeableAttribute getArmor() {
        return this.armor;
    }
    public final UpgradeableAttribute getBreathing() {
        return this.breathing;
    }

    public String serialize() {
        return this.health.serialize() + ";" + this.hunger.serialize() + ";" + this.armor.serialize() + ";" + this.breathing.serialize();
    }
    public void deserialize(String serialized) {
        String[] data = serialized.split(";");
        this.health.deserialize(data[0]);
        this.hunger.deserialize(data[1]);
        this.armor.deserialize(data[2]);
        this.breathing.deserialize(data[3]);
    }
}