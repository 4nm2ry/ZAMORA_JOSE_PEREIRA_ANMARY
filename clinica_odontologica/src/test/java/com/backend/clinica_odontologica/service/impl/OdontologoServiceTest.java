package com.backend.clinica_odontologica.service.impl;

import com.backend.clinica_odontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;


    @Order(1)
    @Test
    void deberiaRegistrarUnOdontologoYRetornarElId() {

        try {
            OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("1111111", "Juan", "Ramirez");

            OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

            assertNotNull(odontologoSalidaDto.getId());
            assertEquals("Juan", odontologoSalidaDto.getNombre());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Order(2)
    @Test
    void deberiaDevolverUnaListaDeOdontologos() {

        try{
        List<OdontologoSalidaDto> odontologosDto = odontologoService.listarOdontologos();

        assertFalse(odontologosDto.isEmpty());

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
