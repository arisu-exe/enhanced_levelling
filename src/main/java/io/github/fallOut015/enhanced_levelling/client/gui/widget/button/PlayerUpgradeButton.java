package io.github.fallOut015.enhanced_levelling.client.gui.widget.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.fallOut015.enhanced_levelling.client.gui.screen.PlayerUpgradesScreen;
import io.github.fallOut015.enhanced_levelling.common.capabilities.CapabilitiesEnhancedLevelling;
import io.github.fallOut015.enhanced_levelling.common.capabilities.UpgradeableAttribute;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class PlayerUpgradeButton extends Button {
    final UpgradeableAttribute attribute;
    final PlayerUpgradesScreen playerUpgradesScreen;

    public PlayerUpgradeButton(int x, int y, final UpgradeableAttribute attribute, final PlayerUpgradesScreen playerUpgradesScreen) {
        super(x, y, 38, 38, StringTextComponent.EMPTY, button -> {
            playerUpgradesScreen.getPlayer().getCapability(CapabilitiesEnhancedLevelling.PLAYER_UPGRADES).ifPresent(playerUpgrades -> {
                if(playerUpgrades.getUpgradePoints() >= attribute.getUpgradeCost()) {
                    attribute.increment();
                    playerUpgrades.setUpgradePoints(playerUpgrades.getUpgradePoints() - attribute.getUpgradeCost());
                }
            });
        });

        this.attribute = attribute;
        this.playerUpgradesScreen = playerUpgradesScreen;
    }

    public void renderButton(MatrixStack stack, int x, int y, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bind(PlayerUpgradesScreen.PLAYER_UPGRADES_LOCATION);
        this.blit(stack, this.x, this.y, this.attribute.getU(), this.attribute.getV(), 38, 38);
    }
}