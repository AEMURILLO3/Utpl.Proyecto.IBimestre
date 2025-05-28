package com.aseguradora.cotizador.controller;

import com.aseguradora.cotizador.dto.CotizacionRequest;
import com.aseguradora.cotizador.dto.CotizacionResponse;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionRestController {

    @Operation(summary = "Cotiza una póliza según los datos proporcionados")
    @PostMapping("/")
    public CotizacionResponse cotizarPoliza(@RequestBody CotizacionRequest request) {
        System.out.println("Cotizando póliza para tipo: " + request.getTipoPoliza());

        // Ejemplo simple de cálculo
        double primaBase = 100.0;
        double factorEdad = request.getEdadConductor() < 25 ? 1.5 : 1.0;
        double factorTipoPoliza = "completa".equalsIgnoreCase(request.getTipoPoliza()) ? 2.0 : 1.0;
        double prima = primaBase * factorEdad * factorTipoPoliza * (request.getValorVehiculo() / 10000);

        return new CotizacionResponse(prima, "USD");
    }
}
