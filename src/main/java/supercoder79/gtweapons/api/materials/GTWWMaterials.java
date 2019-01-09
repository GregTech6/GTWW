package supercoder79.gtweapons.api.materials;

import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.FM;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;
import gregapi.util.UT;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.Set;

import static gregapi.data.TD.ItemGenerator.G_CONTAINERS;
import static gregapi.data.TD.Properties.EXPLOSIVE;
import static gregapi.data.TD.Properties.FLAMMABLE;
import static supercoder79.gtweapons.GregTechWeaponWorks.*;

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

        fluidMolotovMixture = UT.Fluids.create("Molotov Mixture", "Molotov Mixture", MolotovMixture, 1, 1000L, 300L, new Set[] { CS.FluidsGT.SIMPLE });
        fluidLiqueficatedCoal = UT.Fluids.create("Liquefacted Coal", "Liquefacted Coal", LiqueficatedCoal, 1, 1000L, 300L, new Set[] { CS.FluidsGT.SIMPLE });
        fluidCoalGas = UT.Fluids.create("Coal Gas", "Coal Gas", CoalGas, 2, 1000L, 300L, new Set[] { CS.FluidsGT.SIMPLE });
        FM.Burn.addRecipe0(true, -32L, 24L, UT.Fluids.make(fluidLiqueficatedCoal, 5L), new FluidStack[]{FL.DistW.make(5L), UT.Fluids.make("carbondioxide", 10L)});
        FM.Burn.addRecipe0(true, -24L, 16L, UT.Fluids.make(fluidCoalGas, 10L), new FluidStack[]{FL.DistW.make(10L), UT.Fluids.make("carbondioxide", 20L)});
    }
}
