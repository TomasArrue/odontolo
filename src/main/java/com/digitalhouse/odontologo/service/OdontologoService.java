package com.digitalhouse.odontologo.service;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Odontologo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoService {
    private IDao<Odontologo> odontologoDao;

    public Odontologo cargar(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }

    public Odontologo buscar(Integer id) {
        return odontologoDao.buscar(id);
    }

    public void eliminar(Integer id) {
        odontologoDao.eliminar(id);
    }

    public List<Odontologo> buscartodos() {
        return odontologoDao.buscartodos();
    }

    public  void borrarTabla(){
        odontologoDao.eliminarTabla();
    }

    public  void crearTabla(){
        odontologoDao.crearTabla();
    }

}
