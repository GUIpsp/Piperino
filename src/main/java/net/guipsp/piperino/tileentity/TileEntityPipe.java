package net.guipsp.piperino.tileentity;

import net.guipsp.piperino.block.BlockPipe;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPipe extends TileEntity {
	private boolean[] nearbyPipes;

	public TileEntityPipe() {
		nearbyPipes = new boolean[6];
	}

	public void updatePipeArray() {
		for (int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++) {
			checkDirection(i);
		}
	}

	private void checkDirection(int i) {
		int[] coordinates = addOffset(xCoord, yCoord, zCoord, ForgeDirection.VALID_DIRECTIONS[i]);

		Block block = worldObj.getBlock(coordinates[0], coordinates[1], coordinates[2]);
		nearbyPipes[i] = isPipe(block);
	}

	private int[] addOffset(int x, int y, int z, ForgeDirection direction) {
		return new int[]{x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ};
	}

	private boolean isPipe(Block block) {
		return (block instanceof BlockPipe);
	}
}
