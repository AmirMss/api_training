package fr.esiea.ex4A.API;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUtilisateurTest {


    @ParameterizedTest
    @CsvSource({
        "Ahmed, Ahmed",
        "Amir, Amir",
        "Filepo, Filepo"
    })
    void creating_a_new_agifyuser_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur(wantedName, 10, 10, "US");
        Assertions.assertThat(agifyUser.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "44, 44",
        "56, 56",
        "49, 49"
    })
    void creating_a_new_agifyuser_with_an_age_should_give_the_same_age(int wantedAge, int expectedAge){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur("test", wantedAge, 10, "US");
        Assertions.assertThat(agifyUser.getAge()).isEqualTo(expectedAge);
    }

    @ParameterizedTest
    @CsvSource({
        "1477, 1477",
        "569, 569",
        "4049, 4049"
    })
    void creating_a_new_agifyuser_with_a_count_should_give_the_same_count(int wantedCount, int expectedCount){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur("test", 10, wantedCount, "US");
        Assertions.assertThat(agifyUser.getCounter()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
        "GB, GB",
        "TN, TN",
        "PR, PR"
    })
    void creating_a_new_agifyuser_with_a_country_should_give_the_same_country(String wantedCountry, String expectedCountry){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur("test", 10, 100, wantedCountry);
        Assertions.assertThat(agifyUser.getCountryId()).isEqualTo(expectedCountry);
    }
}
