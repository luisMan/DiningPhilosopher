/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stanleypena
 */
public class Main {
    
    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5};
        Chopstick c = new Chopstick();
        
        for(int i: arr){
            System.out.println("P " + i + " Sat in the table");
            
            new DiningPhilisopher(c).start();
        }
    }
    
}
