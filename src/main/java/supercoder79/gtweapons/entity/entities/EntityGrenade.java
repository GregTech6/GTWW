package supercoder79.gtweapons.entity.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
    public EntityGrenade(World world) { // if you for some reason using this as an API, first: don't, second: DO NOT USE THIS CONSTRUCTOR it's for normal minecraft fuckery
        super(world);
    }
    public int type = 0;

    public EntityGrenade(World world, EntityPlayer player, int type) {
        super(world, player);
        this.type = type;
    }
    @Override
    protected void onImpact(MovingObjectPosition pos) {
        /*
        * Last two booleans:
        * 1st one is `isFlamin` places fire down
        * 2nd one is `isSmoking` which breaks blocks
        * */
        switch (this.type) {
            case 0:
                this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 4F, false, false);
                break;
            case 1:
                this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 4F, false, false);
                this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 2.5F, false, true);
                break;
            case 2:
                this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 5F, true, false);
                break;
        }


        setDead();
    }
    @Override
    public void onUpdate(){
        super.onUpdate();
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }
    @Override
    protected float func_70182_d() { //Speed
        return 2.0F;
    }
    @Override
    protected float getGravityVelocity() {
        return 0.15F;
    }
}
