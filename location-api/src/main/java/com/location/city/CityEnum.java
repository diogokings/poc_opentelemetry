package com.location.city;

public enum CityEnum {

    SAO_PAULO(1L, "SP", "São Paulo"),
    PORTO_ALEGRE(2L, "RS", "Porto Alegre"),
    FLORIANOPOLIS(3L, "SC", "Florianópolis"),
    CURITIBA(4L, "PR", "Curitiba");

    private Long id;
    private String state;
    private String name;

    private CityEnum(Long id, String state, String name) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public static CityEnum getById(Long cityId) {
        for (CityEnum x : CityEnum.values()) {
            if (cityId.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + cityId);
    }

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
