package lk.uordcs.slug;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lk.uordcs.slug.REST_Classes.RoadRace;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoadRaceActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_race);

        getSupportActionBar().setTitle("Road Race");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tableLayout=(TableLayout)findViewById(R.id.tableLayout);
        createColumns();
        fillData();
    }

    private void createColumns(){
        TableRow tableRow=new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        TextView textViewDate=new TextView(this);
        textViewDate.setText("University");
        textViewDate.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewDate.setPadding(5,5,5,0);
        tableRow.addView(textViewDate);

        TextView textViewTime=new TextView(this);
        textViewTime.setText("Player Name");
        textViewTime.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewTime.setPadding(5,5,5,0);
        tableRow.addView(textViewTime);

        TextView textViewTitle=new TextView(this);
        textViewTitle.setText("Time");
        textViewTitle.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewTitle.setPadding(5,5,5,0);
        tableRow.addView(textViewTitle);

        TextView textViewNotice=new TextView(this);
        textViewNotice.setText("Rank");
        textViewNotice.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewNotice.setPadding(5,5,5,0);
        tableRow.addView(textViewNotice);

        tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
    }

    private void onResponseRestful(Call call, Response response){
        List<RoadRace> RoadRaceResults=(List<RoadRace>)response.body();

        for (RoadRace roadRace:RoadRaceResults){
            TableRow tableRow=new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));

            TextView textViewDate=new TextView(this);
            textViewDate.setText(String.valueOf(roadRace.getUni()));
            textViewDate.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
            textViewDate.setPadding(5,5,5,0);
            tableRow.addView(textViewDate);

            TextView textViewTime=new TextView(this);
            textViewTime.setText(String.valueOf(roadRace.getPlayerName()));
            textViewTime.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
            textViewTime.setPadding(5,5,5,0);
            tableRow.addView(textViewTime);

            TextView textViewTitle=new TextView(this);
            textViewTitle.setText(String.valueOf(roadRace.getTime()));
            textViewTitle.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
            textViewTitle.setPadding(5,5,5,0);
            tableRow.addView(textViewTitle);

            TextView textViewNotice=new TextView(this);
            textViewNotice.setText(String.valueOf(roadRace.getRank()));
            textViewNotice.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
            textViewNotice.setPadding(20,20,5,0);
            tableRow.addView(textViewNotice);

            tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));
        }
    }

    public void fillData(){
        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getRoadRaceResults();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                onResponseRestful(call,response);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(),"No connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
