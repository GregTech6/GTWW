package supercoder79.gtweapons.api.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;

public class DamageSourceBullet extends EntityDamageSource {

	public DamageSourceBullet(Entity entity) {
		super("death.bullet", entity);
//        this.damageSourceEntity = p_i1567_2_;
		setProjectile();
	}

	@Override
	public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
		return new ChatComponentText(p_151519_1_.getCommandSenderName() + " was shot dead by " + damageSourceEntity.getCommandSenderName());
	}
}
