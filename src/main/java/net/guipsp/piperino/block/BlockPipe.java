package net.guipsp.piperino.block;

import net.guipsp.piperino.reference.BlockInfo;
import net.guipsp.piperino.tileentity.TileEntityPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPipe extends BlockContainer {

    protected BlockPipe() {
        super(Material.iron);
        setBlockName(BlockInfo.PIPE_NAME);
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityPipe();
    }
}
