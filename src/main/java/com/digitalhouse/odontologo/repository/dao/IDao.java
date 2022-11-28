package com.digitalhouse.odontologo.repository.dao;

import java.util.List;

public interface IDao<T> {
    public T guardar(T t);
    public T buscar(Integer id);
    public void eliminar(Integer id);
    public T modificar(Integer id, Object valorAModificar, String campoAModificar);
    public List<T> buscartodos();
    public void crearTabla();
    public void eliminarTabla();
}
