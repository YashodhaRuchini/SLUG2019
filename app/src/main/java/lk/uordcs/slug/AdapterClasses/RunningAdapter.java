package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.RunningResults;

public class RunningAdapter extends RecyclerView.Adapter<RunningAdapter.RunningViewHolder> implements Filterable {
    private Context mCtx;
    private List<RunningResults> resultsList;

    private List<RunningResults> resultsListFull;

//    RunningAdapter(List<RunningResults> resultsList){
//        this.resultsList=resultsList;
//
//    }


    public RunningAdapter(Context mCtx, List<RunningResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);

    }

    public RunningViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.running_result_card, null);
        return new RunningViewHolder(view);
    }

    public void onBindViewHolder(RunningViewHolder holder, int position) {
        //getting the product of the specified position
        RunningResults results = resultsList.get(position);

        //binding the data with the viewholder views

        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvPlayer.setText(String.valueOf(results.getPlayerName()));
        holder.tvTime.setText(String.valueOf(results.getFinishTime()));
        holder.tvRank.setText(String.valueOf(results.getRank()));
        holder.tvCategory.setText(String.valueOf(results.getEvent()));


    }

    public int getItemCount() {
        return resultsList.size();
    }



    class RunningViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvDate,tvUni,tvPlayer,tvTime,tvRank,tvGender,tvCategory,tvMatchNo;

        public RunningViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvUni=itemView.findViewById(R.id.uni);
            tvPlayer=itemView.findViewById(R.id.playerName);
            tvRank=itemView.findViewById(R.id.rank);
            tvTime=itemView.findViewById(R.id.finishTime);
            tvGender=itemView.findViewById(R.id.gender);
            tvCategory=itemView.findViewById(R.id.category);

        }
    }
    @Override
    public Filter getFilter() {
        return resultFilter;
    }

    private  Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RunningResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(RunningResults item:resultsListFull){
                    if(item.getUni().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getDate().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getRound().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getEvent().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            resultsList.clear();
            resultsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}


