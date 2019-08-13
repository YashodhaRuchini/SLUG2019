package lk.uordcs.slug;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class KarateActivity extends AppCompatActivity {

    private static final String TAG="KarateActivity";
    private SectionsPagerAdapter mSelectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karate);

        getSupportActionBar().setTitle("Karate");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG,"OnCreate:String");

        mSelectionsPageAdapter=new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        SetupViewPager(mViewPager);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void SetupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter=new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new KataFragment(),"Kata");
        adapter.addFragment(new KumiteFragment(),"Kumite");
        viewPager.setAdapter(adapter);
    }
}