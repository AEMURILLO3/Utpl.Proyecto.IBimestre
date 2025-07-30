package com.aseguradora.cotizador.controller;

import com.aseguradora.cotizador.dto.CotizacionRequest;
import com.aseguradora.cotizador.dto.CotizacionResponse;
import com.aseguradora.cotizador.entity.Cotizacion;
import com.aseguradora.cotizador.repository.CotizacionRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionRestController {

    @Autowired
    private CotizacionRepository repository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Operation(summary = "Cotiza una póliza según los datos proporcionados")
    @PostMapping("/")
    public CotizacionResponse cotizarPoliza(@RequestBody CotizacionRequest request) {
        System.out.println("Cotizando póliza para tipo: " + request.getTipoPoliza());

        double primaBase = 100.0;
        double factorEdad = request.getEdadConductor() < 25 ? 1.5 : 1.0;
        double factorTipoPoliza = "completa".equalsIgnoreCase(request.getTipoPoliza()) ? 2.0 : 1.0;
        double prima = primaBase * factorEdad * factorTipoPoliza * (request.getValorVehiculo() / 10000);

        // Guardar en la base de datos
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setEdadConductor(request.getEdadConductor());
        cotizacion.setValorVehiculo(request.getValorVehiculo());
        cotizacion.setTipoPoliza(request.getTipoPoliza());
        cotizacion.setEmail(request.getEmail());
        cotizacion.setPrima(prima);
        repository.save(cotizacion);

        // Llamar a n8n
        String webhookUrl = "https://TU_INSTANCIA.n8n.cloud/webhook/cotizacion"; // Reemplaza con tu webhook real
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", request.getEmail());
        payload.put("monto", prima);
        payload.put("tipoPoliza", request.getTipoPoliza());
        restTemplate.postForEntity(webhookUrl, payload, String.class);

        return new CotizacionResponse(prima, "USD");
    }
}
