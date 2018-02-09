
package mygame;



public class NormalWarrior extends Warrior {
     public NormalWarrior(String name,int age){
        super(name,age);
        
    }
     
     public void run(){
         
         
             synchronized(map){
                 
                 this.start_time();
             }
             
             walk();
             
         
         
     }
     
     
    @Override
    public void walk(){
        
        this.normal_walk();}
  
        
    
    public void drink(){
    }
    public void eat(){
    }
    public void sleep(){
    }
    
}

