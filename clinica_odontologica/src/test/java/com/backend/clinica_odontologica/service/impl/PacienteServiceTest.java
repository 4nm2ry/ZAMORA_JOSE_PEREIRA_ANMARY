package com.backend.clinica_odontologica.service.impl;
import com.backend.clinica_odontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinica_odontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinica_odontologica.dto.salida.paciente.PacienteSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteYRetornarElId(){

        try{
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Luis", "Lopez", 236589, LocalDate.of(2023, 12, 24), new DomicilioEntradaDto("Armando", 5689, "RM", "Macul"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Luis", pacienteSalidaDto.getNombre());

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void deberiaDevolverUnaListaDePacientes(){
        try{
        List<PacienteSalidaDto> pacientesDto = pacienteService.listarPacientes();

        assertTrue(!pacientesDto.isEmpty());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void deberiaBuscarUnPacienteYRetornarElId(){
        try{
            PacienteSalidaDto pacienteSalidaDto = pacienteService.buscarPacientePorId(1L);
            assertNotNull(pacienteSalidaDto.getId());

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
