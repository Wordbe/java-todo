package co.whitetree.javatodo.domain.example;

public class ExampleMain {
    public static void main(String[] args) {
        String key = Example.KEY;
        System.out.println("key = " + key);

        Example example = new Example(1L);
        System.out.println(example);

//        boolean same = "abc" == "abc";
    }
}
