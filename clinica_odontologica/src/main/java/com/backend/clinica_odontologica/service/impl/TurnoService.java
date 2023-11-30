package com.backend.clinica_odontologica.service.impl;

import com.backend.clinica_odontologica.Repository.TurnoRepository;
import com.backend.clinica_odontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinica_odontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinica_odontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinica_odontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinica_odontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinica_odontologica.entity.Odontologo;
import com.backend.clinica_odontologica.entity.Paciente;
import com.backend.clinica_odontologica.entity.Turno;
import com.backend.clinica_odontologica.exceptions.BadRequestException;
import com.backend.clinica_odontologica.service.ITurnoService;
import com.backend.clinica_odontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        configureMapping();

    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        return null;
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException {

        OdontologoSalidaDto odontologoBuscado = odontologoService.buscarOdontologoPorId(turno.getOdontologo());
        PacienteSalidaDto pacienteBuscado = pacienteService.buscarPacientePorId(turno.getPaciente());
        if(odontologoBuscado == null){
            throw new BadRequestException("odontologo no existe");
        }
        if(pacienteBuscado == null){
            throw new BadRequestException("paciente es nulo");
        }
        LOGGER.info("TurnoEntradaDto: " + JsonPrinter.toString(turno));
        Turno turnoEntidad =  modelMapper.map(turno,Turno.class);

        Turno turnoAPersistir= turnoRepository.save(turnoEntidad);

        TurnoSalidaDto turnoSalidaDto= modelMapper.map(turnoAPersistir,TurnoSalidaDto.class);
        turnoSalidaDto.setPaciente(pacienteBuscado.getNombre());
        turnoSalidaDto.setOdontologo(odontologoBuscado.getNombre());

        LOGGER.info("TurnoSalidaDto: " + JsonPrinter.toString(turnoSalidaDto));
        return turnoSalidaDto;

    }


    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarTurno(Long id) {

    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto) {
        return null;
    }

    private void configureMapping() {
        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class)
                .addMappings(mapper -> {
                    mapper.map(TurnoEntradaDto::getPaciente, Turno::setPaciente);
                    mapper.map(TurnoEntradaDto::getOdontologo, Turno::setOdontologo);
                });
    }
}

