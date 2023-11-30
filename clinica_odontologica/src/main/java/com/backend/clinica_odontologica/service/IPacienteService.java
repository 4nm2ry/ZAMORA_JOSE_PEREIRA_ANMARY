package com.backend.clinica_odontologica.service;

import com.backend.clinica_odontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica_odontologica.entity.Paciente;
import com.backend.clinica_odontologica.exceptions.BadRequestException;
import com.backend.clinica_odontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) throws BadRequestException;

    List<PacienteSalidaDto> listarPacientes() throws ResourceNotFoundException;

    PacienteSalidaDto buscarPacientePorId(Long id) throws BadRequestException;

    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto paciente) throws BadRequestException;

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

}
