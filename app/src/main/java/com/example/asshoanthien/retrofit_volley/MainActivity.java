package com.example.asshoanthien.retrofit_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asshoanthien.retrofit_volley.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadPostOfcategory(View view) {
        PolyService polyService=PolyRetrofit.getinsteance().create(PolyService.class);
        polyService.getPostOfCategory("18").enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
           if (response.code()==200) {
               Log.e("data", response.code() + "");//http code
               Log.e("size",response.body().size()+"");
           }

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e("loi",t.getMessage());
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://asian.dotplays.com/wp-json/wp/v2/posts?category=18";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
               new com.android.volley.Response.Listener<String> (){
                   @Override
                   public void onResponse(String response) {
                       Log.e("datavolley", response);
                   }
               },
               new com.android.volley.Response.ErrorListener(){

                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
