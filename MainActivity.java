package com.example.marmm.animalviewpager;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private static ArrayList<Food> topFoods = new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestData();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), topFoods){};
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    private void requestData() {
        Food2ForkAPI service = Food2ForkAPI.retrofit.create(Food2ForkAPI.class);
        Call<FoodList> call = service.getTopFoods();
        call.enqueue(new Callback<FoodList>() {
            @Override
            public void onResponse(@NonNull Call<FoodList> call, @NonNull Response<FoodList> response) {
                Log.d("Give me food pls", "thank you");
                if(response.body() == null){
                    Log.d("THIS IS EMPTY", "SADLY");
                }
                topFoods.addAll(Arrays.asList(response.body().foods));
                    mSectionsPagerAdapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(Call<FoodList> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }

}
