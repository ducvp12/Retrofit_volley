package com.example.asshoanthien.retrofit_volley;

import com.example.asshoanthien.retrofit_volley.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
//http://asian.dotplays.com/wp-json/wp/v2/posts?category=18


public interface PolyService {
    @GET("wp-json/wp/v2/posts")//sau .com va truoc dau ?
    Call<List<Example>> getPostOfCategory(@Query("category") String category);

}
