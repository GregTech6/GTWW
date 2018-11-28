package supercoder79.gtweapons.entity.entities;

import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.api.damage.DamageSourceBullet;
import supercoder79.gtweapons.api.data.GunData;

public class EntityBulletUnlockable extends EntityBullet {
    public GunData data;

    public EntityBulletUnlockable(World world) {
        super(world);
    }

    public EntityBulletUnlockable(World world, EntityLivingBase player, GunData data) {
        super(world, player);
        this.data = data;

        double min = 0 - data.bulletSpread; //calculate bullet spread
        double max = data.bulletSpread;
        System.out.println(min + " / " + max);
        this.motionX += (min + Math.random() * (max - min));
        this.motionZ += (min + Math.random() * (max - min));
        this.motionY += (min + Math.random() * (max - min));
    }

    @Override
    protected void onImpact(MovingObjectPosition position) {
        if (data != null) {
            int damage = (int)Math.round(data.damage[0] + Math.random() * (data.damage[1] - data.damage[0]));
            if (position.entityHit != null) {
                if (position.entityHit instanceof EntityPlayer){
                    if (ConfigHandler.PVPEnabled) {
//                    if (((EntityPlayer) position.entityHit).getDisplayName().toLowerCase().startsWith("bear989Sr") && OreDictMaterial.MATERIAL_ARRAY[material] == MT.Ag) {
//                        position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), 989 * 2); // note to self: never shoot bear with a silver bullet
//                    }
//                    if (((EntityPlayer) position.entityHit).getDisplayName().toLowerCase().startsWith("supercoder79") && OreDictMaterial.MATERIAL_ARRAY[material] == MT.Au) {
//                        position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), 79 * 2); // note to self: don't shoot yourself
//                    }
                        position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), damage);
                    }
                }
                else {
                    position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), damage);
                    if (position.entityHit instanceof EntityZombie) {
                        ((EntityZombie) position.entityHit).setAttackTarget(this.getThrower());

                    }
                }
                position.entityHit.hurtResistantTime = data.fireRate;
            }
        }
        this.setDead();
    }

    @Override
    protected float func_70182_d() { //Speed
//        return this.data.
        return 7.5f;
    }
    @Override
    protected float getGravityVelocity() {
        return 0.01F;
    }
}
