package model.repositories;

import Services.ServiceGeneral;

public class ServiceRepository {
	public ServiceGeneral serviceMetodologias = new ServiceGeneral("./resources/metodologias.JSON");
	
	public ServiceGeneral serviceEmpresas = new ServiceGeneral("./resources/cuentas.json");
	
	public ServiceGeneral serviceIndicadores = new ServiceGeneral("./resources/indicadores3.json");

	public ServiceGeneral getServiceMetodologias() {
		return serviceMetodologias;
	}

	public void setServiceMetodologias(ServiceGeneral serviceMetodologias) {
		this.serviceMetodologias = serviceMetodologias;
	}

	public ServiceGeneral getServiceEmpresas() {
		return serviceEmpresas;
	}

	public void setServiceEmpresas(ServiceGeneral serviceEmpresas) {
		this.serviceEmpresas = serviceEmpresas;
	}

	public ServiceGeneral getServiceIndicadores() {
		return serviceIndicadores;
	}

	public void setServiceIndicadores(ServiceGeneral serviceIndicadores) {
		this.serviceIndicadores = serviceIndicadores;
	}
}
