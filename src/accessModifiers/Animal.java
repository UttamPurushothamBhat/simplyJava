package accessModifiers;

public class Animal extends LivingBeings{
     String breed;
     boolean bird;

     Animal(String breed){
          this.breed=breed;
          living=false;
     }
     public void display(){
          System.out.println("Animal "+this.living);
     }

     public void display(String name){

     }

     void display2(){
          System.out.println("animal from display2 ");
     }

}
