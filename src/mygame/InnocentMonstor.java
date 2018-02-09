

package mygame;

public class InnocentMonstor extends Monster{
    
    public InnocentMonstor(String name,int age){
        super(name,age);
    }
  
    @Override
    public void walk(){}
    @Override
    public void update(Observable o){
        stealstick((Warrior)o);
    }
}

    