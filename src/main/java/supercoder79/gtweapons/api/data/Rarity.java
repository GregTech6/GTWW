package supercoder79.gtweapons.api.data;

import gregapi.data.LH;
import net.minecraft.util.EnumChatFormatting;

public enum Rarity {
    Common(LH.Chat.WHITE, "Common"),
    Uncommon(LH.Chat.GREEN, "Uncommon"),
    Rare(LH.Chat.BLUE, "Rare"),
    SuperRare(LH.Chat.PURPLE, "Super Rare"),
    Legendary(LH.Chat.GOLD, "Legendary");

    public String color;
    public String name;
    Rarity(String color, String name) {
        this.color = color;
        this.name = name;
    }
}
