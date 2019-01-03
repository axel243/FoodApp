package com.example.marmm.animalviewpager;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food implements Parcelable {

    @SerializedName("title")
    @Expose
    private String food_title;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;


    public Food (String food_title, String imageUrl){
        this.food_title = food_title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return food_title;
    }

    public void setTitle(String food_title) {
        this.food_title = food_title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.food_title);
        dest.writeString(this.imageUrl);
    }

    public Food(Parcel in) {
        this.food_title = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

}

