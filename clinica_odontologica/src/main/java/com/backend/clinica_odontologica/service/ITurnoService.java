package com.backend.clinica_odontologica.service;

import com.backend.clinica_odontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinica_odontologica.exceptions.BadRequestException;

import java.util.List;

public interface ITurnoService {

    List<TurnoSalidaDto> listarTurnos();


    TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException;

    TurnoSalidaDto buscarTurnoPorId(Long id);

    void eliminarTurno(Long id);

    TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto);
}
