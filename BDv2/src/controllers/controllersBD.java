/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.modelBD;
import view.viewBD;

/**
 *
 * @author Yoselin
 */
public class controllersBD {
    
    modelBD modelBD;
    viewBD viewBD;
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewBD.Jb_primero) {
                try {
                    jbtn_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_anterior) {
                try {
                    jbtn_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_siguiente) {
                try {
                    jbtn_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewBD.Jb_ultimo) {
                try {
                    jbtn_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == viewBD.Jb_nuevo){
                try{
                    jb_nuevo_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == viewBD.Jb_insertar){
                jb_insertar_actionPerformed();
            }else if (e.getSource() == viewBD.Jb_modificar){
                try{
                    jb_modificar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
                }  
            
            }else if (e.getSource() == viewBD.Jb_eliminar){
                try{
                    jb_eliminar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllersBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            }

        

    };

    
    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param model objeto de tipo Model
     * @param view objeto de tipo View
     */
    public controllersBD(modelBD model, viewBD view) {
        this.modelBD = model;
        this.viewBD = view;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelBD.conectarDB();
        viewBD.Jtf_nombre.setText(modelBD.getNombre());
        viewBD.Jtf_email.setText(modelBD.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewBD.setLocationRelativeTo(null);
       
        viewBD.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewBD.Jb_primero.addActionListener(actionListener);
        viewBD.Jb_anterior.addActionListener(actionListener);
        viewBD.Jb_siguiente.addActionListener(actionListener);
        viewBD.Jb_ultimo.addActionListener(actionListener);
        viewBD.Jb_nuevo.addActionListener(actionListener);
        viewBD.Jb_modificar.addActionListener(actionListener);
        viewBD.Jb_eliminar.addActionListener(actionListener);
        viewBD.Jb_nuevo.addActionListener(actionListener);
        viewBD.Jb_insertar.addActionListener(actionListener);
        viewBD.Jb_modificar.addActionListener(actionListener);
        viewBD.Jb_eliminar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_primero");
        modelBD.moverPrimerRegistro();//invocar al metodo moverPrimerRegistro
        viewBD.Jtf_nombre.setText(modelBD.getNombre());//mostrar nombre en la vista
        viewBD.Jtf_email.setText(modelBD.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_anterior");
         modelBD.moverAnteriorRegistro();//invocar al metodo moverPrimerRegistro
        viewBD.Jtf_nombre.setText(modelBD.getNombre());//mostrar nombre en la vista
        viewBD.Jtf_email.setText(modelBD.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_ultimo");
        modelBD.moverUltimoRegistro();//invocar al metodo moverPrimerRegistro
        viewBD.Jtf_nombre.setText(modelBD.getNombre());//mostrar nombre en la vista
        viewBD.Jtf_email.setText(modelBD.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_siguiente");
         modelBD.moverSiguienteRegistro();//invocar al metodo moverPrimerRegistro
        viewBD.Jtf_nombre.setText(modelBD.getNombre());//mostrar nombre en la vista
        viewBD.Jtf_email.setText(modelBD.getEmail());//mostar email en la vista
    }
    /**
     * 
     * metodo de botones de nuvo, insertar,modificar y eliminar
     */
   private void jb_nuevo_actionPerformed() throws SQLException{
       System.out.println("Action del boton jb_nuevo");
       modelBD.setEmail(null);//pone el jtfemail vacio
       modelBD.setNombre(null);//pone el jtfnombre vacio
       modelBD.nuevo();//invocara al nuevo registro que quiera realizar
       viewBD.Jtf_email.setText(modelBD.getEmail());//permite modificar y reconocer el texto
       viewBD.Jtf_nombre.setText(modelBD.getNombre()); //permite modificar y reconocer el texto
   }
   private void jb_insertar_actionPerformed(){
       System.out.println("Action del boton insertar");
       modelBD.setNombre(viewBD.Jtf_nombre.getText());//llena el campo de nombre
       modelBD.setEmail(viewBD.Jtf_email.getText());//llena el campo de email
       modelBD.insertar(modelBD.getNombre(),modelBD.getEmail());//Guarda el registro
   }
   private void jb_modificar_actionPerformed() throws SQLException{
       
       modelBD.modificar(viewBD.Jtf_nombre.getText(), viewBD.Jtf_email.getText());
       JOptionPane.showMessageDialog(viewBD," Tu registro ha sido modificado ");
   }
   private void jb_eliminar_actionPerformed() throws SQLException{
       System.out.println("Action del boton eliminar");
            System.out.println(modelBD.getEmail());
            modelBD.eliminar(modelBD.getEmail());
            JOptionPane.showMessageDialog(viewBD, "Advertencia tu registro se ha eliminado "); 
            
   }
}
