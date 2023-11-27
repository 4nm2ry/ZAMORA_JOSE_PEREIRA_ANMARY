package com.backend.clinica_odontologica.controller;


import com.backend.clinica_odontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica_odontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinica_odontologica.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "http://localhost:63342")
public class TurnoController {

    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@RequestBody @Valid TurnoEntradaDto turno) {
        return new ResponseEntity<>(turnoService.registrarTurno(turno), HttpStatus.CREATED);
    }

}
