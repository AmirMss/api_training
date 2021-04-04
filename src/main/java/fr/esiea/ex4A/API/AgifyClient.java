package fr.esiea.ex4A.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUtilisateur> getUserAge(@Query("name") String userName, @Query("country_id") String userCountry);
}
