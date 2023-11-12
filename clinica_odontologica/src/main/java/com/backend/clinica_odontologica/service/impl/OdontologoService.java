package com.backend.clinica_odontologica.service.impl;

public class OdontologoService {
    private IDao <Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }
    public Odontologo buscarOdontologoPorId(int id) {
        return odontologoIDao.buscarPorId(id);
    }
}
