package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.KataResults;

public class KataAdapter extends RecyclerView.Adapter<KataAdapter.KataViewHolder> {
    private Context mCtx;
    private List<KataResults> resultsList;

    public KataAdapter(Context mCtx, List<KataResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
    }

    public KataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kata_result_card, null);
        return new KataViewHolder(view);
    }

    public void onBindViewHolder(KataViewHolder holder, int position) {
        //getting the product of the specified position
        KataResults results = resultsList.get(position);

        //binding the data with the viewholder views

        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }

        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvWeight.setText(String.valueOf(results.getWeightCategory()));
        if(String.valueOf(results.getTeamIndividual()).equals("I")){
            holder.tvType.setText("Individual");
        }
        else if(String.valueOf(results.getTeamIndividual()).equals("T")){
            holder.tvType.setText("Team");
        }


        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvPName.setText(String.valueOf(results.getPlayerName()));
        holder.tvPoints.setText(String.valueOf(results.getPoints()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class KataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni,tvWeight,tvType,tvPName,tvPoints,tvDate,tvMatchNo;

        public KataViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvUni=itemView.findViewById(R.id.uni);
            tvWeight=itemView.findViewById(R.id.weight);
            tvType=itemView.findViewById(R.id.type);
            tvPName=itemView.findViewById(R.id.playerName);
            tvPoints=itemView.findViewById(R.id.points);
        }
    }
}


