package supercoder79.gtweapons.api.data.gun;

import gregapi.data.LH;

public enum Rarity {
	Common(LH.Chat.WHITE, "Common"),
	Uncommon(LH.Chat.GREEN, "Uncommon"),
	Rare(LH.Chat.BLUE, "Rare"),
	SuperRare(LH.Chat.PURPLE, "Super Rare"),
	Legendary(LH.Chat.GOLD, "Legendary"),

	//to be implemented later
	Mythic(LH.Chat.YELLOW, "Mythic"),
	Transcendent(LH.Chat.RED, "Transcendent"),
	Impossible(LH.Chat.RAINBOW, "Impossible");

	public String color;
	public String name;

	Rarity(String color, String name) {
		this.color = color;
		this.name = name;
	}
}
