package com.backend.clinica_odontologica.service;

import com.backend.clinica_odontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica_odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(int id);
    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto paciente);

    void eliminarPaciente(Long id);
