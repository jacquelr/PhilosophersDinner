/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author jlope
 */
public class ConsoleTest {
    //int numChopsticks = 5;
    
    public static void main(String[] args) {
        Table table = new Table(5);
        for (int i = 0 ; i < 5 ; i++){
            Philosopher p = new Philosopher(table, i);
            p.start();
        }
        
    }
}
