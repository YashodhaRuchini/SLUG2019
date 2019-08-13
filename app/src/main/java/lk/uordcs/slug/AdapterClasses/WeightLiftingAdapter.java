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
import lk.uordcs.slug.REST_Classes.WeightLiftingResults;
import lk.uordcs.slug.REST_Classes.WeightLiftingResults;

public class WeightLiftingAdapter extends RecyclerView.Adapter<WeightLiftingAdapter.WeightLiftingViewHolder> implements Filterable {
    private Context mCtx;
    private List<WeightLiftingResults> resultsList;
    private List<WeightLiftingResults> resultsListFull;

    public WeightLiftingAdapter(Context mCtx, List<WeightLiftingResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public WeightLiftingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.weight_lifting_result_card, null);
        return new WeightLiftingViewHolder(view);
    }

    public void onBindViewHolder(WeightLiftingViewHolder holder, int position) {
        //getting the product of the specified position
        WeightLiftingResults results = resultsList.get(position);

        //binding the data with the viewholder views


        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        holder.tvWeight.setText(String.valueOf(results.getWeightCategory()));
        if(String.valueOf(results.getGender()).equals("M")||String.valueOf(results.getGender()).equals("Men")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")||String.valueOf(results.getGender()).equals("Women")){
            holder.tvGender.setText("Women's");
        }
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvPlayer.setText(String.valueOf(results.getPlayerName()));
        holder.tvSnatch.setText(String.valueOf(results.getSnatch()));
        holder.tvCleanAndJerk.setText(String.valueOf(results.getCleanAndJerk()));
        holder.tvTotal.setText(String.valueOf(results.getTotal()));
        holder.tvRank.setText(String.valueOf(results.getRank()));


    }

    public int getItemCount() {
        return resultsList.size();
    }

    class WeightLiftingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvGender,tvUni,tvPlayer,tvSnatch,tvCleanAndJerk,tvTotal,tvWeight,tvDate,tvRank,tvMatchNo;

        public WeightLiftingViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvWeight=itemView.findViewById(R.id.weight);
            tvUni=itemView.findViewById(R.id.uni);
            tvPlayer=itemView.findViewById(R.id.playerName);
            tvGender=itemView.findViewById(R.id.gender);
            tvSnatch=itemView.findViewById(R.id.snatch);
            tvCleanAndJerk=itemView.findViewById(R.id.cleanAndJerk);
            tvTotal=itemView.findViewById(R.id.total);
            tvRank=itemView.findViewById(R.id.rank);

        }
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }

    private  Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<WeightLiftingResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(WeightLiftingResults item:resultsListFull){
                    if(item.getUni().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getDate().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getWeightCategory().toLowerCase().contains(filterPattern)) {
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


