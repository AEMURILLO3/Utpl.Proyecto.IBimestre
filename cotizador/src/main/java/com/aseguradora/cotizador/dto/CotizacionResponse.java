package com.aseguradora.cotizador.dto;

public class CotizacionResponse {
    private double prima;
    private String moneda;

    public CotizacionResponse() {}

    public CotizacionResponse(double prima, String moneda) {
        this.prima = prima;
        this.moneda = moneda;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
