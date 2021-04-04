package fr.esiea.ex4A.API;

import fr.esiea.ex4A.API.AgifyClient;
import fr.esiea.ex4A.API.AgifyService;
import fr.esiea.ex4A.API.InfoUtilisateur;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

class AgifyServiceTest {



    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }

    AgifyClient mockAgifyClient = agifyClient();

    AgifyService agifyService = new AgifyService(mockAgifyClient);

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        InfoUtilisateur InfoUtilisateur = new InfoUtilisateur("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(InfoUtilisateur);
        Assertions.assertThat(agifyService.pickupRepository.userList.get("MarlonUS")).isEqualTo(InfoUtilisateur);
        Assertions.assertThat(agifyService.pickupRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users() throws IOException {
        InfoUtilisateur userInfo1 = new InfoUtilisateur("henri@mail.fr", "Henri", "bHenri", "FR", "M", "M");
        InfoUtilisateur userInfo2 = new InfoUtilisateur("juan@movistar.es", "Juan", "juanjuan", "ES", "M", "F");
        InfoUtilisateur userInfo3 = new InfoUtilisateur("elena@mail.ru", "Elena", "elenaaa", "RU", "F", "F");
        InfoUtilisateur userInfo4 = new InfoUtilisateur("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userInfo1);
        agifyService.addUser(userInfo2);
        agifyService.addUser(userInfo3);
        agifyService.addUser(userInfo4);
        Assertions.assertThat(agifyService.pickupRepository.userList.get("HenriFR")).isEqualTo(userInfo1);
        Assertions.assertThat(agifyService.pickupRepository.userList.get("JuanES")).isEqualTo(userInfo2);
        Assertions.assertThat(agifyService.pickupRepository.userList.get("ElenaRU")).isEqualTo(userInfo3);
        Assertions.assertThat(agifyService.pickupRepository.userList.get("MarlonUS")).isEqualTo(userInfo4);
        Assertions.assertThat(agifyService.pickupRepository.getNumberOfUsers()).isEqualTo(4);
    }
}
