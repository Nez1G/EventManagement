/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlo;

/**
 *
 * @author andre
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalController lc = new LocalController();
        //lc.disponibilidadeRecursos(1);
        lc.criarLocal("Teste", "666", "123131");
    }
    
}
