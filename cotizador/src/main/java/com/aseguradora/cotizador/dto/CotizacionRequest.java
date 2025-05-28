package com.aseguradora.cotizador.dto;

public class CotizacionRequest {
    private String tipoPoliza;
    private int edadConductor;
    private double valorVehiculo;

    public CotizacionRequest() {}

    public CotizacionRequest(String tipoPoliza, int edadConductor, double valorVehiculo) {
        this.tipoPoliza = tipoPoliza;
        this.edadConductor = edadConductor;
        this.valorVehiculo = valorVehiculo;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public int getEdadConductor() {
        return edadConductor;
    }

    public void setEdadConductor(int edadConductor) {
        this.edadConductor = edadConductor;
    }

    public double getValorVehiculo() {
        return valorVehiculo;
    }

    public void setValorVehiculo(double valorVehiculo) {
        this.valorVehiculo = valorVehiculo;
    }
}
