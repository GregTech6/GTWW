package supercoder79.gtweapons.api;

import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;

/**
 * @author SuperCoder79.
 */
public class MatHelpers {
    public static int[] baseDamage = {0, 2, 8, 0, 6, 3, 0};
    private static String[] damageStrings = {"Unusable. I hope you're happy.", "Why are you still using this gun!?!?", "This gun will cause damage to its user!", "Be careful with this gun!", "You should be getting a new gun", "Major mechanical wear and tear", "Minor mechanical wear and tear", "Fair condition", "Good condition", "Great condition", "Mint Condition" };

    public static int getDamageFromMaterial(int matID, int type){
        OreDictMaterial material = OreDictMaterial.MATERIAL_ARRAY[matID];
        int damage = baseDamage[type] + (int)material.mToolSpeed;
        damage = damage << (material.mToolQuality);
        damage = (int)(damage / (material.mToolSpeed / 2));
        if (type == 0)
            if ((damage) > 12)
                damage = 12;
        if (type == 1)
            if ((damage) > 24)
                damage = 24;
        if (type == 2)
            if ((damage) > 100)
                damage = 100;
        if (type == 3)
            if ((damage) > 40)
                damage = 40;
        if (type == 4)
            if ((damage) > 50)
                damage = 50;
        if (type == 5)
            if ((damage) > 40)
                damage = 40;
        if (type == 6)
            if ((damage) > 40)
                damage = 40;


        if (damage < 8 && type != 2) {
            damage = 8;
            if (material == MT.Co)
                damage = 8;
        }
        else if (damage < 30 && type == 2) {
            damage = 30;
            if (material == MT.Co)
                damage = 30;
        }
        if (type == 3 || type == 6) {
            damage /= 2;
        }

        return damage;

    }
    public static String getDamageSimpleString(int amount, int max){
        String text = "Mint Condition";
        int percent = Math.round(amount/max)*100;
        text = damageStrings[getDamageSimple(amount, max)];
        return text;
    }
    public static int getDamageSimple(int min, int max){
        int percent = (int)((min/(float)max)*100); //fucking java
        if (percent == 100 || percent == 0)
            return 10;
        else if (percent < 100 && percent > 90)
            return 9;
        else if (percent < 91 && percent > 80)
            return 8;
        else if (percent < 81 && percent > 70)
            return 7;
        else if (percent < 71 && percent > 60)
            return 6;
        else if (percent < 61 && percent > 50)
            return 5;
        else if (percent < 51 && percent > 40)
            return 4;
        else if (percent < 41 && percent > 30)
            return 3;
        else if (percent < 31 && percent > 20)
            return 2;
        else if (percent < 21 && percent > 10)
            return 1;
        else if (percent < 11 && percent > 0)
            return 0;
        return 0;
    }
}
