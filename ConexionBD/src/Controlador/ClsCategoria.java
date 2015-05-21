/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ConexionBD.con;
import static Controlador.ConexionBD.st;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno05
 */
public class ClsCategoria {
ConexionBD cx;
String sql="";
 //Connection con;
    public ClsCategoria() {
        cx=new ConexionBD();
    try {
        cx.AbrirConexion();
    } catch (SQLException ex) {
        Logger.getLogger(ClsCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void reporteCategoria() throws SQLException{
        String sql="SELECT id_categoria , descripcion FROM categoria" ;
       // PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs= st.executeQuery(sql);
        if(rs!=null){
        while(rs.next()){
            System.out.println(rs.getString("id_categoria")+ " "+rs.getString("descripcion"));
        }
        }
        else{
            System.out.println("error de consulta"+ sql);
        }
        //cx.CerrarConexion();
        st.close();
       // rs.close();
        con.close();

    }
    public void createCategoria(String id, String desc, String estado) throws SQLException{
        sql="INSERT INTO categoria (id_categoria, descripcion,estado)"
                +"VALUES('"+id+"','"+desc+"','"+estado+"')";
        int result =st.executeUpdate(sql);
        System.out.println("result" + result);
        if(result!=0){
            System.out.println("inserto correctamente" +sql);
        }else{
            System.out.println("no inserto");
        }
        //cx.CerrarConexion();
    }
    public void updateCategoria(String id, String desc) throws SQLException{
        sql="UPDATE categoria SET descripcion='"+desc+"', estado='0' "
                +"  WHERE id_categoria='"+id+"' ";
        int result =st.executeUpdate(sql);
        System.out.println("result" + result);
        if(result!=0){
            System.out.println("actualizo correctamente" +sql);
        }else{
            System.out.println("no actualizo");
    }
    }
    public void deleteCategoria(String id) throws SQLException{
        sql="DELETE FROM categoria WHERE id_categoria='"+id+"'";
        int result =st.executeUpdate(sql);
        System.out.println("result" + result);
        if(result!=0){
            System.out.println("elimino correctamente" +sql);
        }else{
            System.out.println("no elimino");
    }
    }
}
