package com.backend.clinica_odontologica.dto.entrada.turno;

import com.backend.clinica_odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto {

    @FutureOrPresent(message = "la fecha y hora no pueden ser anteriores a la actual")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaYHora;

    @NotNull(message = "El paciente no puede ser nulo")
    @Valid
    private PacienteModificacionEntradaDto pacienteModificacionEntradaDto;

    @NotNull(message = "El odontologo no puede ser nulo")
    @Valid
    private OdontologoModificacionEntradaDto odontologoModificacionEntradaDto;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, PacienteModificacionEntradaDto pacienteModificacionEntradaDto, OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) {
        this.fechaYHora = fechaYHora;
        this.pacienteModificacionEntradaDto = pacienteModificacionEntradaDto;
        this.odontologoModificacionEntradaDto = odontologoModificacionEntradaDto;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public PacienteModificacionEntradaDto getPacienteModificacionEntradaDto() {
        return pacienteModificacionEntradaDto;
    }

    public void setPacienteModificacionEntradaDto(PacienteModificacionEntradaDto pacienteModificacionEntradaDto) {
        this.pacienteModificacionEntradaDto = pacienteModificacionEntradaDto;
    }

    public OdontologoModificacionEntradaDto getOdontologoModificacionEntradaDto() {
        return odontologoModificacionEntradaDto;
    }

    public void setOdontologoModificacionEntradaDto(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) {
        this.odontologoModificacionEntradaDto = odontologoModificacionEntradaDto;
    }
}
