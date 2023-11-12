package com.backend.clinica_odontologica.service;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(int id);
    Paciente actualizarPaciente(Paciente paciente);
}
