package net.guipsp.piperino.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.guipsp.piperino.client.renderer.tileentity.TileEntityPipeRenderer;
import net.guipsp.piperino.tileentity.TileEntityPipe;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderer() {
		System.out.println("Registering renderer");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipe.class, new TileEntityPipeRenderer());
	}
}
