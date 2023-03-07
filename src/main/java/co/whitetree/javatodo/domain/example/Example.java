package co.whitetree.javatodo.domain.example;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Example example)) return false;
        return Objects.equals(id, example.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
