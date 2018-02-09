
package mygame;

import static mygame.Grid.map;

public class Binocular {
    /*
    check the four directions of the warrior to see whether there is a tree
    */
    public boolean look_for_trees(int x,int y,Warrior w){
        synchronized(map){
            if (x-1>=0 && map[x-1][y][0]!=null && map[x-1][y][0].get_node_owner() instanceof Tree){
                return true;
            }else if(x+1<=9 && map[x+1][y][0]!=null && map[x+1][y][0].get_node_owner() instanceof Tree){
                return true;
            }else if(y-1>=0 && map[x][y-1][0]!=null && map[x][y-1][0].get_node_owner() instanceof Tree){
                return true;
            }else if (y+1<=0 && map[x][y+1][0]!=null && map[x][y+1][0].get_node_owner() instanceof Tree){
            return true;
            }
        }
            
        return false;
    }
}
