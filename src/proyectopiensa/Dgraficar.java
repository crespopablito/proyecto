
package proyectopiensa;
import proyectopiensa.coneccion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Dgraficar {
    Connection cn=coneccion.conectar();
    
    public DefaultTableModel mostrarpersona(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"id_compra","proveedor"};
            String dta[]=new String[2];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select * from compras";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("id_compra");
            dta[1]=rs.getString("proveedor");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
public DefaultTableModel agruparpersona(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"nombre","cuentas_personas"};
            String dta[]=new String[2];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select nombre, count(nombre) from personas group by nombre";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("nombre");
            dta[1]=rs.getString("count(nombre)");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
public DefaultTableModel mostrargenero(){
    
        DefaultTableModel miModelo=null;
 
        try {
            String titulos[]= {"Id_compra", "proveedor", "Marca", "Modelo","Cantidad"};
            String dta[]=new String[5];
            miModelo=new DefaultTableModel(null,titulos);
            String sql="select * from compras";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            
            while(rs.next()){
            dta[0]=rs.getString("Id_compra");
            dta[1]=rs.getString("proveedor");
            dta[2]=rs.getString("Marca");
            dta[3]=rs.getString("Modelo");
            dta[4]=rs.getString("Cantidad");
            miModelo.addRow(dta);
            
            
            
            }
            
        } catch (Exception e) {
        }
        return miModelo;
    }
}


