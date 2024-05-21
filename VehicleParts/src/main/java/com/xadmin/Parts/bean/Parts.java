package com.xadmin.Parts.bean;

public class Parts {
    protected int partID;
    protected String partName;
    protected String partdescription;
    protected String category;
    protected String supplier;
    protected String quantity;
    protected String unitPrice;
    
	public Parts(int partID,String partName, String partdescription, String category, String supplier, String quantity,
			String unitPrice) {
		super();
		this.partID = partID;
		this.partName=partName;
		this.partdescription = partdescription;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Parts(String partName,String partdescription, String category, String supplier, String quantity, String unitPrice) {
		super();
		this.partName=partName;
		this.partdescription = partdescription;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int getPartID() {
		return partID;
	}

	public String getPartName() {
		return partName;
	}

	public String getPartdescription() {
		return partdescription;
	}

	public String getCategory() {
		return category;
	}

	public String getSupplier() {
		return supplier;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setPartID(int partID) {
		this.partID = partID;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public void setPartdescription(String partdescription) {
		this.partdescription = partdescription;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	
	
    
    
    
    
}
    
    
