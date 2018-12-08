/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import model.modelBD;
import view.viewBD;
import controllers.controllersBD;
/**
 *
 * @author Yoselin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       modelBD modelBD = new modelBD();
        viewBD viewBD = new viewBD();
        controllersBD controllers = new controllersBD(modelBD, viewBD);
    }
    
}
