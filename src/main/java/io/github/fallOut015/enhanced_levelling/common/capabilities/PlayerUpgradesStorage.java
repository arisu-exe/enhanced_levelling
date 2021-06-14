package io.github.fallOut015.enhanced_levelling.common.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerUpgradesStorage implements Capability.IStorage<IPlayerUpgrades> {
    @Override
    public INBT writeNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putString("data", instance.serialize());
        return nbt;
    }
    @Override
    public void readNBT(Capability<IPlayerUpgrades> capability, IPlayerUpgrades instance, Direction side, INBT nbt) {
        if(nbt instanceof CompoundNBT) {
            instance.deserialize(((CompoundNBT) nbt).getString("data"));
        }
    }
}