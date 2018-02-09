
package mygame;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class MyGame {
    public static void main(String[] args) {
       
        
        MountDome md =new MountDome();
         System.out.println("");
        
        InnocentMonstor m1 = new InnocentMonstor("isuu",24);
        InnocentMonstor m2 = new InnocentMonstor("bizmi",22);
        InnocentMonstor m3 = new InnocentMonstor("damsaa",21);
        NonInnocentmonster m4 = new NonInnocentmonster("maduu",19);
        NonInnocentmonster m5 = new NonInnocentmonster("gagana",26);
        
        System.out.println("");
        
        SuperWarrior w1 = new SuperWarrior("neel",23);
        NormalWarrior w2 = new NormalWarrior("chami",24);
        SuperWarrior w3 = new SuperWarrior("winma",28);
        NormalWarrior w4 = new NormalWarrior("hele",18);
        
         System.out.println("");
         
        Tree t1 = new Tree();
        Tree t2 = new Tree();
        Tree t3 = new Tree();
        Tree t4 = new Tree();
        Tree t5 = new Tree();
        System.out.println("");
        
        ArrayList<Grid> grd = new ArrayList<>();
        grd.add(w1);
        grd.add(m1);
        grd.add(t1);
        
        
       
        Thread tr1= new Thread(w1);
        Thread tr2=new Thread(w2);
        Thread tr3=new Thread(w3);
        Thread tr4=new Thread(w4);
        
        
        
       
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
     
       
      

    }
    
}
