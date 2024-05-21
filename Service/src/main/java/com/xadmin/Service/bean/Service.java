package com.xadmin.Service.bean;

public class Service {
    protected int serviceID;
    protected String serviceName;
    protected String serviceType;
    protected String serviceDescription;
    protected String serviceAvailability;
    protected String servicePrice;
    
	public Service(int serviceID, String serviceName, String serviceType, String serviceDescription,
			String serviceAvailability, String servicePrice) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.serviceDescription = serviceDescription;
		this.serviceAvailability = serviceAvailability;
		this.servicePrice = servicePrice;
	}

	public Service(String serviceName, String serviceType, String serviceDescription, String serviceAvailability,
			String servicePrice) {
		super();
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.serviceDescription = serviceDescription;
		this.serviceAvailability = serviceAvailability;
		this.servicePrice = servicePrice;
	}

	public int getServiceID() {
		return serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public String getServiceAvailability() {
		return serviceAvailability;
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public void setServiceAvailability(String serviceAvailability) {
		this.serviceAvailability = serviceAvailability;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}  
}
