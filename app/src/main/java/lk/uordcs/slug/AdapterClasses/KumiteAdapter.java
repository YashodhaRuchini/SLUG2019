package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.KumiteResults;

public class KumiteAdapter extends RecyclerView.Adapter<KumiteAdapter.KumiteViewHolder> {
    private Context mCtx;
    private List<KumiteResults> resultsList;

    public KumiteAdapter(Context mCtx, List<KumiteResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
    }

    public KumiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kumite_result_card, null);
        return new KumiteViewHolder(view);
    }

    public void onBindViewHolder(KumiteViewHolder holder, int position) {
        //getting the product of the specified position
        KumiteResults results = resultsList.get(position);

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
        holder.tvUni1.setText(String.valueOf(results.getUni1()));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvPlayer1.setText(String.valueOf(results.getUni1Player()));
        holder.tvPlayer2.setText(String.valueOf(results.getUni2Player()));
        holder.tvScore1.setText(String.valueOf(results.getUni1Score()));
        holder.tvScore2.setText(String.valueOf(results.getUni2Score()));
        holder.tvWinner.setText(String.valueOf(results.getWinner()+" won the match"));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class KumiteViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni1,tvUni2,tvPlayer1,tvPlayer2,tvScore1,tvScore2,tvWeight,tvDate,tvWinner,tvMatchNo;

        public KumiteViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvWeight=itemView.findViewById(R.id.weight);
            tvUni1=itemView.findViewById(R.id.uni1);
            tvUni2=itemView.findViewById(R.id.uni2);
            tvPlayer1=itemView.findViewById(R.id.playerName1);
            tvPlayer2=itemView.findViewById(R.id.playerName2);
            tvScore1=itemView.findViewById(R.id.score1);
            tvScore2=itemView.findViewById(R.id.score2);
            tvWinner=itemView.findViewById(R.id.winner);

        }
    }
}


