package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.IndividualPoomsaeResults;

public class IndividualPoomsaeAdapter extends RecyclerView.Adapter<IndividualPoomsaeAdapter.IndividualPoomsaeViewHolder> {
    private Context mCtx;
    private List<IndividualPoomsaeResults> resultsList;

    public IndividualPoomsaeAdapter(Context mCtx, List<IndividualPoomsaeResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
    }

    public IndividualPoomsaeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.poomsae_result_card, null);
        return new IndividualPoomsaeViewHolder(view);
    }

    public void onBindViewHolder(IndividualPoomsaeViewHolder holder, int position) {
        //getting the product of the specified position
        IndividualPoomsaeResults results = resultsList.get(position);

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
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvPName.setText(String.valueOf(results.getPlayerName()));
        holder.tvPoints.setText(String.valueOf(results.getPoints()));
        holder.tvRank.setText(String.valueOf(results.getRank()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class IndividualPoomsaeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni,tvPName,tvPoints,tvDate,tvMatchNo,tvRank;

        public IndividualPoomsaeViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvUni=itemView.findViewById(R.id.uni);
            tvRank=itemView.findViewById(R.id.rank);
            tvPName=itemView.findViewById(R.id.playerName);
            tvPoints=itemView.findViewById(R.id.points);
        }
    }
}


