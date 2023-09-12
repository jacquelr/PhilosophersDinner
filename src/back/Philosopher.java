/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlope
 */
public class Philosopher extends Thread{
    private Table table;
    private int id;
    private int state;//1: Eating, 2:Thinking, 3:Trying to eat

    public Philosopher(Table table, int id) {
        this.table = table;
        this.id = id;
    }
    
    public void run(){
        while(true){
            thinking();
            
            table.grabChopsticks(id);
            System.out.println(id);
            eating();
            System.out.println("Philosopher " + (id+1) + "stopped eating. Drop chopsticks" + (table.rightChopstick(id)+1) + " and " + (table.leftChopstick(id)+1));
            table.dropChopsticks(id);
        }
    }
    
    public void thinking(){
        System.out.println("Philosopher " + (id+1) + "is thinking.");
        state = 2;
        try {    
            sleep((int) (Math.random() * 5) + 2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eating(){
        System.out.println("Philosopher " + (id+1) + "is eating.");
        state = 1;
        try {    
            sleep((int) (Math.random() * 5) + 2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
