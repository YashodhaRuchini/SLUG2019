package lk.uordcs.slug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class TrackAndFieldActivity extends AppCompatActivity {

    CardView running,hurdles,relay,highjump,polevault,longjump,triplejump,shotput,discusthrow,javelinthrow,discus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_track_and_field);

        getSupportActionBar().setTitle("Track and Field");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        running=(CardView)findViewById(R.id.running);
        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this,NewRunningActivity.class);
                startActivity(intent);
            }
        });

        relay=(CardView)findViewById(R.id.Relay);
        relay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this,RelayActivity.class);
                startActivity(intent);
            }
        });

        highjump=(CardView)findViewById(R.id.highjump);
        highjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, HighJumpActivity.class);
                startActivity(intent);
            }
        });

        polevault=(CardView)findViewById(R.id.Polevault);
        polevault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, PoleVaultActivity.class);
                startActivity(intent);
            }
        });

        longjump=(CardView)findViewById(R.id.LongJump);
        longjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, LongJumpActivity.class);
                startActivity(intent);
            }
        });

        triplejump=(CardView)findViewById(R.id.tripleJump);
        triplejump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, TripleJumpActivity.class);
                startActivity(intent);
            }
        });

        shotput=(CardView)findViewById(R.id.Shotput);
        shotput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, ShotPutActivity.class);
                startActivity(intent);
            }
        });

        discusthrow=(CardView)findViewById(R.id.Discusthrow);
        discusthrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, DiscusThrowActivity.class);
                startActivity(intent);
            }
        });

        javelinthrow=(CardView)findViewById(R.id.JavelinThrow);
        javelinthrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this, JavelinThrowActivity.class);
                startActivity(intent);
            }
        });

        hurdles=(CardView)findViewById(R.id.Hurdles);
        hurdles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrackAndFieldActivity.this,HurdlesActivity.class);
                startActivity(intent);
            }
        });

    }
}
