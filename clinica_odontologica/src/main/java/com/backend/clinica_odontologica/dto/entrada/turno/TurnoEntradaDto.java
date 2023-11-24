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
    private Long pacienteId;

    @NotNull(message = "El odontologo no puede ser nulo")
    private Long odontologoId;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, Long pacienteId, Long odontologoId) {
        this.fechaYHora = fechaYHora;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }
}
