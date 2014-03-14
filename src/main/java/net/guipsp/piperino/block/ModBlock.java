package net.guipsp.piperino.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.guipsp.piperino.reference.BlockInfo;
import net.guipsp.piperino.tileentity.TileEntityPipe;

public class ModBlock {

    public static BlockPipe blockPipe;

    public static void init() {
        blockPipe = new BlockPipe();

        GameRegistry.registerBlock(blockPipe, BlockInfo.PIPE_NAME);
    }

    public static void initTileEntities() {
        GameRegistry.registerTileEntity(TileEntityPipe.class, BlockInfo.PIPE_TILE_ENTITY_NAME);
    }
}
