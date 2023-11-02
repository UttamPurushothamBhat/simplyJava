import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class learningStream {

    public static Integer checker(int x){return x*2;};
    public static void main(String[] args){


        learningStream ls = new learningStream();

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);



        Function<Integer, String> function = a -> String.valueOf(a);


        Consumer<String> consumer = a->System.out.println(a);


        List<String> s = list.stream().filter(ls::filterCondition).map(function).collect(Collectors.toList());
        s.forEach(consumer);

        System.out.println("done before parallel stream ends");


        for(String ss: s)System.out.println(ss);


    }

    private int twiceTheVal(int a) {
        return 2*a;
    }

    public  boolean filterCondition(int a){
        System.out.println(a + " " + Thread.currentThread().getName());
        return a>3;
    }


}
