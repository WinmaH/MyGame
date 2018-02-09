
package mygame;


public class Node {
    private int x;
    private int y;
    private final Grid node_owner;
    
    public Node(Grid node_owner,int x,int y){
        this.node_owner=node_owner;
        this.x=x;
        this.y=y;
    }

    
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public void set_xy(int x,int y){
        this.x=x;
        this.y=y;
    }
   
    public Grid get_node_owner(){
        return node_owner;
    }
    
}
