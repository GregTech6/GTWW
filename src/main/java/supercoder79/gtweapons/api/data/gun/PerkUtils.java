package supercoder79.gtweapons.api.data.gun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerkUtils {
    public static List<List<String>> getPerkList(String compressed) { //turns the nbt string into a list list.
        String[] perks = compressed.split(";");
        List<String> list = Arrays.asList(perks);
        ArrayList<List<String>> perkList = new ArrayList<>();
        for (String string : list) {
            String[] perk = string.split("_");
            perkList.add(Arrays.asList(perk));
        }
        return perkList;
    }
}
