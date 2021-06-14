package io.github.fallOut015.enhanced_levelling.common.capabilities;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class UpgradeableAttribute {
    Attribute attribute;
    int bonus;
    final int u, v;

    UpgradeableAttribute(Attribute attribute, final int u, final int v) {
        this.attribute = attribute;
        this.bonus = 0;
        this.u = u;
        this.v = v;
    }

    public int getUpgradeCost() {
        return this.bonus + 1;
    }
    public int getBonus() {
        return this.bonus;
    }
    public void increment() {
        ++ this.bonus;
    }

    public int getU() {
        return this.u;
    }
    public int getV() {
        return this.v;
    }

    public String serialize() {
        return this.attribute.getRegistryName() + "-" + this.bonus;
    }
    public void deserialize(String serialized) {
        String[] data = serialized.split("-");
        this.attribute = Registry.ATTRIBUTE.get(new ResourceLocation(data[0]));
        this.bonus = Integer.parseInt(data[1]);
    }
}