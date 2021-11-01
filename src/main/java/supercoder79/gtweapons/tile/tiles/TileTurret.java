package supercoder79.gtweapons.tile.tiles;

import gregapi.code.TagData;
import gregapi.data.TD;
import gregapi.tileentity.energy.ITileEntityEnergy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import supercoder79.superapi.math.DistMath;
import supercoder79.superapi.math.Point3D;
import supercoder79.superapi.math.PointDists;

import java.util.*;

//TODO: refactor this to not be shit

public class TileTurret extends TileEntity implements ITileEntityEnergy {
	public static int[] minEU = new int[]{16, 64, 256, 1024};
	public static int[] maxEU = new int[]{64, 256, 512, 2048};
	public static int[] recEU = new int[]{32, 96, 384, 1536};
	public static int[] useEU = new int[]{512, 1024, 2048, 4096};
	public static int[] strEU = new int[]{4096, 8192, 16384, 32768};
	public static int[] damage = new int[]{12, 16, 24, 40};
	public int tier = 0;
	public long energy = 0;
	List<Point3D> points = new ArrayList<Point3D>();

	public TileTurret(int tier) {
		this.tier = tier;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.energy = nbt.getLong("energy");
		this.tier = nbt.getInteger("tier");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setLong("energy", this.energy);
		nbt.setInteger("tier", this.tier);
	}


	@Override
	public void updateEntity() {
		if (this.worldObj.getTotalWorldTime() % 20 == 0) {
			points = new ArrayList<Point3D>();
			Point3D loc = new Point3D(this.xCoord, this.yCoord, this.zCoord);
			@SuppressWarnings("unchecked") List<EntityLivingBase> hostileList = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 10, this.zCoord - 10, this.xCoord + 10, this.yCoord + 10, this.zCoord + 10));
			for (EntityLivingBase z : hostileList) {
				points.add(new Point3D(z.posX, z.posY, z.posZ));
			}
			Map<Double, Entity> dists = new HashMap<Double, Entity>();
			List<Double> distsD = new ArrayList<Double>();
			for (Point3D p : points) {
				dists.put(DistMath.dist3D(loc, p), hostileList.get(points.indexOf(p)));
				distsD.add(DistMath.dist3D(loc, p));
			}
			PointDists.distX(loc, loc);
//            Collections.sort(hostileList, new Comparator<EntityLivingBase>() {
//                @Override
//                public int compare(EntityLivingBase o1, EntityLivingBase o2) {
//                    PointDists.distX(new Point3D(o1.posX, o1.posY, o1.posZ), new Point3D(o2.posX, o2.posY, o2.posZ));
//                    return 0;
//                }
//            });

//            TD.Energy.EU.AS_LIST

			if (distsD.size() > 0) {
				Collections.sort(distsD);

				for (int i = 0; i < dists.size(); i++) {
					Double closest = distsD.get(i);
					if (dists.get(closest).isCreatureType(EnumCreatureType.monster, false)) {
						if (energy >= useEU[tier]) {
							dists.get(closest).attackEntityFrom(DamageSource.causeIndirectMagicDamage(null, null), damage[tier]);
							energy -= useEU[tier];
							markDirty();
						}
						break;
					}
				}
			}

		}
	}


	@Override
	public boolean isEnergyType(TagData aEnergyType, byte aSide, boolean aEmitting) {
		return aEnergyType == TD.Energy.EU;
	}

	@Override
	public Collection<TagData> getEnergyTypes(byte aSide) {
		ArrayList<TagData> data = new ArrayList<TagData>();
		data.add(TD.Energy.EU);
		return data;
	}

	@Override
	public boolean isEnergyAcceptingFrom(TagData aEnergyType, byte aSide, boolean aTheoretical) {
		return aEnergyType == TD.Energy.EU;
	}

	@Override
	public boolean isEnergyEmittingTo(TagData aEnergyType, byte aSide, boolean aTheoretical) {
		return aEnergyType == TD.Energy.EU;
	}

	@Override
	public long doEnergyInjection(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoInject) {
		if (aEnergyType == TD.Energy.EU) {
			if (aSize > maxEU[tier]) {
				//blow up this machine
				float kaboom = 0f;
				switch (tier) {
					case 0:
						kaboom = 6f;
						break;
					case 1:
						kaboom = 12f;
						break;
					case 2:
						kaboom = 24f;
						break;
					case 3:
						kaboom = 48f;
						break;
				}
				this.worldObj.newExplosion(null, this.xCoord, this.yCoord, this.zCoord, kaboom, false, true);
			}
			if ((energy + aSize) < strEU[tier]) {
				energy += aSize;
				markDirty();
				return aAmount;
			} else
				return 0;
		} else
			return 0;
	}

	@Override
	public long getEnergyDemanded(TagData aEnergyType, byte aSide, long aSize) {
		if (aEnergyType == TD.Energy.EU) {
			return minEU[tier];
		} else
			return 0;
	}

	@Override
	public long doEnergyExtraction(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoExtract) {
		if (aEnergyType == TD.Energy.EU) {
			return minEU[tier];
		} else
			return 0;
	}

	@Override
	public long getEnergyOffered(TagData aEnergyType, byte aSide, long aSize) {
		return 0;
	}

	@Override
	public long getEnergySizeInputMin(TagData aEnergyType, byte aSide) {
		if (aEnergyType == TD.Energy.EU) {
			return minEU[tier];
		} else
			return 0;
	}

	@Override
	public long getEnergySizeOutputMin(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeInputRecommended(TagData aEnergyType, byte aSide) {
		if (aEnergyType == TD.Energy.EU) {
			return recEU[tier];
		} else
			return 0;
	}

	@Override
	public long getEnergySizeOutputRecommended(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeInputMax(TagData aEnergyType, byte aSide) {
		if (aEnergyType == TD.Energy.EU) {
			return maxEU[tier];
		} else
			return 0;
	}

	@Override
	public long getEnergySizeOutputMax(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public boolean isDead() {
		return false;
	}
}
