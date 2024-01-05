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
    public Chopstick [] chopsticks;

    public Table(int numPhilosophers) {
        this.chopsticks = new Chopstick[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++){
            chopsticks[i] = new Chopstick(i);
        }
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
    
//    public void grabRightChopstick(int id){
//        if (id == 0){
//            chopsticks[chopsticks.length - 1].setIsAvailable(false);
//        }else{
//            chopsticks[id - 1].setIsAvailable(false);
//        }
//    }
//    
//    public void grabLeftChopstick(int id){
//        chopsticks[id].setIsAvailable(false);
//    }
//    
//    public void dropRightChopstick(int id){
//        if (id == 0){
//            chopsticks[chopsticks.length - 1].setIsAvailable(false);
//        }else{
//            chopsticks[id - 1].setIsAvailable(false);
//        }
//    }
//    
//    public void dropLeftChopstick(int id){
//        chopsticks[id].setIsAvailable(false);
//    }
    
    public synchronized void grabChopsticks(int Philosopher){
        while (!chopsticks[leftChopstick(Philosopher)].isIsAvailable() || !chopsticks[rightChopstick(Philosopher)].isIsAvailable()) {            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        chopsticks[leftChopstick(Philosopher)].setIsAvailable(false);
        chopsticks[rightChopstick(Philosopher)].setIsAvailable(false);
    }
    
    public synchronized void dropChopsticks(int Philosopher){
        chopsticks[leftChopstick(Philosopher)].setIsAvailable(true);
        chopsticks[rightChopstick(Philosopher)].setIsAvailable(true);
        notifyAll();
    }
}
