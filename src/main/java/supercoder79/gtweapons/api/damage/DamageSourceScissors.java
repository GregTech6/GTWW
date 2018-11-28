package supercoder79.gtweapons.api.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;

public class DamageSourceScissors extends EntityDamageSource {
    public DamageSourceScissors(Entity entity)
    {
        super("death.scissors", entity);
//        this.damageSourceEntity = p_i1567_2_;
    }

    @Override
    public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
        return new ChatComponentText(p_151519_1_.getCommandSenderName() + " was brutally murdered by " + damageSourceEntity.getCommandSenderName() + " with a pair of scissors");
    }
}
