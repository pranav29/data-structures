package dataStructures;

class Employee {
    private static int id; 

    static {
        id = 1;
    }

    public static int getId(){
        return id;
    }
}

public class StaticTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        System.out.println(emp1.getId());
        System.out.println(emp2.getId());
        
        int a = 10;
        Object o = a;
        int b = (int)o;
        System.out.println(b);
    }
}

