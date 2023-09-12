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
public class Table {
    private boolean [] chopsticks;

    public Table(int numChopsticks) {
        this.chopsticks = new boolean[numChopsticks];
    }
    
    public int rightChopstick(int id){
        if(id == 0){
            return chopsticks.length - 1;
        }else{
            return id - 1;
        }
    }
    
    public int leftChopstick(int id){
        return id;
    }
    
    public synchronized void grabChopsticks(int Philosopher){
        while (chopsticks[leftChopstick(Philosopher)] || chopsticks[rightChopstick(Philosopher)]) {            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        chopsticks[leftChopstick(Philosopher)] = true;
        chopsticks[rightChopstick(Philosopher)] = true;
    }
    
    public synchronized void dropChopsticks(int Philosopher){
        chopsticks[leftChopstick(Philosopher)] = false;
        chopsticks[rightChopstick(Philosopher)] = false;
        notifyAll();
    }
}
