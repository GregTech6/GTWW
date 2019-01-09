package supercoder79.gtweapons.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import supercoder79.gtweapons.api.NBTUtils;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.item.items.ItemGun;
import supercoder79.gtweapons.item.items.ItemUnlockableGun;

public class AmmoRenderHandler {

    @SubscribeEvent
    public void onRendertext(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityClientPlayerMP player = mc.thePlayer;
        if (ConfigHandler.ShowUI) {
            if (player != null && player.inventory != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() != null) {
                if (player.inventory.getCurrentItem().getItem() instanceof ItemUnlockableGun) {
                    //String tallness: 9
                    int ammo = NBTUtils.NBTGetInteger(player.inventory.getCurrentItem(), "ammo");
                    int health = NBTUtils.NBTGetInteger(player.inventory.getCurrentItem(), "health");
                    int maxHealth = NBTUtils.NBTGetInteger(player.inventory.getCurrentItem(), "maxHealth");
                    int color = 0xFFFFFF;
                    float decimal = (float) ((float) (health) / (float) (maxHealth));
                    int percent = (int) (decimal * 100);
                    if (health == 0) {
                        percent = 100;
                    }
                    if (percent <= 50) {
                        color = 0xFFA500;
                    }
                    if (percent <= 25) {
                        color = 0xFF0000;
                    }
                    if (percent <= 10) {
                        color = 0xBB0000;
                    }
                    mc.fontRenderer.drawString("Ammo: " + ammo, 0, 0, 0xFFFFFF, true);
                    mc.fontRenderer.drawString("Durability: " + percent + "%", 0, 9, color, true);
                }
                if (player.inventory.getCurrentItem().getItem() instanceof ItemGun) {
                    //String tallness: 9
                    int ammo = NBTUtils.NBTGetInteger(player.inventory.getCurrentItem(), "ammo");
                    int health = NBTUtils.NBTGetInteger(player.inventory.getCurrentItem(), "health");
                    int maxHealth = ItemGun.maxHealth[player.inventory.getCurrentItem().getItemDamage()];
                    int color = 0xFFFFFF;
                    float decimal = (float) ((float) (health) / (float) (maxHealth));
                    int percent = (int) (decimal * 100);
                    if (health == 0) {
                        percent = 100;
                    }
                    if (percent <= 50) {
                        color = 0xFFA500;
                    }
                    if (percent <= 25) {
                        color = 0xFF0000;
                    }
                    if (percent <= 10) {
                        color = 0xBB0000;
                    }
                    mc.fontRenderer.drawString("Ammo: " + ammo, 0, 0, 0xFFFFFF, true);
                    mc.fontRenderer.drawString("Durability: " + percent + "%", 0, 9, color, true);
                }
            }
        }
    }
}
