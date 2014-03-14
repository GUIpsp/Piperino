package net.guipsp.piperino.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.guipsp.piperino.reference.BlockInfo;

public class ModBlock {

    public static BlockPipe blockPipe;

    public static void init() {
        blockPipe = new BlockPipe();

        GameRegistry.registerBlock(blockPipe, BlockInfo.PIPE_NAME);
    }
}
