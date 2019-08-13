package lk.uordcs.slug.AdapterClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import lk.uordcs.slug.R;
import lk.uordcs.slug.REST_Classes.CricketResults;
import lk.uordcs.slug.REST_Classes.CricketResults;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.CricketViewHolder> implements Filterable {
    private Context mCtx;
    private List<CricketResults> resultsList;
    private List<CricketResults> resultsListFull;

    public CricketAdapter(Context mCtx, List<CricketResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public CricketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cricket_result_card, null);
        return new CricketViewHolder(view);
    }

    public void onBindViewHolder(CricketViewHolder holder, int position) {
        //getting the product of the specified position
        CricketResults results = resultsList.get(position);

        //binding the data with the viewholder views
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvRound.setText(String.valueOf(results.getRound()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvUni1.setText(String.valueOf(results.getUni1()));
        holder.tvUni1Score.setText(String.valueOf(results.getUni1Score()+"/"));
        holder.tvUni1Overs.setText(String.valueOf(results.getUni1Overs()));
        holder.tvUni1Wickets.setText(String.valueOf(results.getUni1Wickets()));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvUni2Score.setText(String.valueOf(results.getUni2Score()+"/"));
        holder.tvUni2Overs.setText(String.valueOf(results.getUni2Overs()));
        holder.tvUni2Wickets.setText(String.valueOf(results.getUni2Wickets()));
        holder.tvResult.setText(String.valueOf(results.getResultDescription()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class CricketViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvUni1,tvUni2,tvUni1Score,tvUni2Score,tvResult,tvDate,tvUni1Overs,tvUni2Overs,tvUni1Wickets,tvUni2Wickets,tvMatchNo;

        public CricketViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvUni1=itemView.findViewById(R.id.uni1);
            tvUni1Score=itemView.findViewById(R.id.uni1Score);
            tvUni1Overs=itemView.findViewById(R.id.uni1Overs);
            tvUni1Wickets=itemView.findViewById(R.id.uni1Wickets);
            tvUni2=itemView.findViewById(R.id.uni2);
            tvUni2Score=itemView.findViewById(R.id.uni2Score);
            tvUni2Wickets=itemView.findViewById(R.id.uni2Wickets);
            tvUni2Overs=itemView.findViewById(R.id.uni2Overs);
            tvResult=itemView.findViewById(R.id.result);
        }
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }

    private  Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CricketResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(CricketResults item:resultsListFull){
                    if(item.getUni1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getUni2().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getDate().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getRound().toLowerCase().contains(filterPattern)) {
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


