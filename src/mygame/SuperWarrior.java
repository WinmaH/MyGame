
package mygame;



public class SuperWarrior extends Warrior{
    Binocular bino;
    private boolean tree_not_found;
    /*
    create a new binocular for each super warrior
    */
    
    public SuperWarrior(String name,int age){
        super(name,age);
        bino= new Binocular();
        tree_not_found=true;
        
    }
    
    @Override
    public void run(){
        synchronized(map){
            this.start_time();
            
         }
        walk();
        
    }
    
    @Override
    public void walk(){
        synchronized(map){
            
            Node node=this.get_node();
            int x=node.get_x();
            int y=node.get_y();
            while(this.get_mobility()){
                boolean go_for_trees = bino.look_for_trees(x,y, this);
                if ( tree_not_found && go_for_trees){
                    this.tree_not_found=false;
                if (x-1>=0 && map[x-1][y][0] !=null && map[x-1][y][0].get_node_owner() instanceof Tree){
                    System.out.println("Warrior "+this.getName()+" found a tree at "+(x-1)+","+y);
                    this.eat_fruit((Tree)map[x-1][y][0].get_node_owner());
                    this.set_immortality(true);
                    
                }else if(y-1>=0 && map[x][y-1][0] != null && map[x][y-1][0].get_node_owner() instanceof Tree){
                    System.out.println("Warrior "+this.getName()+" found a tree");
                    this.eat_fruit((Tree)map[x][y-1][0].get_node_owner());
                    this.set_immortality(true);
                    
                }else if(x+1<=9 && map[x+1][y][0]!= null &&  map[x+1][y][0].get_node_owner() instanceof Tree){
                    System.out.println("Warrior "+this.getName()+" found a tree");
                    this.eat_fruit((Tree)map[x+1][y][0].get_node_owner());
                    this.set_immortality(true);
                    
                }else if (y+1<=9 && map[x][y+1][0] != null && map[x][y+1][0].get_node_owner() instanceof Tree){
                    System.out.println("Warrior "+this.getName()+" found a tree");
                    this.eat_fruit((Tree)map[x][y+1][0].get_node_owner());
                    this.set_immortality(true);
                  
                }
                
                }else{
                    normal_walk();
                }
            } 
        }
    }
    public void eat(){
    }
    public void drink(){
    }
    public void sleep(){
    }
}
