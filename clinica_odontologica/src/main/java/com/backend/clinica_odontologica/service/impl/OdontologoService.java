package com.backend.clinica_odontologica.service.impl;

import com.backend.clinica_odontologica.Repository.OdontologoRepository;
import com.backend.clinica_odontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica_odontologica.entity.Odontologo;
import com.backend.clinica_odontologica.exceptions.BadRequestException;
import com.backend.clinica_odontologica.exceptions.ResourceNotFoundException;
import com.backend.clinica_odontologica.service.IOdontologoService;
import com.backend.clinica_odontologica.utils.JsonPrinter;
import net.bytebuddy.asm.Advice;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {

    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);

    private OdontologoRepository odontologoRepository;

    private ModelMapper modelMapper;

    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) throws BadRequestException{

        LOGGER.info("OdontologoEntradaDto: " + JsonPrinter.toString(odontologo));
        Odontologo odontologoEntidad = modelMapper.map(odontologo, Odontologo.class);

        Odontologo odontologoAPersistir = odontologoRepository.save(odontologoEntidad);
        //transformamos la entidad obtenida en salidaDto
        if (odontologoAPersistir != null) {
            OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoAPersistir, OdontologoSalidaDto.class);
            LOGGER.info("OdontologoSalidaDto: " + JsonPrinter.toString(odontologoSalidaDto));
            return odontologoSalidaDto;
        }
        else{ LOGGER.error("No se ha registrado el odontologo ");
            throw new BadRequestException("No se ha registrado el odontologo");}


    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() throws ResourceNotFoundException {

        List<OdontologoSalidaDto> odontologosSalidaDto = odontologoRepository.findAll()
                .stream()
                .map(odontologo -> modelMapper.map(odontologo, OdontologoSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled())
            if(odontologosSalidaDto.size() == 0) {
                throw new ResourceNotFoundException("No existen odontologos");
            }
        LOGGER.info("Listado de todos los odontologos: {}", JsonPrinter.toString(odontologosSalidaDto));
        return odontologosSalidaDto;

    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) throws BadRequestException {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoSalidaDto odontologoEncontrado = null;

        if (odontologoBuscado != null) {
            odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
            LOGGER.info("Odontologo encontrado: {}", JsonPrinter.toString(odontologoEncontrado));
            return odontologoEncontrado;
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");
        throw new BadRequestException("No se ha encontrado el odontologo con id " + id);

    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologo) throws ResourceNotFoundException {
        Odontologo odontologoRecibido = modelMapper.map(odontologo, Odontologo.class);
        Odontologo odontologoAActualizar = odontologoRepository.findById(odontologoRecibido.getId()).orElse(null);

        OdontologoSalidaDto odontologoSalidaDto = null;

        if (odontologoAActualizar != null) {
            odontologoAActualizar = odontologoRecibido;
            odontologoRepository.save(odontologoAActualizar);

            odontologoSalidaDto = modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);
            LOGGER.warn("Odontologo actualizado: {}", JsonPrinter.toString(odontologoSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el odontologo porque no se encuentra en nuestra base de datos");
            throw new ResourceNotFoundException("No fue posible actualizar el odontologo porque no se encuentra en la base de datos");
        }


        return odontologoSalidaDto;
    }

    @Override
    public void eliminarOdontologo(Long id) throws BadRequestException {
        if (odontologoRepository.findById(id).orElse(null) != null) {
            odontologoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el odontologo con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el odontologo con id {}", id);
            throw new BadRequestException("No se ha encontrado el odontologo con id" + id);
        }


    }


    private void configureMapping() {
        modelMapper.typeMap(OdontologoEntradaDto.class, Odontologo.class);
        modelMapper.typeMap(Odontologo.class, OdontologoSalidaDto.class);
        modelMapper.typeMap(OdontologoModificacionEntradaDto.class, Odontologo.class);
    }
}