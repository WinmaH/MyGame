
package mygame;


public interface Grid {
    // 3D map to represent the grid
    public  Node[][][] map = new Node[10][10][2];
    //method to position the objects
    void set_position();
    
}
