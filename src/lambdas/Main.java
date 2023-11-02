package lambdas;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {

    public static FilteringCondition CallMethod(){
       FilteringCondition lambda = ss -> ss.age<50;
       return lambda;
    }

    public Integer intval(String val){

        return Integer.parseInt(val);
    }


    public static void main(String[] args) {
        Main main = new Main();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        StudentService studentService = new StudentService();

        FilteringCondition filteringCondition = a -> a.age>25;

        List<String> dummyList =  List.of("1","2","3","4","5");

        List<Student> interfaceDefinedHere = studentService.filterStudents(filteringCondition);
      Optional<Integer> l  = dummyList.stream().filter(a->Integer.parseInt(a)<30).map(main::intval).reduce((a, b)-> {
          System.out.println("a : " + a+ " b : "+ b);
          if(a>b)return a+1+b;else return a+b;
      });

        System.out.println("age data " + l.get());

        System.out.println("Student names");
       /* List<Student> studentNames = studentService.filterStudents(new FilteringCondition() {
            @Override
            public boolean filter(Student s) {
                return true;
            }
        });
*/



        List<Student> studentNames = studentService.filterStudents(CallMethod());
        List<Student> students = studentService.filterStudents((st)->st.getStandard()>12);
        List<Student> students1 = studentService.filterStudents(stt -> stt.grade==Grade.A);



        List<String> students2 = studentService.s.stream().filter(Student::isAccepted).map(Student::getName).collect(Collectors.toList());
        for (Student s : students1) System.out.println(s.getGrade().getLetter());

        //LAMBDA INTERFACES  - 1 METHOD ONLY - @FunctionalInterface
      /*
        System.out.println("Student ages - 5");
        List<Integer> studentAges = studentService.filterStudentsAge(new FilteringCondition() {
            @Override
            public boolean filter(Student s) {
                return false;
            }

            @Override
            public int ageminus5(Student s) {
                return s.age - 5;
            }

        });

        for (int s : studentAges) System.out.println(s);*/



        /*
        Collections.sort(dummyList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });*/
    }
}
