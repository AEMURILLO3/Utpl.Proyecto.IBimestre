package com.aseguradora.cotizador.entity;

import jakarta.persistence.*;

@Entity
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int edadConductor;
    private double valorVehiculo;
    private String tipoPoliza;
    private double prima;
    private String email;

    // Getters y Setters
    public Long getId() {
        return id;
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

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}