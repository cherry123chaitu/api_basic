package com.example.api_basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
   public String cap;
   String empurl[];
   String empname[];
    TextView t;
    int capnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api= retrofit.create(Api.class);
        t=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
        Call<List<Employee>> call= api.getemployee();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
            List<Employee> emp= response.body();
                String [] empurl= new String[emp.size()];
                String [] empname = new String[emp.size()];
                for(int i=0;i<emp.size();i++){
                    empname[i]=emp.get(i).getFirstname();
                  empurl[i]=emp.get(i).getLastname();

                }
                for(int i=0;i<emp.size();i++){
                    if(empname[i].equalsIgnoreCase("Captain America"))
                    {
                    capnum=i;
                    cap=empurl[capnum];
                    break;
                    }

                }
                Log.d("url",cap);
                Glide.with(getApplicationContext()).load(cap).into(imageView);

            }


            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
