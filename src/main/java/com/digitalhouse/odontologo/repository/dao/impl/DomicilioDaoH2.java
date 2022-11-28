package com.digitalhouse.odontologo.repository.dao.impl;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./database/myDataBase";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    public Connection getConection()throws Exception{
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("INSERT INTO domicilio VALUES(?,?,?,?,?);");
            p.setInt(1,domicilio.getId());
            p.setString(2,domicilio.getCalle());
            p.setInt(3,domicilio.getNumero());
            p.setString(4,domicilio.getLocalidad());
            p.setString(5,domicilio.getProvincia());
            p.execute();
            p.close();
            logger.info("El domicilio fue guardado exitosamente");
        } catch (Exception e){
            logger.error("No se pudo guardar el domicilio correctamente debido a: " + e);
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Domicilio domicilio = new Domicilio();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM domicilio WHERE id = ?;");
            p.setInt(1,id);
            ResultSet result = p.executeQuery();
            logger.info("Busqueda finalizada");
            while (result.next()){
                domicilio.setId(result.getInt("id"));
                domicilio.setCalle(result.getString("calle"));
                domicilio.setNumero(result.getInt("numero"));
                domicilio.setLocalidad(result.getString("localidad"));
                domicilio.setProvincia(result.getString("provincia"));
            }
            p.close();
            logger.info("Domicilio encontrado");
        }
        catch (Exception e){
            logger.error("No se pudo encontrar el domicilio debido a: " + e);
        }
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("DELETE FROM domicilio WHERE id = ?;");
            p.setInt(1, id);
            p.executeUpdate();
            p.close();
            logger.info("El domicilio fue eliminado");
        } catch (Exception e){
            logger.error("No se pudo eliminar el domicilio correctamente debido a : " + e);
        }
    }

    @Override
    public Domicilio modificar(Integer id, Object valorAModificar, String campoAModificar) {
        return null;
    }

    @Override
    public List<Domicilio> buscartodos() {
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM domicilio;");
            ResultSet result = p.executeQuery();
            while (result.next()) {
                Domicilio domicilio = new Domicilio();
                domicilio.setId(result.getInt("id"));
                domicilio.setCalle(result.getString("calle"));
                domicilio.setNumero(result.getInt("numero"));
                domicilio.setLocalidad(result.getString("localidad"));
                domicilio.setProvincia(result.getString("provincia"));
                domicilios.add(domicilio);
            }
            p.close();
            logger.info("Busqueda finalizada");
        } catch (Exception e){
            logger.error("No se pudieron mostrar todos los domicilios debido a: " + e);
        }
        return domicilios;
    }

    @Override
    public void crearTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "CREATE TABLE domicilio(id int primary key," +
                    "calle varchar(255)," +
                    "numero varchar (255)," +
                    "localidad varchar (255)," +
                    "provincia varchar (255));";
            s.execute(script);
            s.close();
            logger.info("Tabla domicilio creada");
        } catch (Exception e){
            logger.error("No se pudo crear la tabla domicilio correctamnte debido a: " + e);
        }
    }

    @Override
    public void eliminarTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "DROP TABLE domicilio;";
            s.execute(script);
            s.close();
            logger.info("Tabla domicilio borrada");
        } catch (Exception e){
            logger.error("No se pudo borrar la tabla domicilio correctamnte debido a: " + e);
        }
    }
}
