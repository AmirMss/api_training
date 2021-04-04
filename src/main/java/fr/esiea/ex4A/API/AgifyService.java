package fr.esiea.ex4A.API;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final RepositoryAPI pickupRepository = new RepositoryAPI();

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void addUser(InfoUtilisateur user) throws IOException {
        AgifyUtilisateur agifyUser;
        if(!pickupRepository.seeIfUserExists(user)){
            agifyUser = this.agifyClient.getUserAge(user.name, user.country).execute().body();
            pickupRepository.addNewUser(user, agifyUser);
        }
    }

    public ArrayList<InfoUtilisateur> matchUser(String userName, String userCountry){
        InfoUtilisateur userRequestingMatch = pickupRepository.getUser(userName, userCountry);
        if(userRequestingMatch != null){
            return pickupRepository.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }
}
