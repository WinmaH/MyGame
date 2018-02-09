

package mygame;

public class NonInnocentmonster extends Monster {

    public NonInnocentmonster(String name, int age) {
        super(name, age);
    }

    public void kill_warrior(Warrior w) {
        if (w.get_immortality()== false) {
            map[w.get_node().get_x()][w.get_node().get_y()][1]=null;
            Observable.observers2.remove(w);
            System.out.println("Monster "+this.getName()+" kill warrior");
        }
    }
    @Override
   public void walk(){
      
    }
    @Override
   public void update(Observable o){
        stealstick((Warrior)o);
        kill_warrior((Warrior)o);}
}

