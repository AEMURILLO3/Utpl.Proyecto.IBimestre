package com.aseguradora.cotizador.dto;

public class CotizacionRequest {
    private int edadConductor;
    private double valorVehiculo;
    private String tipoPoliza;
    private String email;

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

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}