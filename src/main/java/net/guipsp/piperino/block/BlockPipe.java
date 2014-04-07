package net.guipsp.piperino.block;

import net.guipsp.piperino.reference.BlockInfo;
import net.guipsp.piperino.tileentity.TileEntityPipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
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

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isBlockNormalCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		tryTileUpdate(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		tryTileUpdate(world, x, y, z);
	}

	private void tryTileUpdate(World world, int x, int y, int z) {
		if (isServer(world)) {
			if (hasTileEntityPipe(world, x, y, z)) {
				updateBlockTileEntity(world, x, y, z);
			}
		}
	}

	private boolean isServer(World world) {
		return !world.isRemote;
	}

	private boolean hasTileEntityPipe(World world, int x, int y, int z) {
		return ((world.getTileEntity(x, y, z) != null) && (world.getTileEntity(x, y, z) instanceof TileEntityPipe));
	}

	private void updateBlockTileEntity(World world, int x, int y, int z) {
		TileEntityPipe tileEntityPipe = (TileEntityPipe) world.getTileEntity(x, y, z);
		tileEntityPipe.updatePipeArray();
	}
}
