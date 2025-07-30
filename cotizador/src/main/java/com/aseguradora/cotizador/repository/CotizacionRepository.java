package com.aseguradora.cotizador.repository;

import com.aseguradora.cotizador.entity.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {
}