package com.example.marmm.animalviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class FoodFragment extends Fragment {
    private static final String ARG_DATA = "data";

    private Food foodfrag;
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static FoodFragment newInstance(Food food) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();

        args.putParcelable(ARG_DATA, food);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodfrag = getArguments().getParcelable("data");
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = rootView.findViewById(R.id.food_name);
        ImageView imageView = rootView.findViewById(R.id.food_image);
        textView.setText(foodfrag.getTitle());
        Glide.with(this)
                .load(foodfrag.getImageUrl())
                .into(imageView);

        return rootView;
    }
}
