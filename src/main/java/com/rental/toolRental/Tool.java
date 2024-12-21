package com.rental.toolRental;

public class Tool {
	
	/**
	 * Constructor for the Tool class.
	 * @param code Unique identifier for the tool.
	 * @param type What type of tool it is, this is a ToolType object.
	 * @param brand What brand the tool is.
	 */
	public Tool(String code, ToolType type, String brand) {
		super();
		this.code = code;
		this.type = type;
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ToolType getType() {
		return type;
	}

	public void setType(ToolType type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	private String code;
	
	private ToolType type;

	private String brand;
}
