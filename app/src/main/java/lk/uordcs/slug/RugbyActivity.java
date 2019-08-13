package lk.uordcs.slug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.IOError;
        import java.util.List;


import lk.uordcs.slug.AdapterClasses.RugbyFootballAdapter;
import lk.uordcs.slug.AdapterClasses.RugbyFootballAdapter;
import lk.uordcs.slug.REST_Classes.RugbyFootballResults;
import lk.uordcs.slug.REST_Classes.RugbyFootballResults;
import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class RugbyActivity extends AppCompatActivity {


    public RugbyFootballAdapter adapter;
    private List<RugbyFootballResults> resultsList;
    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rugby);

        getSupportActionBar().setTitle("Rugby");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getRugbyFootballResults();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try{
                    if(response.body()!=null){
                        resultsList=(List<RugbyFootballResults>)response.body();
                        adapter = new RugbyFootballAdapter(RugbyActivity.this, resultsList);

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
                Toast.makeText(getApplicationContext(),"No internet connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }
}


