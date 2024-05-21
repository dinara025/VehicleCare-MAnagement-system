package com.xadmin.FuelDetailsManage.bean;

public class Fuel {
    protected int id;
    protected String fuelType;
    protected String date;
    protected String fuelQuantity;
    protected String tankIdentification;
    protected String unitPrice;
    protected String totalCost;
    protected String supplier;
    protected String employeeID;
    protected String note;
    
    public Fuel() {}
	public Fuel(int id, String fuelType, String date, String fuelQuantity, String tankIdentification, String unitPrice,
			String totalCost, String supplier, String employeeID, String note) {
		super();
		this.id=id;
		this.fuelType = fuelType;
		this.date = date;
		this.fuelQuantity = fuelQuantity;
		this.tankIdentification = tankIdentification;
		this.unitPrice = unitPrice;
		this.totalCost = totalCost;
		this.supplier = supplier;
		this.employeeID = employeeID;
		this.note = note;
	}
	 public Fuel(String fuelType, String date, String fuelQuantity, String tankIdentification, String unitPrice,
				String totalCost, String supplier, String employeeID, String note) {
			super();
			this.fuelType = fuelType;
			this.date = date;
			this.fuelQuantity = fuelQuantity;
			this.tankIdentification = tankIdentification;
			this.unitPrice = unitPrice;
			this.totalCost = totalCost;
			this.supplier = supplier;
			this.employeeID = employeeID;
			this.note = note;
		}
	
	
	public int getid() {
		return id;
	}
	public String getFuelType() {
		return fuelType;
	}
	public String getDate() {
		return date;
	}
	public String getFuelQuantity() {
		return fuelQuantity;
	}
	public String getTankIdentification() {
		return tankIdentification;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public String getSupplier() {
		return supplier;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String getNote() {
		return note;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setFuelQuantity(String fuelQuantity) {
		this.fuelQuantity = fuelQuantity;
	}
	public void setTankIdentification(String tankIdentification) {
		this.tankIdentification = tankIdentification;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
}
