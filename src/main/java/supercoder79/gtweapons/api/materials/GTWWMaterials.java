package supercoder79.gtweapons.api.materials;

import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.FM;
import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;
import net.minecraftforge.fluids.Fluid;

import static gregapi.data.TD.ItemGenerator.G_CONTAINERS;
import static gregapi.data.TD.Properties.EXPLOSIVE;
import static gregapi.data.TD.Properties.FLAMMABLE;
import static supercoder79.gtweapons.GregTechWeaponWorks.MOD_ID;
import static supercoder79.gtweapons.GregTechWeaponWorks.MOD_NAME;

public class GTWWMaterials {
	public static OreDictMaterial MolotovMixture;
	public static OreDictMaterial LiqueficatedCoal;
	public static OreDictMaterial CoalGas;
	public static Fluid fluidMolotovMixture;
	public static Fluid fluidLiqueficatedCoal;
	public static Fluid fluidCoalGas;

	public static void init() {
		MolotovMixture = OreDictMaterial.createMaterial(30800, "fluidMolotovMixture", "Molotov Mixture");
		MolotovMixture.setTextures(gregapi.render.TextureSet.SET_FLUID);
		MolotovMixture.setRGBa(19, 175, 89, 0); // Sets the RGBa Color of the Material.
		MolotovMixture.setOriginalMod(MOD_ID, MOD_NAME);
		MolotovMixture.put(G_CONTAINERS, EXPLOSIVE, FLAMMABLE);

		LiqueficatedCoal = OreDictMaterial.createMaterial(30801, "fluidCoalLiquid", "Liquefacted Coal");
		LiqueficatedCoal.setTextures(TextureSet.SET_FLUID);
		LiqueficatedCoal.setRGBa(60, 60, 60, 0); // Sets the RGBa Color of the Material.
		LiqueficatedCoal.setOriginalMod(MOD_ID, MOD_NAME);
		LiqueficatedCoal.put(G_CONTAINERS, FLAMMABLE);

		CoalGas = OreDictMaterial.createMaterial(30802, "fluidCoalGas", "Coal Gas");
		CoalGas.setTextures(TextureSet.SET_FLUID);
		CoalGas.setRGBa(180, 180, 180, 0); // Sets the RGBa Color of the Material.
		CoalGas.setOriginalMod(MOD_ID, MOD_NAME);
		CoalGas.put(G_CONTAINERS, FLAMMABLE);

		fluidMolotovMixture = FL.create("Molotov Mixture", "Molotov Mixture", MolotovMixture, 1, 1000L, 300L, CS.FluidsGT.SIMPLE);
		fluidLiqueficatedCoal = FL.create("Liquefacted Coal", "Liquefacted Coal", LiqueficatedCoal, 1, 1000L, 300L, CS.FluidsGT.SIMPLE);
		fluidCoalGas = FL.create("Coal Gas", "Coal Gas", CoalGas, 2, 1000L, 300L, CS.FluidsGT.SIMPLE);
		FM.Burn.addRecipe0(true, -32L, 28L, FL.make(fluidLiqueficatedCoal, 1L), FL.DistW.make(5L), MT.CO2.gas(CS.U100, false));
		FM.Burn.addRecipe0(true, -64L, 12L, FL.make(fluidCoalGas, 1L), FL.DistW.make(10L), MT.CO2.gas(CS.U50, false));
		FM.Gas.addRecipe0(true, -64L, 20L, FL.make(fluidCoalGas, 1L), FL.DistW.make(10L), MT.CO2.gas(CS.U500, false));
	}
}
