
package mygame;

import java.util.*;

public abstract class Warrior extends Inhabitant implements Runnable,Observer, Observable{
    
    private boolean immortality;
    private boolean mobility ;
    private Walkingstick stick;
    private static int  no_of_warriors;
    private final Node node;
    long startTime;
    
    
    public Warrior(String name,int age){
        super(name,age);
        this.mobility=true;
        this.immortality=false;
        stick=new Walkingstick();
        no_of_warriors++;
        node=new Node(this, 0, 0);
        Observable.observers2.add(this);
        set_position();
        }
    public Node get_node(){
        return node;
    }
     public void update(Observable o){
        this.set_mobility(false);
    }
    public void start_time(){
         startTime = System.currentTimeMillis();
    }
    
    public void  set_position(){
        while (true){
            Random rn=new Random();
            
            int first_specific=0;
            int second_specific=9;
            /*
            select one co-ordinate out of 0 and 9
            */
            ArrayList <Integer> specific_margin= new ArrayList(Arrays.asList(first_specific,second_specific));
            int random_index=rn.nextInt(2)+0;
            int first_chosen_coordinate=specific_margin.get(random_index);
            /*
            select the other co-ordinate
            */
            int second_chosen_coordinate=rn.nextInt(10)+0;
            ArrayList <Integer> random_margin= new ArrayList(Arrays.asList(first_chosen_coordinate,second_chosen_coordinate));
            /*
            select the warrior initial co_ordinate by selecting one index from 0 or 9 group and the other
            */
            int random_index1=rn.nextInt(2)+0;
            int x=random_margin.get(random_index1);
            random_margin.remove(random_index1);
            int y=random_margin.get(0);
            
            if(map[x][y][0]==null & map[x][y][1]==null){                                             //if suitable position found, place warrior                       
                node.set_xy(x, y);
                map[x][y][1]=node;
                System.out.println("Warrior "+this.getName()+" positioned at "+x+","+y);
               
                break;                                                          //break the while loop
            }
            
            }
    }
    
    
    
    /*
    method to eat fruit
    */
   
    public void eat_fruit(Tree tree){
        if ( tree.get_fruit()!=null){
            System.out.println("Warrior "+this.getName() +" ate fruit");
            this.set_immortality(true);
        }
    }
    /*
    method to loose the stick
    */
    public Walkingstick loosestick(){
        Walkingstick temp=stick;
        if (this.stick !=null){
        this.stick=null;
        System.out.println("Warrior "+this.getName()+" lost the stick");}
        this.mobility=false;
        return temp;
        
    }
    /*
    create getters and setters to acess private variables
    */
 
    public boolean get_immortality(){
        return immortality;
    }
    public void set_immortality(boolean b){
        this.immortality=b;
    }
    public boolean get_mobility(){
        return mobility;
    }
    public void set_mobility(boolean b){
        this.mobility=b;
    }
    
    public static int get_no_of_warriors(){
           return no_of_warriors; }
    @Override
    public void attach(Observer o){
        observers1.add(o);
    }
    @Override
    public void detach(Observer o){
        observers1.remove(o);
    }
    @Override
    public void notify_to_obsevers(Observer ob){
        for (Observer o : observers1) {
            if (o==ob){
            o.update(this);}
        }
}
    
   public void normal_walk(){
        synchronized(map){
        
         Node node=this.get_node();
        
        
        while (this.get_mobility()){
           
            int x=node.get_x();
            int y=node.get_y();
            int x_=-1;
            int y_=-1;
        
            Object temp = null;
            boolean walked=false;
            
            Random rn=new Random();
            int random_direction=rn.nextInt(4)+1;
            
            
                
            switch(random_direction){
                case 1:
                    if (x-1>=0){
                        x_=x-1;
                        y_=y;
                       if (map[x-1][y][1]==null){
                            node.set_xy(x-1, y);
                            
                            map[x][y][1]=null;
                            
                            map[x-1][y][1]=node;
                            walked=true;
                            if (map[x-1][y][0]!=null ){
                                if (map[x-1][y][0].get_node_owner() instanceof MountDome==true  | map[x-1][y][0].get_node_owner() instanceof Tree==true | map[x-1][y][0].get_node_owner() instanceof Monster==true){
                                temp=map[x-1][y][0].get_node_owner();
                                }
                            }
                        }
                    }
                        
                    
                    break;
                            
                case 2:
                    if (y-1>=0 ){
                        x_=x;
                        y_=y-1;
                        if (map[x][y-1][1]==null){
                            node.set_xy(x, y-1);
                            
                            map[x][y][1]=null;
                            
                            map[x][y-1][1]=node;
                            walked=true;
                            if (map[x][y-1][0]!=null){
                                if (map[x][y-1][0].get_node_owner() instanceof MountDome==true | map[x][y-1][0].get_node_owner() instanceof Tree==true |map[x][y-1][0].get_node_owner() instanceof Monster==true ){
                                    temp=map[x][y-1][0].get_node_owner();
                                }
                            }
                        }
                    }
                    break;
                            
                    
                                                    
                case 3:
                     if (x+1<=9){
                         x_=x+1;
                         y_=y;
                        if (map[x+1][y][1]==null){
                            node.set_xy(x+1, y);
                            
                            map[x][y][1]=null;
                            
                            map[x+1][y][1]=node;
                            walked=true;
                            if (map[x+1][y][0]!=null ){
                                if (map[x+1][y][0].get_node_owner() instanceof MountDome==true | map[x+1][y][0].get_node_owner() instanceof Tree==true | map[x+1][y][0].get_node_owner() instanceof Monster==true){
                                    temp=map[x+1][y][0].get_node_owner();
                                }   
                            }
                        }
                     }
                    
                    break;
                   
                                                    
                case 4:
                   if (y+1<=9 ){
                       x_=x;
                       y_=y+1;
                        if (map[x][y+1][1]==null){
                            node.set_xy(x, y+1);
                            
                            map[x][y][1]=null;
                            
                            map[x][y+1][1]=node;
                            walked=true;
                            if (map[x][y+1][0]!=null ){
                                if (map[x][y+1][0].get_node_owner() instanceof MountDome==true | map[x][y+1][0].get_node_owner() instanceof Tree==true | map[x][y+1][0].get_node_owner() instanceof Monster==true){
                                    temp=map[x][y+1][0].get_node_owner();
                                }
                            }
                        }
                   }
                    break;
           }
           
            
            
            if (walked){
                if (temp instanceof Tree){
                    System.out.println("Warrior "+this.getName()+" found a tree at "+x_+","+y_);
                        this.eat_fruit((Tree)temp);
                        }else if(temp instanceof MountDome){
                        System.out.println("Warrior "+this.getName()+"               WON");
                        MountDome temp_mountdome=(MountDome)temp;
                        temp_mountdome.notify_to_obsevers(this);
                        long stopTime = System.currentTimeMillis();
                        long elapsedTime = stopTime - startTime;
                        System.out.println("Total time taken by Warrior "+this.getName()+" to win is "+elapsedTime +" ms");
                        }else if (temp instanceof InnocentMonstor){
                        System.out.println("Warrior "+this.getName()+" found a monster at "+x_+","+y_);
                        InnocentMonstor temp_monstor=(InnocentMonstor)temp;
                        this.notify_to_obsevers(temp_monstor);
                        //temp_monstor.update(this);
                } else if (temp instanceof NonInnocentmonster){
                    System.out.println("Warrior "+this.getName()+" found a monster at "+x_+","+y_);
                    NonInnocentmonster temp_monstor=(NonInnocentmonster)temp;
                    this.notify_to_obsevers(temp_monstor);
                   // temp_monstor.update(this);
                } else{System.out.println("Warrior "+this.getName()+" walked to "+x_+","+y_+"..");}
            }
       }  
   }
  }
    public abstract void  drink();
    public abstract void eat();
    public abstract void sleep();
}
