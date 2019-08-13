package lk.uordcs.slug;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment {

    private static final String TAG="Tab1fragment";
    CardView basketball,badminton,carrom,volleyball,netball,ttennis,karate,taekwondo,wrestling,weightLifting,swimming,chess;
   @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1_fragment,container,false);

       basketball=(CardView)view.findViewById(R.id.Basketball);
       basketball.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),BasketballActivity.class);
               startActivity(intent);
           }
       });

       carrom=(CardView)view.findViewById(R.id.Carrom);
       carrom.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),CarromActivity.class);
               startActivity(intent);
           }
       });

       netball=(CardView)view.findViewById(R.id.Netball);
       netball.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),NetballActivity.class);
               startActivity(intent);
           }
       });


       ttennis=(CardView)view.findViewById(R.id.tabletennis);
       ttennis.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),TTennisActivity.class);
               startActivity(intent);
           }
       });
       volleyball=(CardView)view.findViewById(R.id.volleyball);
       volleyball.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),VolleyballActivity.class);
               startActivity(intent);
           }
       });

       badminton=(CardView)view.findViewById(R.id.Badminton);
       badminton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),BadmintonActivity.class);
               startActivity(intent);
           }
       });

       swimming=(CardView)view.findViewById(R.id.Swimming);
       swimming.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),SwimmingActivity.class);
               startActivity(intent);
           }
       });
       taekwondo=(CardView)view.findViewById(R.id.taekwondo);
       taekwondo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),TaekwondoActivity.class);
               startActivity(intent);
           }
       });

       wrestling=(CardView)view.findViewById(R.id.wrestling);
       wrestling.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),WrestlingActivity.class);
               startActivity(intent);
           }
       });

       weightLifting=(CardView)view.findViewById(R.id.weightlifting);
       weightLifting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),WeightliftingActivity.class);
               startActivity(intent);
           }
       });
       karate=(CardView)view.findViewById(R.id.Karate);
       karate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),KarateActivity.class);
               startActivity(intent);
           }
       });
       chess=(CardView)view.findViewById(R.id.Chess);
       chess.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),ChessActivity.class);
               startActivity(intent);
           }
       });


       return view;
    }
}

