
package mygame;

import java.util.*;

public abstract class Monster extends Inhabitant implements Observer{
    
    private final ArrayList<Walkingstick> ws;
    private final Node node;
    /*
    creating a walking stick warrior array for each monster
    */
    public Monster(String name,int age){
        super(name,age);
        ws=new ArrayList();
        node=new Node(this,0,0);
        set_position();
        Observable.observers1.add(this);
    }
    /*
    method to steal the stick and add it to the walking stick array
    */
    
    @Override
      public void set_position(){
          
        Random random=new Random();
        
        while(true){
            int x=random.nextInt(10)+0;
            int y=random.nextInt(10)+0;
            if (map[x][y][0]==null & map[x][y][1]==null){
                node.set_xy(x, y);
                map[x][y][0]=node;
                System.out.println("Monster " +this.getName()+" positioned at "+x+","+y);
                break;
            }
        }
    }
    public void stealstick(Warrior w){
       Walkingstick stick=w.loosestick();
       if (stick!=null){
            ws.add(stick);
            System.out.println("Monster "+this.getName()+" got the stick");
            
       }
    }
    /*
    method to print the stolen walking stick array of each monster
    */
    public void get_ws(){
        System.out.print(this.getName()+ " has walking sticks ");
        for (Walkingstick w : ws) {
            System.out.print(w + " ");
        }
       System.out.println();
    }
    
    
    @Override
    public abstract void update(Observable o);
        
    
}
