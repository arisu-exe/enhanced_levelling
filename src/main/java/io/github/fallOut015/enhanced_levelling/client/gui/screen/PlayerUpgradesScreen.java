package io.github.fallOut015.enhanced_levelling.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.fallOut015.enhanced_levelling.MainEnhancedLevelling;
import io.github.fallOut015.enhanced_levelling.client.gui.widget.button.PlayerUpgradeButton;
import io.github.fallOut015.enhanced_levelling.common.capabilities.CapabilitiesEnhancedLevelling;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class PlayerUpgradesScreen extends Screen {
    private static final ITextComponent PLAYER_UPGRADES = new TranslationTextComponent("gui.player_upgrades");
    public static final ResourceLocation PLAYER_UPGRADES_LOCATION = new ResourceLocation(MainEnhancedLevelling.MODID, "textures/gui/player_upgrades.png");
    ClientPlayerEntity playerEntity;

    public PlayerUpgradesScreen(ClientPlayerEntity playerEntity) {
        super(PLAYER_UPGRADES);

        this.playerEntity = playerEntity;
    }

    protected void createButtons() {
        this.playerEntity.getCapability(CapabilitiesEnhancedLevelling.PLAYER_UPGRADES).ifPresent(playerUpgrades -> {
            this.addButton(new PlayerUpgradeButton(this.width / 2 - 100, 196, playerUpgrades.getHealth(), this));
        });
    }

    @Override
    protected void init() {
        this.createButtons();
    }
    @Override
    public void render(MatrixStack stack, int x, int y, float partialTicks) {
        this.renderBackground(stack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(PLAYER_UPGRADES_LOCATION);
        int i = (this.width - 26) / 2;
        this.blit(stack, i, 2, 0, 0, 168, 192);

        super.render(stack, x, y, partialTicks);
    }

    public ClientPlayerEntity getPlayer() {
        return this.playerEntity;
    }
}