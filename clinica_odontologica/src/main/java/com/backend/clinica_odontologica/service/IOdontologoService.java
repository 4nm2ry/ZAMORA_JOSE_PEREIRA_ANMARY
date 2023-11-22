package com.backend.clinica_odontologica.service;

import com.backend.clinica_odontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica_odontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();
    OdontologoSalidaDto buscarOdontologoPorId(Long id);
    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto);

    void eliminarOdontologo(Long id);

}
