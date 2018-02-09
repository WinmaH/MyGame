
package mygame;
import java.util.*;
public class Tree implements Grid{
   
    ArrayList<Fruit> fr_array= new ArrayList();
    private Node node;
    
    public Tree(){
        for (int i=0;i<=3;i++){
            fr_array.add(new Fruit());
        }
        node= new Node(this,0,0);
        set_position();
    }
   
    
    public Fruit get_fruit(){
        Fruit fr_get=null;
        if (fr_array.size()>0){
            fr_get=fr_array.get(0);
            fr_array.remove(0);
        }
        return fr_get;
    }
    
    public void  set_position(){
        while(true){                                                            
            Random random=new Random();
            int x=random.nextInt(10);
            int y=random.nextInt(10);
            if( map[x][y][0]==null & map[x][y][1]==null){                          
                node.set_xy(x, y);
                map[x][y][0]=node;
                System.out.println("Tree positioned at "+x+","+y);
                
                break;
                                                                         
            }
        }
    }
    
}
