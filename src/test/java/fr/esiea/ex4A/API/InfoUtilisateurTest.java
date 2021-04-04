package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InfoUtilisateurTest {

    @ParameterizedTest
    @CsvSource({
        "Ahmed, Ahmed",
        "Amir, Amir",
        "Filepo, Filepo"
    })
    void creating_a_new_user_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur("",wantedName,"","","","");
        Assertions.assertThat(InfoUtilisateur.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "a@a.com, a@a.com",
        "c@c.pr, c@c.pr",
        "z@gmail.tn, z@gmail.tn"
    })
    void creating_a_new_user_with_an_email_should_give_the_same_email(String wantedValue, String expectedValue){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur(wantedValue, "test", "","","","");
        Assertions.assertThat(InfoUtilisateur.getEmail()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "john, john",
        "Amber, Amber"
    })
    void creating_a_new_user_with_a_count_should_give_the_same_count(String wantedValue, String expectedValue){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur("", "test", wantedValue,"","","");
        Assertions.assertThat(InfoUtilisateur.getTwitter()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "GB, GB",
        "TN, TN",
        "PR, PR"
    })
    void creating_a_new_user_with_a_country_should_give_the_same_country(String wantedValue, String expectedValue){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur(wantedValue, "test", "",wantedValue,"","");
        Assertions.assertThat(InfoUtilisateur.getCountry()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "M, M",
        "F, F"
    })
    void creating_a_new_user_with_a_sex_should_give_the_same(String wantedValue, String expectedValue){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur(wantedValue, "test", "","",wantedValue,"");
        Assertions.assertThat(InfoUtilisateur.getSex()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "F, F",
        "M, M"
    })
    void creating_a_new_user_with_a_sexpref_should_give_the_same(String wantedValue, String expectedValue){
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur("wantedValue", "test", "","","",wantedValue);
        Assertions.assertThat(InfoUtilisateur.getSexPref()).isEqualTo(expectedValue);
    }
}
