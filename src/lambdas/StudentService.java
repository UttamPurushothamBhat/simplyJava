package lambdas;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> s = new ArrayList<>();
    StudentService(){
        s.add(new Student("Uttam", 26,Grade.A, 12, false));
        s.add(new Student("Tushara", 23,Grade.B, 9, true));
        s.add(new Student("Vandita", 32,Grade.F, 15, true));
    }

    public List<Student>   filterStudents(FilteringCondition filteringCondition){

        List<Student> toReturn = new ArrayList();
        for(Student ss : s){
            if(filteringCondition.filter(ss))toReturn.add(ss);
        }
        return toReturn;
    }

}
