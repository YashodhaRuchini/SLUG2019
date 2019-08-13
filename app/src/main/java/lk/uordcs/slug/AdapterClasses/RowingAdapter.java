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
import lk.uordcs.slug.REST_Classes.RowingResults;
import lk.uordcs.slug.REST_Classes.RowingResults;

public class RowingAdapter extends RecyclerView.Adapter<RowingAdapter.RowingViewHolder> implements Filterable {
    private Context mCtx;
    private List<RowingResults> resultsList;
    private List<RowingResults> resultsListFull;

    public RowingAdapter(Context mCtx, List<RowingResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public RowingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.rowing_result_card, null);
        return new RowingViewHolder(view);
    }

    public void onBindViewHolder(RowingViewHolder holder, int position) {
        //getting the product of the specified position
        RowingResults results = resultsList.get(position);

        //binding the data with the viewholder views

        holder.tvMatchNo.setText(String.valueOf(results.getMatchNo()));
        holder.tvDate.setText(String.valueOf(results.getDate()));
        if(String.valueOf(results.getGender()).equals("M")||String.valueOf(results.getGender()).equals("Men")){
            holder.tvGender.setText("Men's");
        }
        else if(String.valueOf(results.getGender()).equals("W")||String.valueOf(results.getGender()).equals("Women")){
            holder.tvGender.setText("Women's");
        }
        holder.tvUni.setText(String.valueOf(results.getUni()));
        holder.tvCategory.setText(String.valueOf(results.getMatchCategory()));
        holder.tvTime.setText(String.valueOf(results.getFinishTime()));
        holder.tvRank.setText(String.valueOf(results.getRank()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class RowingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory,tvDate,tvUni,tvTime,tvRank,tvGender,tvMatchNo;

        public RowingViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvCategory=itemView.findViewById(R.id.category);
            tvUni=itemView.findViewById(R.id.uni);
            tvRank=itemView.findViewById(R.id.rank);
            tvTime=itemView.findViewById(R.id.finishTime);
            tvGender=itemView.findViewById(R.id.gender);


        }
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }

    private  Filter resultFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RowingResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(RowingResults item:resultsListFull){
                    if(item.getUni().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getDate().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getMatchCategory().toLowerCase().contains(filterPattern)) {
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


