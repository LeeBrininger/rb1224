package com.rental.toolRental;

public class Tool {
	
	public Tool(String code, ToolType type, String brand) {
		super();
		this.code = code;
		this.type = type;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Tool [code=" + code + ", type=" + type.toString() + ", brand=" + brand + "]";
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
