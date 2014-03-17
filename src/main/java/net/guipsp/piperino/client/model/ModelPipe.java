package net.guipsp.piperino.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPipe extends ModelBase {
	public ModelRenderer base;

	public ModelPipe() {
		base = new ModelRenderer(this, 0, 0);

		base.setTextureSize(8, 8);
		base.addBox(0.5f, 0.5f, 0.5f, 1, 1, 1, 0f);
	}

}
