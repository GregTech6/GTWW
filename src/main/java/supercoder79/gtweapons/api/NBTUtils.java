package supercoder79.gtweapons.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 *@author SuperCoder79.
 */

public class NBTUtils {
    public static int NBTGetInteger(ItemStack stack, String name){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        if (nbt.hasKey(name)) { //check if the key exists
            return nbt.getInteger(name); //if the key does exist, simply return
        } else {
            nbt.setInteger(name, 0); //if the key doesnt exist, initalize the key to 0
            return -1; // TODO: create error condition to acknowledge this
        }
    }
    public static ItemStack NBTSetInteger(ItemStack stack, String name, int amount){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        nbt.setInteger(name, amount);
        return stack;
    }
    public static long NBTGetLong(ItemStack stack, String name){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        if (nbt.hasKey(name)) { //check if the key exists
            return nbt.getLong(name); //if the key does exist, simply return
        } else {
            nbt.setInteger(name, 0); //if the key doesnt exist, initalize the key to 0
            return -1;
        }
    }
    public static ItemStack NBTSetLong(ItemStack stack, String name, long amount){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        nbt.setLong(name, amount);
        return stack;
    }

    public static boolean NBTGetBoolean(ItemStack stack, String name){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        if (nbt.hasKey(name)) { //check if the key exists
            return nbt.getBoolean(name); //if the key does exist, simply return
        } else {
            nbt.setBoolean(name, false); //if the key doesnt exist, initalize the key to false
            return false;
        }
    }
    public static ItemStack NBTSetBoolean(ItemStack stack, String name, boolean amount){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        nbt.setBoolean(name, amount);
        return stack;
    }

    public static String NBTGetString(ItemStack stack, String name){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        if (nbt.hasKey(name)) { //check if the key exists
            return nbt.getString(name); //if the key does exist, simply return
        } else {
            nbt.setString(name, ""); //if the key doesnt exist, initalize the key to false
            return "";
        }
    }
    public static ItemStack NBTSetString(ItemStack stack, String name, String amount){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        nbt.setString(name, amount);
        return stack;
    }
}
