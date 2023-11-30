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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaYHora;

    @NotNull(message = "El paciente no puede ser nulo")
    private Long paciente;

    @NotNull(message = "El odontologo no puede ser nulo")
    private Long odontologo;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, Long paciente, Long odontologo) {
        this.fechaYHora = fechaYHora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Long odontologo) {
        this.odontologo = odontologo;
    }
}
