package fr.esiea.ex4A.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class RepositoryAPI {
    final HashMap<String, InfoUtilisateur> userList = new HashMap<>();
    final HashMap<String, AgifyUtilisateur> userListWithAge = new HashMap<>();

    int getNumberOfUsers(){
        return this.userList.size();
    }

    void addNewUser(InfoUtilisateur userInfo, AgifyUtilisateur userDataWithAge){
        this.userList.put(userInfo.getUserId(), userInfo);
        this.userListWithAge.put(userInfo.getUserId(), userDataWithAge);
    }

    boolean seeIfUserExists(InfoUtilisateur userInfo){
        return this.userList.containsKey(userInfo.getUserId());
    }

    InfoUtilisateur getUser(String userName, String countryId){
        return this.userList.get(userName.concat(countryId));
    }

    ArrayList<InfoUtilisateur> matchUser(InfoUtilisateur userInfo){
        ArrayList<InfoUtilisateur> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, AgifyUtilisateur> userEntry : this.userListWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userListWithAge.get(userInfo.getUserId()).getAge()) <= 4){
                InfoUtilisateur possiblyMatchingUser = this.userList.get(userEntry.getValue().getUserId());
                if(possiblyMatchingUser.getSex().equals(userInfo.getSexPref()) && userInfo.getSex().equals(possiblyMatchingUser.getSexPref())) {
                    matchingUsers.add(this.userList.get(userEntry.getValue().getUserId()));
                }
            }
        }
        return matchingUsers;
    }
}
