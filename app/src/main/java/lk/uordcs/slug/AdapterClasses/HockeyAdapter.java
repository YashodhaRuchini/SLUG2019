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
import lk.uordcs.slug.REST_Classes.HockeyResults;
import lk.uordcs.slug.REST_Classes.HockeyResults;

public class HockeyAdapter extends RecyclerView.Adapter<HockeyAdapter.HockeyViewHolder> implements Filterable {
    private Context mCtx;
    private List<HockeyResults> resultsList;
    private List<HockeyResults> resultsListFull;

    public HockeyAdapter(Context mCtx, List<HockeyResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public HockeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.result_card_volleyball_netball_badminton_tt, null);
        return new HockeyViewHolder(view);
    }

    public void onBindViewHolder(HockeyViewHolder holder, int position) {
        //getting the product of the specified position
        HockeyResults results = resultsList.get(position);

        //binding the data with the viewholder views
        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvRound.setText(String.valueOf(results.getRound()));
        if(String.valueOf(results.getGender()).equals("M")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")){
            holder.tvGender.setText("Women's");
        }

        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvUni1.setText(String.valueOf(results.getUni1()));
        holder.tvUni1Wins.setText(String.valueOf(results.getUni1Score()));
        holder.tvUni2.setText(String.valueOf(results.getUni2()));
        holder.tvUni2Wins.setText(String.valueOf(results.getUni2Score()));
        holder.tvResult.setText(String.valueOf(results.getWinner()+" won the match"));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class HockeyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvGender,tvUni1,tvUni2,tvUni1Wins,tvUni2Wins,tvResult,tvDate,tvMatchNo;

        public HockeyViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvGender=itemView.findViewById(R.id.gender);
            tvUni1=itemView.findViewById(R.id.uni1);
            tvUni1Wins=itemView.findViewById(R.id.uni1Wins);
            tvUni2=itemView.findViewById(R.id.uni2);
            tvUni2Wins=itemView.findViewById(R.id.uni2Wins);
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
            List<HockeyResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(HockeyResults item:resultsListFull){
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
                    else if(item.getGender().toLowerCase().contains(filterPattern)) {
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


