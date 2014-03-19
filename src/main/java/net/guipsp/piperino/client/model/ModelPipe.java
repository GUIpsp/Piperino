package net.guipsp.piperino.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.Tessellator;

import java.util.LinkedList;
import java.util.List;

public class ModelPipe extends ModelBase {

    public static class PipeRenderer extends ModelRenderer {
        public PipeRenderer(ModelBase par1ModelBase, int par2, int par3) {
            super(par1ModelBase, par2, par3);
        }

        public List<ModelPipeBox> modelPipeBoxList = new LinkedList<ModelPipeBox>();

        @SideOnly(Side.CLIENT)
        public void render(float par1, boolean[] connections) {
            for (ModelPipeBox modelPipeBox : modelPipeBoxList) {
                modelPipeBox.connections = connections;
            }
            super.render(par1);
        }

        @Override
        public void render(float par1) {
            render(par1, new boolean[6]);
        }

        public static class ModelPipeBox extends ModelBox {
            private PositionTextureVertex[] vertexPositions;
            private TexturedQuad[] quadList;
            public boolean[] connections;

            public ModelPipeBox(ModelRenderer par1ModelRenderer, int par2, int par3, float par4, float par5, float par6, int par7, int par8, int par9, float par10, boolean flip) {
                super(par1ModelRenderer, par2, par3, par4, par5, par6, par7, par8, par9, par10);
                this.vertexPositions = new PositionTextureVertex[8];
                this.quadList = new TexturedQuad[6];
                float f4 = par4 + (float) par7;
                float f5 = par5 + (float) par8;
                float f6 = par6 + (float) par9;
                par4 -= par10;
                par5 -= par10;
                par6 -= par10;
                f4 += par10;
                f5 += par10;
                f6 += par10;
                PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(par4, par5, par6, 0.0F, 0.0F);
                PositionTextureVertex positiontexturevertex = new PositionTextureVertex(f4, par5, par6, 0.0F, 8.0F);
                PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f4, f5, par6, 8.0F, 8.0F);
                PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(par4, f5, par6, 8.0F, 0.0F);
                PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(par4, par5, f6, 0.0F, 0.0F);
                PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(f4, par5, f6, 0.0F, 8.0F);
                PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(f4, f5, f6, 8.0F, 8.0F);
                PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(par4, f5, f6, 8.0F, 0.0F);
                this.vertexPositions[0] = positiontexturevertex7;
                this.vertexPositions[1] = positiontexturevertex;
                this.vertexPositions[2] = positiontexturevertex1;
                this.vertexPositions[3] = positiontexturevertex2;
                this.vertexPositions[4] = positiontexturevertex3;
                this.vertexPositions[5] = positiontexturevertex4;
                this.vertexPositions[6] = positiontexturevertex5;
                this.vertexPositions[7] = positiontexturevertex6;
                this.quadList[0] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex4, positiontexturevertex, positiontexturevertex1, positiontexturevertex5}, par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
                this.quadList[1] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex7, positiontexturevertex3, positiontexturevertex6, positiontexturevertex2}, par2, par3 + par9, par2 + par9, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
                this.quadList[2] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex4, positiontexturevertex3, positiontexturevertex7, positiontexturevertex}, par2 + par9, par3, par2 + par9 + par7, par3 + par9, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
                this.quadList[3] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex1, positiontexturevertex2, positiontexturevertex6, positiontexturevertex5}, par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par7, par3, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
                this.quadList[4] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex, positiontexturevertex7, positiontexturevertex2, positiontexturevertex1}, par2 + par9, par3 + par9, par2 + par9 + par7, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
                this.quadList[5] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex3, positiontexturevertex4, positiontexturevertex5, positiontexturevertex6}, par2 + par9 + par7 + par9, par3 + par9, par2 + par9 + par7 + par9 + par7, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);

                if (flip) {
                    for (int j1 = 0; j1 < this.quadList.length; ++j1) {
                        this.quadList[j1].flipFace();
                    }
                }
            }

            @Override
            public void render(Tessellator par1Tessellator, float par2) {
                for (int i = 0; i < this.quadList.length; ++i) {
                    if (!connections[i]) {
                        this.quadList[i].draw(par1Tessellator, par2);
                    }
                }
            }
        }
    }

    public PipeRenderer base;

    public ModelPipe() {
        base = new PipeRenderer(this, 0, 0);

        base.setTextureSize(6, 6);
        {
            PipeRenderer.ModelPipeBox modelBox = new PipeRenderer.ModelPipeBox(base, 0, 0, 5, 5, 5, 6, 6, 6, 0f, false);
            base.modelPipeBoxList.add(modelBox);
            base.cubeList.add(modelBox);
        }
        {
            PipeRenderer.ModelPipeBox modelBox = new PipeRenderer.ModelPipeBox(base, 0, 0, 5, 5, 5, 6, 6, 6, 0f, true);
            base.modelPipeBoxList.add(modelBox);
            base.cubeList.add(modelBox);
        }
    }

}
