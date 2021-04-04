package fr.esiea.ex4A.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyUtilisateur {

    public final String userId;
    public final String name;
    public final Integer age;
    public final Integer Counter;
    public final String countryId;

    public AgifyUtilisateur(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("count") int count, @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.Counter = count;
        this.countryId = country_id;
        this.userId = name.concat(country_id);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCounter() {
        return Counter;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getUserId(){ return this.userId; }

}
