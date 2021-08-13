import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class main implements person {
    public static void main(String[] args) throws IllegalAccessException {
        main m = new main();
        m.str(); //static method can be created inside a class and access by other static method by object
        str();//static method can be created inside a class and access by other static method by without object
        person.ab();//interface static methods are accessible
        vehicle v1 = ()-> {
            System.out.println("A");
        };//providing interface body with lambda expression
        vehicle v = new vehicle(){// providing interface body with anonymous class
            @Override
            public void printa(){
             System.out.println("A");
            }
        };
        Comparator<String> stringComparator = new Comparator<String>() {//overiding comparator with anonymous class
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };// anonymous class end
        int comparison = stringComparator.compare("hello","world");
        System.out.println(comparison);
        Comparator<String> stringComparatorlambda =    // overriding comparator with lambda expression//
                (String o1, String o2) -> {return o1.compareTo(o2);}; // we can remove return and b rackets if there is only one line
        int lammbdacomp = stringComparatorlambda.compare("hello","world");
        System.out.println(lammbdacomp);
        Predicate<Integer> p = (Integer age) -> { return age > 18;}; //predicate are built in functional interfaces that return boolean
        System.out.println(p.test(23));
        ArrayList<Integer> at = new ArrayList<>();
        Predicate<ArrayList> p1 = (ArrayList list) -> { return list.isEmpty();};
        System.out.println(p1.test(at));
        at.add(34);
        System.out.println(p1.test(at));
        employee e = new employee();
        lambda lb = e:: details;// double colon is use to replace lambda e.details refernce is stored in lb method but both method must have same number of arguments
        lb.show();
        lambda lb1 = employee ::staticdetails;
        lb1.show();
        try{
            fun();
            //code that may raise exception
            int data=100/0;
        }catch(ArithmeticException e4){
            e4.printStackTrace();
        }catch(IllegalAccessException /*| ArithmeticException*/ e8){
            e8.printStackTrace();
        }
        finally {
        //rest code of the program
        System.out.println("rest of the code...");
    }
        ArrayList<Student> al=new ArrayList<>();
        al.add(new Student(101,"Vijay",23));
        al.add(new Student(106,"Ajay",27));
        al.add(new Student(105,"Jai",21));

        Collections.sort(al);
        for(Student st:al){
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }
    public static void str(){
        System.out.println("static method");
    }
    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }
}
