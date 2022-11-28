package com.digitalhouse.odontologo.repository.dao.impl;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

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
    public Odontologo guardar(Odontologo odontologo) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("INSERT INTO odontologo VALUES(?,?,?,?);");
            p.setInt(1,odontologo.getId());
            p.setString(4,odontologo.getMatricula());
            p.execute();
            p.close();
            logger.info("El odontologo fue guardado exitosamente");
        } catch (Exception e){
            logger.error("No se pudo guardar correctamente debido a: " + e);
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Odontologo odontologo = new Odontologo();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM odontologo WHERE id = ?;");
            p.setInt(1,id);
            ResultSet result = p.executeQuery();
            logger.info("Busqueda finalizada");
            while (result.next()){
                odontologo.setId(result.getInt("id"));
                odontologo.setMatricula(result.getString("matricula"));
            }
            p.close();
        }
        catch (Exception e){
            logger.error("No se pudo encontrar debido a: " + e);
        }
        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("DELETE FROM odontologo WHERE id = ?;");
            p.setInt(1, id);
            p.executeUpdate();
            p.close();
            logger.info("El odontologo fue eliminado");
        } catch (Exception e){
            logger.error("No se pudo eliminar correctamente debido a : " + e);
        }
    }

    @Override
    public Odontologo modificar(Integer id, Object valorAModificar, String campoAModificar) {
        return null;
    }

    @Override
    public List<Odontologo> buscartodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM odontologo;");
            ResultSet result = p.executeQuery();
            while (result.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(result.getInt("id"));
                odontologos.add(odontologo);
            }
            p.close();
            logger.info("Busqueda finalizada");
        } catch (Exception e){
            logger.error("No se pudieron mostrar todos lo odontologos debido a: " + e);
        }
        return odontologos;
    }

    @Override
    public void crearTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "CREATE TABLE odontologo(id int primary key," +
                    "personaId int," +
                    "usuarioId int," +
                    "matricula varchar (255));";
            s.execute(script);
            s.close();
            logger.info("Tabla odontologo creada");
        } catch (Exception e){
            logger.error("no se pudo crear la tabla correctamnte debido a: " + e);
        }
    }

    @Override
    public void eliminarTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "DROP TABLE IF EXISTS odontologo;";
            s.execute(script);
            s.close();
            logger.info("Tabla odontologo borrada");
        } catch (Exception e){
            logger.error("no se pudo borrar la tabla correctamnte debido a: " + e);
        }
    }
}
