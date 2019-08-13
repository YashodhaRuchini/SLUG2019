package lk.uordcs.slug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOError;
import java.util.List;


import lk.uordcs.slug.AdapterClasses.RunningAdapter;
import lk.uordcs.slug.REST_Classes.RunningResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RunningHundredActivity extends AppCompatActivity {


    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getRunningResults();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try{
                    if(response.body()!=null){
                        List<RunningResults> resultsList=(List<RunningResults>)response.body();
                        RunningAdapter adapter = new RunningAdapter(RunningHundredActivity.this, resultsList);

                        recyclerView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No results found...",Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOError error){
                    error.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}


