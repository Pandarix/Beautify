package com.github.Pandarix.beautify.common.block;

import net.minecraft.util.StringRepresentable;

public enum PotFlower implements StringRepresentable {
	dirt("dirt"),
	rose("rose_bush"),
	lilac("lilac");

	private final String name;

	private PotFlower(String pName) {
		this.name = pName;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}