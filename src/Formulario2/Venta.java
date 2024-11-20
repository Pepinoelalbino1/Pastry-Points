/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formulario2;

import Codigo.Conexion;
import Codigo.IPastelData;
import Codigo.PastelConcreto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Venta extends javax.swing.JInternalFrame {
private DefaultTableModel modeloDatosProductos;
private ArrayList<PastelConcreto> listaProductos = new ArrayList<>();
// Variables para la lógica de la venta
private int idCliente = 0; // ID del cliente seleccionado
private int cantidad = 0; // Cantidad de productos a comprar
private double totalPagarGeneral = 0.0; // Total a pagar acumulado


    /**
     * Creates new form Venta
     */
    public Venta() {
        initComponents();
        this.setTitle("Facturación");
        // Cargar clientes y productos en la vista
    this.CargarComboClientes();
    this.CargarComboProductos();
    
     // Desactivar campos y botones hasta que se añadan productos
    txt_efectivo.setEnabled(false);
    txt_efectivo.setEnabled(false);
    jButton_calcular_cambio.setEnabled(false);
    }
    
// Método para inicializar la tabla de productos
private void inicializarTablaProducto() {
    modeloDatosProductos = new DefaultTableModel();
    // Añadir columnas
    modeloDatosProductos.addColumn("N");
    modeloDatosProductos.addColumn("Nombre");
    modeloDatosProductos.addColumn("Cantidad");
    modeloDatosProductos.addColumn("P. Unitario");
    modeloDatosProductos.addColumn("Total Pagar");
    modeloDatosProductos.addColumn("Acción");
    // Asignar modelo al JTable
    this.jTable_productos.setModel(modeloDatosProductos);
}

// Método para actualizar la tabla con los datos de la lista
private void listaTablaProductos() {
    this.modeloDatosProductos.setRowCount(listaProductos.size());
    for (int i = 0; i < listaProductos.size(); i++) {
        PastelConcreto pastel = listaProductos.get(i);
        double totalPagar = pastel.getPrecio() * pastel.getCalificacion(); // Usando calificación como cantidad

        this.modeloDatosProductos.setValueAt(i + 1, i, 0); // Número
        this.modeloDatosProductos.setValueAt(pastel.getNombre(), i, 1); // Nombre
        this.modeloDatosProductos.setValueAt(pastel.getCalificacion(), i, 2); // Cantidad
        this.modeloDatosProductos.setValueAt(pastel.getPrecio(), i, 3); // Precio unitario
        this.modeloDatosProductos.setValueAt(totalPagar, i, 4); // Total a pagar
        this.modeloDatosProductos.setValueAt("Eliminar", i, 5); // Acción
    }
    // Actualizar el JTable
    jTable_productos.setModel(modeloDatosProductos);
}

// Método para calcular el total a pagar general
private void calcularTotalPagarGeneral() {
    totalPagarGeneral = 0.0;
    for (PastelConcreto pastel : listaProductos) {
        totalPagarGeneral += pastel.getPrecio() * pastel.getCalificacion(); // Precio * Cantidad
    }
    totalPagarGeneral = Math.round(totalPagarGeneral * 100.0) / 100.0; // Redondear a 2 decimales
    txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jButton_busca_cliente = new javax.swing.JButton();
        txt_cliente_buscar = new javax.swing.JTextField();
        jButton_añadir_producto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));

        jButton_RegistrarVenta.setText("Registar Venta");
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Cliente");

        jLabel3.setText("Producto");

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_productos);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });

        jButton_añadir_producto.setText("Añadir Productos");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Facturar");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });

        jLabel5.setText("Total a Pagar");

        jLabel6.setText("Efectivo");

        jLabel7.setText("Cambio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_calcular_cambio)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(txt_total_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_calcular_cambio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("# cedula");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(7, 7, 7)
                                .addComponent(txt_cliente_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_busca_cliente)
                            .addComponent(jButton_añadir_producto))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_RegistrarVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_busca_cliente)
                                .addComponent(txt_cliente_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_añadir_producto))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_RegistrarVenta)))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
 String clienteBuscar = txt_cliente_buscar.getText().trim();
        Connection cn = Conexion.getInstance().getConnection();
        String sql = "select nombre, apellido from tb_cliente where cedula = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Cedula de cliente incorrecta o no encontrada!");
            }
            txt_cliente_buscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
try {
            String combo = this.jComboBox_producto.getSelectedItem().toString();

            // Validar que se seleccione un pastel
            if (combo.equalsIgnoreCase("Seleccione producto:")) {
                JOptionPane.showMessageDialog(null, "Seleccione un pastel");
                return;
            }

            // Validar que se ingrese una cantidad
            String cantidadTexto = txt_cantidad.getText().trim();
            if (cantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de pasteles");
                return;
            }

            // Validar que la cantidad sea un número
            if (!validar(cantidadTexto)) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero válido");
                return;
            }

            int cantidad = Integer.parseInt(cantidadTexto);

            // Validar que la cantidad sea mayor a 0
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero (0)");
                return;
            }

            // Obtener datos del pastel seleccionado a través de IPastelData
            IPastelData pastelData = new IPastelData(Conexion.getInstance().getConnection());
            String nombrePastel = pastelData.obtenerNombrePastel(Integer.parseInt(combo));
            BigDecimal precioUnitario = pastelData.obtenerPrecioPastel(Integer.parseInt(combo));

            if (nombrePastel == null || precioUnitario == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo obtener los datos del pastel seleccionado");
                return;
            }

            // Calcular el precio total
            BigDecimal totalPagar = precioUnitario.multiply(new BigDecimal(cantidad));
            totalPagar = totalPagar.setScale(2, BigDecimal.ROUND_HALF_UP); // Redondear a 2 decimales

            // Crear un nuevo pastel concreto
            PastelConcreto pastel = new PastelConcreto(
                Integer.parseInt(combo),
                nombrePastel,
                false, // Suposición de que no es diet-friendly
                precioUnitario.doubleValue()
            );

            // Mostrar mensaje con los detalles de la compra
            JOptionPane.showMessageDialog(null,
                "Has agregado " + cantidad + " unidad(es) del pastel '" + pastel.getNombre() + "'.\n" +
                "Precio unitario: $" + pastel.getPrecio() + "\n" +
                "Precio total: $" + totalPagar);

            // Actualizar la tabla, si es necesario
            this.listaTablaProductos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar el pastel: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
if (!txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_efectivo.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);

                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed

        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para registrar la venta.");
            return;
        }

        // Validar cliente seleccionado
        if (jComboBox_cliente.getSelectedItem().toString().equalsIgnoreCase("Seleccione cliente:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para registrar la venta.");
            return;
        }

        try {
            // Obtener el cliente seleccionado
            ObtenerIdCliente();

            // Guardar datos de la venta en la base de datos
            Connection cn = Conexion.getInstance().getConnection();
            String sqlCabecera = "INSERT INTO tb_cabecera_venta (idCliente, totalPagar, tipoRecojo) VALUES (?, ?, ?)";
            PreparedStatement psCabecera = cn.prepareStatement(sqlCabecera, Statement.RETURN_GENERATED_KEYS);
            psCabecera.setInt(1, idCliente);
            psCabecera.setDouble(2, totalPagarGeneral);
            

            int rowsInserted = psCabecera.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = psCabecera.getGeneratedKeys();
                int idVenta = 0;
                if (generatedKeys.next()) {
                    idVenta = generatedKeys.getInt(1);
                }

                // Insertar detalles de la venta
                String sqlDetalle = "INSERT INTO tb_detalle_venta (idCabecera, idProducto, cantidad, precioUnitario, totalPagar) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement psDetalle = cn.prepareStatement(sqlDetalle);

                for (PastelConcreto pastel : listaProductos) {
                    psDetalle.setInt(1, idVenta); // ID de la cabecera
                    psDetalle.setInt(2, pastel.getId()); // ID del producto
                    psDetalle.setInt(3, pastel.getCalificacion()); // Cantidad (usando Calificación como cantidad)
                    psDetalle.setDouble(4, pastel.getPrecio()); // Precio unitario
                    psDetalle.setDouble(5, pastel.getPrecio() * pastel.getCalificacion()); // Total a pagar
                    psDetalle.addBatch();

                    // Actualizar stock del producto
                    RestarStockProductos(pastel.getId(), pastel.getCalificacion());
                }
                psDetalle.executeBatch();

                // Confirmar venta registrada
                JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.");
                listaProductos.clear(); // Limpiar lista de productos
                inicializarTablaProducto(); // Reiniciar tabla
                txt_total_pagar.setText("0.0"); // Reiniciar total a pagar
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la venta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
       }//GEN-LAST:event_jTable_productosMouseClicked
//Metodo para cargar los clientes en el jComboBox
    
    private void CargarComboClientes() {
        Connection cn = Conexion.getInstance().getConnection();
        String sql = "select * from tb_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

    /*
    Metodo para cargar los productos en el jComboBox
     */
    private void CargarComboProductos() {
        Connection cn = Conexion.getInstance().getConnection();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre,' ',apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.getInstance().getConnection();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }

    //metodo para restar la cantidad (stock) de los productos vendidos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = Conexion.getInstance().getConnection();
            String sql = "select idProducto, cantidad from tb_producto where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            Connection cn = Conexion.getInstance().getConnection();
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if(consulta.executeUpdate() > 0){
                //System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables
}
