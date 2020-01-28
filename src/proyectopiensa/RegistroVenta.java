
package proyectopiensa;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static proyectopiensa.RegistroCompras.fecha;


public class RegistroVenta extends javax.swing.JFrame {
   coneccion con = new coneccion();
    Connection coneccion = con.conectar();
    int contador = 0;    
    public RegistroVenta() {
        initComponents();
        txtfecha.setText(fecha());
         Timer timer = new  Timer();
        TimerTask m = new TimerTask(){
            @Override
        public void run(){
                ImageIcon cd = new ImageIcon(getClass().getResource("/logotipoCellSolutions/cellsolutions.jpg"));
                ImageIcon id = new ImageIcon(cd.getImage().getScaledInstance(logotipo.getWidth(), logotipo.getHeight(), Image.SCALE_DEFAULT));
                logotipo.setIcon(id);
                
            }
    }; timer.schedule(m, 10);
    
    ComboCliente.removeAllItems();
        try {
            Statement st=coneccion.createStatement();
            
            ResultSet rs=st.executeQuery("Select * from Clientes");
            
            while(rs.next()){
                ComboCliente.addItem(rs.getString("Nombre"));
            }
            contador=contador+1;
            
        } catch (Exception e) {
          
        }
    
     
   

    }
    
    public static String fecha(){
        Date fecha=new Date();
        SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    public void verventas(String valor){
    
 DefaultTableModel modelo = new DefaultTableModel(); 
    
    
    modelo.addColumn("#Factura");
    modelo.addColumn("Fecha");
    modelo.addColumn("Cliente");
    modelo.addColumn("Descripcion");
    modelo.addColumn("Marca");
    modelo.addColumn("Modelo");
    modelo.addColumn("Cantidad");
    modelo.addColumn("Precio");
    modelo.addColumn("Total");
    
    Tabla.setModel(modelo);
    
       
    
    String sql = "";
    if (valor.equals("")){
        sql="SELECT * from Ventas";
    }else{
        sql="SELECT * from Ventas WHERE Id_Producto = '"+valor+"'" ;
     }
    String datos[] = new String[9];
        try {
            Statement st= coneccion.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos [0] = rs.getString(1);
                datos [1] = rs.getString(2);
                datos [2] = rs.getString(3);
                datos [3] = rs.getString(4);
                datos [4] = rs.getString(5);
                datos [5] = rs.getString(6);
                datos [6] = rs.getString(7);
                datos [7] = rs.getString(8);
                datos [8] = rs.getString(9);
                      
                
                    modelo.addRow(datos);
            }
            Tabla.setModel(modelo);
        } catch (SQLException e) {
            
        }
        
        
    }
     public void calcularTotal(){
    double subtotal , iva, total;
    subtotal = 0;
for (int i=0; i<Tabla.getRowCount(); i++){
    subtotal = subtotal + Double.parseDouble(Tabla.getValueAt(i, 8).toString());
    
}   
lblsubtotal.setText(String.valueOf(Math.round(subtotal)));
iva = subtotal * 0.12;
lbliva.setText(String.valueOf(Math.round(iva)));
total = subtotal + iva;
lbltotal.setText(String.valueOf(Math.round(total)));

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtId_Producto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarcaPro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtModeloPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCantidadPro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioPro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblsubtotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lbliva = new javax.swing.JLabel();
        btnGuardarVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnVerVentas = new javax.swing.JButton();
        lbltotal = new javax.swing.JLabel();
        btnLimpiarVentas = new javax.swing.JButton();
        logotipo = new javax.swing.JLabel();
        btnBorrarVentas = new javax.swing.JButton();
        ComboCliente = new javax.swing.JComboBox<>();
        btnSalirDelPrograma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        txtId_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_ProductoActionPerformed(evt);
            }
        });
        txtId_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtId_ProductoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("CLIENTE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("DESCRIPCION");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("MARCA DEL PRODUCTO");

        txtMarcaPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaProKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("MODELO DEL PRODUCTO");

        txtModeloPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloProKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("CANTIDAD");

        txtCantidadPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("PRECIO");

        txtPrecioPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/13.png"))); // NOI18N
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 255));
        jLabel7.setText("SUBTOTAL");

        jScrollPane1.setViewportView(Tabla);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 255));
        jLabel8.setText("I.V.A (12%)");

        btnGuardarVenta.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/6.png"))); // NOI18N
        btnGuardarVenta.setText("GUARDAR VENTA");
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 255));
        jLabel9.setText("TOTAL");

        btnVerVentas.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnVerVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/15.png"))); // NOI18N
        btnVerVentas.setText("VER VENTAS");
        btnVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVentasActionPerformed(evt);
            }
        });

        btnLimpiarVentas.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnLimpiarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/15.png"))); // NOI18N
        btnLimpiarVentas.setText("LIMPIAR");
        btnLimpiarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarVentasActionPerformed(evt);
            }
        });

        btnBorrarVentas.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnBorrarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/12.png"))); // NOI18N
        btnBorrarVentas.setText("ELIMINAR");
        btnBorrarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVentasActionPerformed(evt);
            }
        });

        ComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboClienteActionPerformed(evt);
            }
        });

        btnSalirDelPrograma.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnSalirDelPrograma.setForeground(new java.awt.Color(255, 0, 0));
        btnSalirDelPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/4.png"))); // NOI18N
        btnSalirDelPrograma.setText("SALIR DEL SISTEMA");
        btnSalirDelPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDelProgramaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("#FACTURA");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("FECHA");

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/10.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipoCellSolutions/3.png"))); // NOI18N
        jButton3.setText("BUSCAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel12.setText("REGISTRO DE VENTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblsubtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbliva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(673, 673, 673))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfecha)
                            .addComponent(txtMarcaPro, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtModeloPro)
                            .addComponent(txtCantidadPro)
                            .addComponent(txtId_Producto)
                            .addComponent(ComboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescripcion)
                            .addComponent(txtPrecioPro))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jButton3)
                                .addGap(46, 46, 46)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalirDelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarVenta)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVerVentas)
                                .addGap(39, 39, 39)
                                .addComponent(btnLimpiarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(37, 37, 37))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId_Producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMarcaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)))
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtModeloPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirDelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbliva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtId_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_ProductoKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtId_ProductoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c>'9') && (c< 'A' || c> 'Z') && (c< 'a' || c> 'z')&& (c!= KeyEvent.VK_SPACE) && (c!= 'ñ')){
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtMarcaProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaProKeyTyped
        char c = evt.getKeyChar();
        if ((c< 'A' || c> 'Z') && (c< 'a' || c> 'z')&& (c!= KeyEvent.VK_SPACE) && (c!= 'ñ')){
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaProKeyTyped

    private void txtModeloProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloProKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c>'9') && (c< 'A' || c> 'Z') && (c< 'a' || c> 'z')&& (c!= KeyEvent.VK_SPACE) && (c!= 'ñ')){
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloProKeyTyped

    private void txtCantidadProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProKeyTyped

    private void txtPrecioProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioProKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenudeOpciones mo = new MenudeOpciones();
        mo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed

        try {
            Statement st=coneccion.createStatement();

            String descargaComboCliente = (String) ComboCliente.getSelectedItem();

            ResultSet rs=st.executeQuery("Select *from Clientes where Nombre ='"+ComboCliente.getSelectedItem()+"'");
            rs.next();

            String Query= "INSERT INTO Ventas (Id_Producto, Fecha, Cliente, Descripcion, Modelo, Marca, Cantidad, Precio, Total) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1,txtId_Producto.getText());
            statement.setString(2,txtfecha.getText());
            statement.setString(3,descargaComboCliente);
            statement.setString(4,txtDescripcion.getText());
            statement.setString(5,txtMarcaPro.getText());
            statement.setString(6,txtModeloPro.getText());
            statement.setString(7,txtCantidadPro.getText());
            statement.setString(8,txtPrecioPro.getText());
            statement.setString(9,lbltotal.getText());
            
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "LOS DATOS DE GRABARON CORRECTAMENTE");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "LOS DATOS NO FUERON GRABADOS" +e);
        }
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void btnVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVentasActionPerformed
        verventas("");
        calcularTotal();
    }//GEN-LAST:event_btnVerVentasActionPerformed

    private void btnLimpiarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarVentasActionPerformed
        txtId_Producto.setText("");
        txtDescripcion.setText("");
        txtMarcaPro.setText("");
        txtModeloPro.setText("");
        txtCantidadPro.setText("");
        txtPrecioPro.setText("");
        lbltotal.setText("");
    }//GEN-LAST:event_btnLimpiarVentasActionPerformed

    private void btnBorrarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVentasActionPerformed

 int fila = Tabla.getSelectedRow();

        if  (fila>=0){
            txtId_Producto.setText(Tabla.getValueAt(fila,0).toString());
            txtDescripcion.setText(Tabla.getValueAt(fila,1).toString());
            txtMarcaPro.setText(Tabla.getValueAt(fila,2).toString());
            txtModeloPro.setText(Tabla.getValueAt(fila,3).toString());
            txtCantidadPro.setText(Tabla.getValueAt(fila,4).toString());
            txtPrecioPro.setText(Tabla.getValueAt(fila,5).toString());
//        lbltotal.setText(Tabla.getValueAt(fila,9).toString());

        }else{
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO A ELIMINAR");
        }

        fila = Tabla.getSelectedRow();
        String cod = "";
        cod = Tabla.getValueAt(fila,0).toString();
        try {
            PreparedStatement pst= coneccion.prepareStatement("DELETE   from Ventas Where Id_Producto = '"+txtId_Producto.getText()+"'");
            int valor;
        valor = JOptionPane.showConfirmDialog(this, "DESEA ELIMINAR ESTE REGISTRO?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            pst.executeUpdate();
            verventas("");
            JOptionPane.showMessageDialog(null, "EL REGISTRO HA SIDO ELIMINADO");
            txtId_Producto.setText("");
            txtDescripcion.setText("");
            txtMarcaPro.setText("");
            txtModeloPro.setText("");
            txtCantidadPro.setText("");
            txtPrecioPro.setText("");
            calcularTotal();
        }
        } catch (HeadlessException | SQLException e) {
        }

    }//GEN-LAST:event_btnBorrarVentasActionPerformed

    private void ComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboClienteActionPerformed

    private void btnSalirDelProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDelProgramaActionPerformed
        int valor;
        valor = JOptionPane.showConfirmDialog(this, "DESEA SALIR DEL SISTEMA?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "USTED A SALIDO DEL SISTEMA ", "GRACIAS" ,JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }
    }//GEN-LAST:event_btnSalirDelProgramaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int fila = Tabla.getSelectedRow();

        if  (fila>=0){
            txtId_Producto.setText(Tabla.getValueAt(fila,1).toString());
            txtDescripcion.setText(Tabla.getValueAt(fila,4).toString());
            txtMarcaPro.setText(Tabla.getValueAt(fila,5).toString());
            txtModeloPro.setText(Tabla.getValueAt(fila,6).toString());
            txtCantidadPro.setText(Tabla.getValueAt(fila,7).toString());
            txtPrecioPro.setText(Tabla.getValueAt(fila,8).toString());

        }else{
            JOptionPane.showMessageDialog(null, "SELECCION UN REGISTRO");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtId_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_ProductoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     verventas(txtbuscar.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCliente;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnBorrarVentas;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnLimpiarVentas;
    private javax.swing.JButton btnSalirDelPrograma;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbliva;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel logotipo;
    private javax.swing.JTextField txtCantidadPro;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId_Producto;
    private javax.swing.JTextField txtMarcaPro;
    private javax.swing.JTextField txtModeloPro;
    private javax.swing.JTextField txtPrecioPro;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
