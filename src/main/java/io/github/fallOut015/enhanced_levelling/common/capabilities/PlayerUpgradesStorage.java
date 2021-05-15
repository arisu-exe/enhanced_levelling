package io.github.fallOut015.enhanced_levelling.common.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerUpgradesStorage implements Capability.IStorage<IPlayerUpgrades> {
    @Override
    public INBT writeNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("upgradePoints", instance.getUpgradePoints());
        nbt.putDouble("health", instance.getHealth());
        nbt.putDouble("hunger", instance.getHunger());
        nbt.putDouble("armor", instance.getArmor());
        nbt.putDouble("breathing", instance.getBreathing());
        return nbt;
    }
    @Override
    public void readNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side, INBT nbt) {
        if(nbt instanceof CompoundNBT) {
            instance.setUpgradePoints(((CompoundNBT) nbt).getInt("upgradePoints"));
            instance.setHealth(((CompoundNBT) nbt).getDouble("health"));
            instance.setHunger(((CompoundNBT) nbt).getDouble("hunger"));
            instance.setArmor(((CompoundNBT) nbt).getDouble("armor"));
            instance.setBreathing(((CompoundNBT) nbt).getDouble("breathing"));
        }
    }
}