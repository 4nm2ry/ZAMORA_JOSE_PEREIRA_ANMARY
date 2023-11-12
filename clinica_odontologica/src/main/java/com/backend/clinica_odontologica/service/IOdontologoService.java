package com.backend.clinica_odontologica.service;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();
    OdontologoSalidaDto buscarOdontologoPorId(int id);
    Odontologo actualizarOdontologo(Odontologo odontologo);

}
