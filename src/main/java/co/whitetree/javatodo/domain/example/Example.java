package co.whitetree.javatodo.domain.example;

public class Example {
    public static final String KEY = "E";

    private final Long id;

    static {
        System.out.println("초기화 됐어요.");
    }

    public Example(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                '}';
    }
}
