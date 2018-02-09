

package mygame;

public abstract class Inhabitant implements Grid{
    private String name;
    private int age;
    
    
    public  Inhabitant(String name,int age){
       this.name=name;
       this.age=age;
    }
    
   public abstract void walk();
   /*
   create getters and setters to access private variables
   */
   public void setAge(int age){
        this.age=age;
   }
   public int getAge(){
        return age;
   }
   public String getName(){
        return name;
   }
   public void setName(String name){
        this.name=name;
   }
   
 }
