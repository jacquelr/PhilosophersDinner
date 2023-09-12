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
    private int index;
    private boolean isEating;//1: Eating, 2:Thinking, 3:Trying to eat(si alcanza el tiempoxd)

    public Philosopher(Table table, int index) {
        this.table = table;
        this.id = index + 1;
        this.index = index;
        this.isEating = false;
    }
    
    public void run(){
        while(true){
            thinking();
            
            table.grabChopsticks(index);
            System.out.println(id);
            eating();
            System.out.println("Philosopher " + id + "stopped eating. Drop chopsticks" + (table.rightChopstick(index)+1) + " and " + (table.leftChopstick(index)+1));
            table.dropChopsticks(index);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public boolean isIsEating() {
        return isEating;
    }

    public void setIsEating(boolean isEating) {
        this.isEating = isEating;
    }
    
    
    public void thinking(){
        System.out.println("Philosopher " + id + "is thinking.");
        //state = 2;
        try {    
            sleep(((int) (Math.random() * 5) + 2)*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eating(){
        System.out.println("Philosopher " + id + "is eating.");
        setIsEating(true);
        try {    
            sleep(((int) (Math.random() * 5) + 2)*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIsEating(false); 
    }
}
