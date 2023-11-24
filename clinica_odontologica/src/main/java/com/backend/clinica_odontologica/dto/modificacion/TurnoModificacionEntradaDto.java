package com.backend.clinica_odontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoModificacionEntradaDto {

    @FutureOrPresent(message = "la fecha y hora no pueden ser anteriores a la actual")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaYHora;

    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
