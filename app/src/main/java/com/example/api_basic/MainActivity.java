package com.example.api_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageView imageView;
    GridView gridView;
    public String cap;
    public String cap1;
    String empurl[];
    String empname[];
    TextView name;

    int capnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        name= findViewById(R.id.text);
        imageView=findViewById(R.id.image);
        Call<List<Employee>> call = api.getemployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> emp = response.body();
                String[] empurl = new String[emp.size()];
                String[] empname = new String[emp.size()];
                for (int i = 0; i < emp.size(); i++) {
                    empname[i] = emp.get(i).getFirstname();
                    empurl[i] = emp.get(i).getLastname();

                }
                for (int i = 0; i < emp.size(); i++) {
                    if (empname[i].equalsIgnoreCase("Iron Man")) {
                        capnum = i;
                        cap = empurl[capnum];
                        cap1=empname[capnum];

                    }

                }

                Glide.with(getApplicationContext()).load(cap).into(imageView);
                name.setText(cap1);

            }


            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}