package supercoder79.gtweapons.entity.entities;

import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.UT;
import gregtech.blocks.BlockGlassClear;
import gregtech.blocks.BlockGlassGlow;
import net.minecraft.block.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.api.damage.DamageSourceBullet;
import supercoder79.gtweapons.api.data.GunData;

import java.util.List;

public class EntityBullet extends EntityThrowable {
    public float damage = 4;
    public int hurtTime = 20;
    public int material = 0;
    public int type = 0;
    public GunData data;

    public EntityBullet(World world) { // if you for some reason using this as an API, first: don't, second: DO NOT USE THIS CONSTRUCTOR it's for normal minecraft fuckery
        super(world);
    }

    public EntityBullet(World world, EntityLivingBase player) {
        super(world, player);
    }

    public EntityBullet(World world, EntityLivingBase player, GunData data, List<List<String>> perks) {
        super(world, player);
        this.data = data;
        this.hurtTime = data.fireRate;
        this.type = -1;
        float damageMultiplier = 1f;
        float spreadMultiplier = 1f;
        for (List<String> list : perks) {
            switch (list.get(0)) {
                case "c":
                    switch (list.get(1)) {
                        case "dm":
                            damageMultiplier+=0.15f;
                            break;
                        case "bs":
                            spreadMultiplier-=0.2f;
                            break;
                    }
                    break;
                case "u":
                    switch (list.get(1)) {
                        case "dm":
                            damageMultiplier+=0.2f;
                            break;
                        case "bs":
                            spreadMultiplier-=0.25f;
                            break;
                    }
                    break;
                case "r":
                    switch (list.get(1)) {
                        case "dm":
                            damageMultiplier+=0.25f;
                            break;
                        case "bs":
                            spreadMultiplier-=0.3f;
                            break;
                    }
                    break;
                case "s":
                    switch (list.get(1)) {
                        case "dm":
                            damageMultiplier+=0.35f;
                            break;
                        case "bs":
                            spreadMultiplier-=0.4f;
                            break;
                    }
                    break;
                case "l":
                    switch (list.get(1)) {
                        case "dm":
                            damageMultiplier+=0.45f;
                            break;
                        case "bs":
                            spreadMultiplier-=0.55f;
                            break;
                    }
                    break;
            }
        }
        if (spreadMultiplier < 0.2f) {
            spreadMultiplier = 0.2f;
        }


        this.damage = (int)Math.round((data.damage[0] + Math.random() * (data.damage[1] - data.damage[0]))*damageMultiplier);
        double min = 0 - data.bulletSpread; //calculate bullet spread
        double max = data.bulletSpread;
        this.motionX += (min + Math.random() * (max - min))*spreadMultiplier;
        this.motionZ += (min + Math.random() * (max - min))*spreadMultiplier;
        this.motionY += (min + Math.random() * (max - min))*spreadMultiplier;
    }

    public EntityBullet(World world, EntityLivingBase player, float damage, int hurtTime, int material, int type){
        super(world, player);
        this.damage = damage;
        this.hurtTime = hurtTime;
        this.material  = material;
        this.type = type;
        //setMaterial(material);
        double min = 0;
        double max = 0;
        if (type == 0) {
            min = -0.075;
            max = 0.075;
        }
        if (type == 1) {
            min = -0.125;
            max = 0.125;
        }
        if (type == 2) {
            //no spread with a sniper lol
        }
        if (type == 3) {
            min = -0.25;
            max = 0.25;
        }
        if (type == 4) {
            min = -0.075;
            max = 0.075;
        }
        if (type == 5) {
            min = -0.125;
            max = 0.125;
        }
        if (type == 6) {
            min = -0.5;
            max = 0.5;
        }
//        double random = min + Math.random() * (max - min);
        this.motionX += (min + Math.random() * (max - min));
        this.motionZ += (min + Math.random() * (max - min));
        this.motionY += (min + Math.random() * (max - min));


    }

    @Override
    protected void onImpact(MovingObjectPosition position) {
        if (position.entityHit != null) {
            if (position.entityHit instanceof EntityPlayer){
                if (ConfigHandler.PVPEnabled) {
                    if (((EntityPlayer) position.entityHit).getDisplayName().toLowerCase().startsWith("bear989Sr") && OreDictMaterial.MATERIAL_ARRAY[material] == MT.Ag) {
                        position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), 989 * 2); // note to self: never shoot bear with a silver bullet
                    }
                    if (((EntityPlayer) position.entityHit).getDisplayName().toLowerCase().startsWith("supercoder79") && OreDictMaterial.MATERIAL_ARRAY[material] == MT.Au) {
                        position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), 79 * 2); // note to self: don't shoot yourself
                    }
                    position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), damage);
                }
            }
            else {
                position.entityHit.attackEntityFrom(new DamageSourceBullet(this.getThrower()), damage);
                if (position.entityHit instanceof EntityZombie) {
//                    System.out.println(this.getThrower());
                    ((EntityZombie) position.entityHit).setAttackTarget(this.getThrower());

                }
            }
            position.entityHit.hurtResistantTime = hurtTime;
        }
        for (int i = 0; i < damage*4; ++i) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        if (!this.worldObj.isRemote) {
            if (position.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY) this.setDead();

            if (position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int x = position.blockX;
                int y = position.blockY;
                int z = position.blockZ;
                Block blockHit = this.worldObj.getBlock(x, y, z);
                if (blockHit instanceof BlockTallGrass || blockHit instanceof BlockDoublePlant || blockHit instanceof BlockFlower) {
                    //Do nothing
                }
                //TODO: Add the 5 or so other mod types of glass. There is so much freaking glass....
                else if (blockHit instanceof BlockGlass || blockHit instanceof BlockStainedGlass || blockHit instanceof BlockStainedGlassPane || blockHit instanceof BlockPane || blockHit instanceof BlockGlassClear || blockHit instanceof BlockGlassGlow) {
                    if (!ConfigHandler.BreakGlass) {
                        this.setDead();
                        return;
                    }
                    blockHit.removedByPlayer(this.worldObj, (EntityPlayer) this.getThrower(), x, y, z, true);

                    UT.Sounds.send(this.worldObj, "dig.glass", 0.5F, 0.4F / (CS.RNGSUS.nextFloat() * 0.4F + 0.8F), x, y, z);
                    if (this.type != 2) {
                        if (blockHit instanceof  BlockPane || blockHit instanceof BlockStainedGlassPane) {
                            this.addVelocity(-0.05, -0.05, -0.05);
                            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, x, y, z, OP.dustSmall.mat(MT.Glass, 1)));
                        } else {
                            this.addVelocity(-0.1, -0.1, -0.1); //causes bullet to go all whacko
                            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, x, y, z, OP.dustSmall.mat(MT.Glass, 2)));
                        }
                    }
                } else {
                    this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                    this.setDead();
                }
            }
        }
    }
    @Override
    public void onUpdate(){
        super.onUpdate();
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(12, (short)0);
    }
    public void setMaterial(int material){
        this.material = material;
        this.dataWatcher.addObject(12, this.material);
    }
    public int getMaterial(){
        short watcher = this.dataWatcher.getWatchableObjectShort(12);
        if (watcher != 0)
            return (int)watcher;
        else
        return this.material;
    }

    @Override
    protected float func_70182_d() { //Speed
        if (this.type == -1) return data.bulletSpeed;
        if (this.type == 0) return 3.0F;
        if (this.type == 1) return 4.5F;
        if (this.type == 2) return 9.0F;
        if (this.type == 3) return 3.0F;
        if (this.type == 4) return 4.0F;
        if (this.type == 5) return (float)(4.0F + Math.random() * (4.0F - 5.0F));
        return 3.0F;
    }
    @Override
    protected float getGravityVelocity() {
        return 0.01F;
    }

}
