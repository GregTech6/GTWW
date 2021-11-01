package supercoder79.gtweapons.tile.tiles;

import gregapi.util.UT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileSpawner extends TileEntity {
	public boolean valid = false;
	public boolean started = false;
	public int tier;

	public TileSpawner(int tier) {
		if (tier == 5) {
			this.tier = 4;
		} else {
			this.tier = tier;
		}
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	public void rightClicked(World world, int x, int y, int z, EntityPlayer player) {
		//System.out.println("Clicked!");
		if (!valid) {
			boolean good = checkArea(world, x, y, z);
			if (good) {
				this.valid = true;
				UT.Entities.sendchat(player, "[GTWW] Area is good! Right click again to start.");
			} else {
				UT.Entities.sendchat(player, "[GTWW] Please clear a flat 9x9 area around this block to continue.");
			}
		} else {
			if (!started) {
				UT.Entities.sendchat(player, "[GTWW] Starting! Good luck...");
				started = true;
			}
		}
	}

	private boolean checkArea(World world, int x, int y, int z) {
		boolean good = true;
		for (int xCoord = x - 4; xCoord < x + 5; xCoord++) {
			for (int zCoord = z - 4; zCoord < z + 5; zCoord++) {
				if (x == xCoord && zCoord == z) {
					//pass
				} else {
					good = world.canBlockSeeTheSky(xCoord, y, zCoord);
                        /*
                        if (world.canBlockSeeTheSky(xCoord, y - 1, zCoord)) {
                            if (world.isAirBlock(xCoord, y - 1, zCoord)) {
                                good = false;
                                break;
                            } else {

                            }
                        } else {
                            good = false;
                            break;
                        }
                        */
				}
			}
			if (!good) {
				break;
			}
		}
		return good;
	}
}
