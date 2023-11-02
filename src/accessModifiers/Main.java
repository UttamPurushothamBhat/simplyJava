package accessModifiers;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("yorkie");

       /* dog.display();
      *//*  Animal animal = new Animal("animal");
        System.out.println(animal.living);
        System.out.println(LivingBeings.living);

        System.out.println(dog.tryignOut(1,2,3,4));
        System.out.println(dog.tryignOut(12,24));*/

        Class obj = dog.getClass();
        dog.display();
        System.out.println(obj.getName());
       System.out.println(Modifier.toString(obj.getModifiers()));

        Method[] m = obj.getDeclaredMethods();
        for(Method mm : m) System.out.println(mm);

        System.out.println(obj.getSuperclass().getName());


        Animal cat = new Cat("Cat");

        cat.display();
        if(!cat.bird) System.out.println("NO BIRD");

        Animal cat1 = new Cat("Cat");

        Animal animal = new Animal("animal");
        System.out.println(cat.hashCode());
        System.out.println(cat1.hashCode());
        System.out.println(Integer.toHexString(cat.hashCode()));
        System.out.println(cat.toString());
        System.out.println(cat.equals(cat1));

        System.out.println(cat.getClass()== animal.getClass());
        System.out.println(cat instanceof Animal);


        Cat catDownCasted = (Cat) cat1;

        System.out.println(catDownCasted.equals(cat1));
        catDownCasted.breed ="notcat";
        System.out.println(cat1.breed);


        new Cat("cat"){
            void checking(){
                System.out.println("works");
            }
        }.checking();



    }
}
