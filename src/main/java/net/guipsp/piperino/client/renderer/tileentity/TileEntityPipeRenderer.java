package net.guipsp.piperino.client.renderer.tileentity;

import net.guipsp.piperino.client.model.ModelPipe;
import net.guipsp.piperino.reference.ModInfo;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

//TODO: Empty Renderer
public class TileEntityPipeRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(ModInfo.ID, "textures/blocks/pipe.png");
    static ModelPipe modelPipe = new ModelPipe();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        bindTexture(texture);

        modelPipe.base.render(0.0625f);

        GL11.glPopMatrix();
    }
}
