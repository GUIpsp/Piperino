package net.guipsp.piperino;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.guipsp.piperino.block.ModBlock;
import net.guipsp.piperino.proxy.CommonProxy;
import net.guipsp.piperino.reference.ModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class Piperino {

    public static final Logger logger = LogManager.getLogger(ModInfo.NAME);

    @Instance(ModInfo.ID)
    public static Piperino instance;

	@SidedProxy(modId = ModInfo.ID, clientSide = "net.guipsp.piperino.proxy.ClientProxy",
			serverSide = "net.guipsp.piperino.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlock.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlock.initTileEntities();

	    proxy.registerRenderer();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
