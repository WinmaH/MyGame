
package mygame;
import java.util.*;
public interface Observable {
    //observer list to keep all the monsters
    ArrayList<Observer> observers1= new ArrayList<>();
    //observer list to keep all the warriors
    ArrayList<Observer> observers2=new ArrayList<>();
    public void attach(Observer o);
    public void detach(Observer o);
    public void notify_to_obsevers(Observer o);
    
}

