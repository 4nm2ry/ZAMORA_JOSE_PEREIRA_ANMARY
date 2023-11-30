package com.backend.clinica_odontologica.dto.salida.turno;


import com.backend.clinica_odontologica.entity.Odontologo;
import com.backend.clinica_odontologica.entity.Paciente;

import java.time.LocalDateTime;

public class TurnoSalidaDto {

    private Long id;
    private String odontologo;
    private String paciente;

    private LocalDateTime fechaYhora;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(Long id, String odontologo, String paciente, LocalDateTime fechaYhora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaYhora = fechaYhora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(String odontologo) {
        this.odontologo = odontologo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }
}
