package co.whitetree.javatodo.domain.disease;

public enum Disease {
    CODE1(1L, "소화불량"),
    CODE2(2L, "구토"),
    CODE3(3L, "사마귀");

    private final Long id;
    private final String name;

    Disease(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
