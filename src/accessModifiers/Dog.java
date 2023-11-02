package accessModifiers;

public class Dog extends Animal{
    Dog(String breed) {
        super(breed);
        living=true;
    }

   // @Override
    public void display(){
        System.out.println(living + "  from dog without override"+ breed);
        System.out.println("Dog " + Thread.currentThread().getName());
       //super.display2();
       // super.display("gg");
    }

    public int tryinOut(int...gg){
        int sum=0;
        for(int i :gg ){
            sum+=i;
        }
        return sum;
    }

    public void tryingOut(int...gg){

    }

}
