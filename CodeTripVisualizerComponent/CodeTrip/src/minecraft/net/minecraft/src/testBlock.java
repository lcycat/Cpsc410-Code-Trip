package net.minecraft.src;

public class testBlock extends Block {

	protected testBlock(int id, int textureIndex, Material mat) {
		 super(id, textureIndex, mat);
         super.setHardness(3.0f);
         super.setBlockName("oreDiracium");
         super.setStepSound(soundStoneFootstep);
	}

}
