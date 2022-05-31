package com.github.Pandarix.beautify.common.block;

import net.minecraft.core.Direction;

public class DarkOakPictureFrame extends OakPictureFrame {

	public DarkOakPictureFrame(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(FRAME_MOTIVE, 0).setValue(FACING, Direction.NORTH));
	}
	
}
