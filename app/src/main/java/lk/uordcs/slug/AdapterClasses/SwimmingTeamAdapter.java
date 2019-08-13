package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.SwimmingTeamResults;

public class SwimmingTeamAdapter extends RecyclerView.Adapter<SwimmingTeamAdapter.SwimmingTeamViewHolder> {
    private Context mCtx;
    private List<SwimmingTeamResults> resultsList;

    public SwimmingTeamAdapter(Context mCtx, List<SwimmingTeamResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
    }

    public SwimmingTeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.swimming_result_card, null);
        return new SwimmingTeamViewHolder(view);
    }

    public void onBindViewHolder(SwimmingTeamViewHolder holder, int position) {
        //getting the product of the specified position
        SwimmingTeamResults results = resultsList.get(position);

        //binding the data with the viewholder views

        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvEvent.setText(String.valueOf(results.getEvent()));
        holder.tvFinishTime.setText(String.valueOf(results.getFinishTime()));
        holder.tvRank.setText(String.valueOf(results.getRank()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class SwimmingTeamViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMatchNo,tvDate,tvUni,tvGender,tvEvent,tvRound,tvRank,tvFinishTime;

        public SwimmingTeamViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvEvent=itemView.findViewById(R.id.event);
            tvUni=itemView.findViewById(R.id.uni);
            tvRank=itemView.findViewById(R.id.rank);
            tvGender=itemView.findViewById(R.id.gender);
            tvRound=itemView.findViewById(R.id.round);
            tvFinishTime=itemView.findViewById(R.id.finishTime);



        }
    }
}


