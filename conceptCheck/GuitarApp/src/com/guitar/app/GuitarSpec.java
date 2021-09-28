package com.guitar.app;

public class GuitarSpec {

	private Type type;
	private Builder builder;
	private Wood wood;
	private String model;
	private int numStrings;
	private Wood backWood;
	private Wood topWood;

	public GuitarSpec(Type type, Builder builder, Wood wood, String model, int numStrings, Wood backWood,
			Wood topWood) {
		super();
		this.type = type;
		this.builder = builder;
		this.wood = wood;
		this.model = model;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public Type getType() {
		return type;
	}

	public Builder getBuilder() {
		return builder;
	}

	public Wood getWood() {
		return wood;
	}

	public String getModel() {
		return model;
	}

	public boolean matches(GuitarSpec otherSpec) {
		if (builder != otherSpec.builder)
			return false;
		if ((model != null) && (!model.equals("")) && (!model.equals(otherSpec.model)))
			return false;
		if (type != otherSpec.type)
			return false;
		if (numStrings != otherSpec.numStrings)
			return false;
		if (backWood != otherSpec.backWood)
			return false;
		if (topWood != otherSpec.topWood)
			return false;
		return true;
	}

}
