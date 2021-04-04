package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class PickupRepositoryTest {
    private final RepositoryAPI pickupRepository = new RepositoryAPI();

    @Test
    void having_no_users_should_return_no_users(){
        Assertions.assertThat(pickupRepository.getNumberOfUsers()).isEqualTo(0);
    }

    @Test
    void adding_a_user_to_repository_increments_number_of_users(){
        InfoUtilisateur userInfo = new InfoUtilisateur("test", "test", "test", "test", "test", "test");
        AgifyUtilisateur AgifyUtilisateur = new AgifyUtilisateur("test", 50, 500, "US");
        pickupRepository.addNewUser(userInfo, AgifyUtilisateur);
        Assertions.assertThat(pickupRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users(){
        InfoUtilisateur userData1 = new InfoUtilisateur("t1", "te1", "tes1", "test1", "test1", "test1");
        InfoUtilisateur userData2 = new InfoUtilisateur("t2", "te2", "tes2", "test2", "test2", "test2");
        InfoUtilisateur userData3 = new InfoUtilisateur("t3", "te3", "tes3", "test3", "test3", "test3");
        InfoUtilisateur userData4 = new InfoUtilisateur("t4", "te4", "tes4", "test4", "test4", "test4");
        AgifyUtilisateur agifyUser1 = new AgifyUtilisateur("t", 50, 500, "FR");
        AgifyUtilisateur agifyUser2 = new AgifyUtilisateur("te", 52, 500, "DE");
        AgifyUtilisateur agifyUser3 = new AgifyUtilisateur("tes", 53, 500, "GB");
        AgifyUtilisateur agifyUser4 = new AgifyUtilisateur("test", 54, 500, "ES");
        pickupRepository.addNewUser(userData1, agifyUser1);
        pickupRepository.addNewUser(userData2, agifyUser2);
        pickupRepository.addNewUser(userData3, agifyUser3);
        pickupRepository.addNewUser(userData4, agifyUser4);
        Assertions.assertThat(pickupRepository.getNumberOfUsers()).isEqualTo(4);
        Assertions.assertThat(4).isEqualTo(4);
    }
}
