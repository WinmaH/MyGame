
package mygame;

public class MountDome implements Grid,Observable{
    private Node node;
    
    public MountDome(){
        node= new Node(this,5,5);
        set_position();
    }
    @Override
    public void set_position(){
        node.set_xy(5, 5);
        map[5][5][0]=node;
        System.out.println("MountDome positioned at 5,5");
    }
    @Override
    public void attach(Observer o){
        observers2.add(o);
        }
    @Override
    public void detach(Observer o){
        observers2.add(o);
    }
    

    @Override
    public void notify_to_obsevers(Observer o) {
        for (Observer observers21 : observers2) {
            observers21.update(this);
            
        }
        
    }
}
