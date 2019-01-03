package com.example.marmm.animalviewpager;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit userguide at
 * https://square.github.io/retrofit/
 * More usage information at
 * https://guides.codepath.com/android/consuming-apis-with-retrofit
 */
public interface Food2ForkAPI {
    String BASE_URL = "https://www.food2fork.com/api/";

    Retrofit retrofit = new Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())

            .build();

    @GET("search?key=f74d54252aab2161007ed81880fa55d0&sort=r")

    Call<FoodList> getTopFoods();

}
