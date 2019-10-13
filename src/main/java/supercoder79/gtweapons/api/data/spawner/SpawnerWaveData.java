package supercoder79.gtweapons.api.data.spawner;

import java.util.ArrayList;

public class SpawnerWaveData {
    // wave formats
    public static ArrayList<Integer> squaredWaveAmount = new ArrayList<>();
    //X X
    //
    //X X
    public static ArrayList<Integer> diamondWaveAmount = new ArrayList<>();
    // X
    //X X
    // X
    public static ArrayList<Integer> gridWaveAmount = new ArrayList<>();
    //XXX
    //X X
    //XXX

    //wave data
    public static ArrayList<Integer> waveDelay = new ArrayList<>();
    public static ArrayList<Integer> waveSpawnAmount = new ArrayList<>();
    //waveling data
    public static ArrayList<Integer> wavelingHealth = new ArrayList<>();
    public static ArrayList<Integer> wavelingDamage = new ArrayList<>();
    public static ArrayList<Double> wavelingSpeed = new ArrayList<>();

    static {
        waveDelay.add(0, 30);
        waveDelay.add(1, 25);
        waveDelay.add(2, 20);
        waveDelay.add(3, 15);
        waveDelay.add(4, 10); //good luck lol

        wavelingHealth.add(0, 12); // 6 hearts
        wavelingHealth.add(1, 16); // 8 hearts
        wavelingHealth.add(2, 24); // 12 hearts
        wavelingHealth.add(3, 32); // 16 hearts
        wavelingHealth.add(4, 48); // 24 hearts

        wavelingDamage.add(0, 2); // 1 heart
        wavelingDamage.add(1, 3); // 2.5 hearts
        wavelingDamage.add(2, 3); // 4 hearts
        wavelingDamage.add(3, 4); // 6 hearts
        wavelingDamage.add(4, 5); // 8 hearts

        wavelingSpeed.add(0, 0.4D);
        wavelingSpeed.add(1, 0.45D);
        wavelingSpeed.add(2, 0.45D);
        wavelingSpeed.add(3, 0.5D);
        wavelingSpeed.add(4, 0.65D);

        waveSpawnAmount.add(0, 2);
        waveSpawnAmount.add(1, 3);
        waveSpawnAmount.add(2, 3);
        waveSpawnAmount.add(3, 4);
        waveSpawnAmount.add(4, 5);


        squaredWaveAmount.add(0, 2);
        squaredWaveAmount.add(1, 4);
        squaredWaveAmount.add(2, 6);
        squaredWaveAmount.add(3, 8);
        squaredWaveAmount.add(4, 16);

        diamondWaveAmount.add(0, 2);
        diamondWaveAmount.add(1, 4);
        diamondWaveAmount.add(2, 6);
        diamondWaveAmount.add(3, 8);
        diamondWaveAmount.add(4, 16);

        gridWaveAmount.add(0, 0);
        gridWaveAmount.add(1, 1);
        gridWaveAmount.add(2, 2);
        gridWaveAmount.add(3, 3);
        gridWaveAmount.add(4, 4);
    }
}
