package supercoder79.gtweapons.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import supercoder79.gtweapons.entity.ModEntities;

public final class ProxyClient extends Abstract_Proxy {
	@Override
	public void onProxyAfterInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
		ModEntities.render(); //inits entity renders
	}

}
