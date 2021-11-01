package supercoder79.gtweapons.block;

import gregapi.code.TagData;
import gregapi.tileentity.energy.ITileEntityEnergy;

import java.util.Collection;

/**
 * @author SuperCoder79.
 */
public class MaybeADieselEngine implements ITileEntityEnergy {
	@Override
	public boolean isEnergyType(TagData aEnergyType, byte aSide, boolean aEmitting) {
		return false;
	}

	@Override
	public Collection<TagData> getEnergyTypes(byte aSide) {
		return null;
	}

	@Override
	public boolean isEnergyAcceptingFrom(TagData aEnergyType, byte aSide, boolean aTheoretical) {
		return false;
	}

	@Override
	public boolean isEnergyEmittingTo(TagData aEnergyType, byte aSide, boolean aTheoretical) {
		return false;
	}

	@Override
	public long doEnergyInjection(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoInject) {
		return 0;
	}

	@Override
	public long getEnergyDemanded(TagData aEnergyType, byte aSide, long aSize) {
		return 0;
	}

	@Override
	public long doEnergyExtraction(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoExtract) {
		return 0;
	}

	@Override
	public long getEnergyOffered(TagData aEnergyType, byte aSide, long aSize) {
		return 0;
	}

	@Override
	public long getEnergySizeInputMin(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeOutputMin(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeInputRecommended(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeOutputRecommended(TagData aEnergyType, byte aSide) {
		return 0;
	}

	@Override
	public long getEnergySizeInputMax(TagData aEnergyType, byte aSide) {
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
