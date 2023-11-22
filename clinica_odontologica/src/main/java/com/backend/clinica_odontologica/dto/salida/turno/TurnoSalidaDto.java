package com.backend.clinica_odontologica.dto.salida.turno;

import com.backend.clinica_odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica_odontologica.dto.salida.paciente.PacienteSalidaDto;

public class TurnoSalidaDto {

    private Long id;
    private OdontologoSalidaDto odontologoSalidaDto;
    private PacienteSalidaDto pacienteSalidaDto;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(Long id, OdontologoSalidaDto odontologoSalidaDto, PacienteSalidaDto pacienteSalidaDto) {
        this.id = id;
        this.odontologoSalidaDto = odontologoSalidaDto;
        this.pacienteSalidaDto = pacienteSalidaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OdontologoSalidaDto getOdontologoSalidaDto() {
        return odontologoSalidaDto;
    }

    public void setOdontologoSalidaDto(OdontologoSalidaDto odontologoSalidaDto) {
        this.odontologoSalidaDto = odontologoSalidaDto;
    }

    public PacienteSalidaDto getPacienteSalidaDto() {
        return pacienteSalidaDto;
    }

    public void setPacienteSalidaDto(PacienteSalidaDto pacienteSalidaDto) {
        this.pacienteSalidaDto = pacienteSalidaDto;
    }
}
