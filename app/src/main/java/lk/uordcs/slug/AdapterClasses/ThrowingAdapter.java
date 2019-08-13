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
import lk.uordcs.slug.REST_Classes.ThrowingResults;
import lk.uordcs.slug.REST_Classes.ThrowingResults;



public class ThrowingAdapter  extends RecyclerView.Adapter<ThrowingAdapter.ThrowingViewHolder> implements Filterable {
    private Context mCtx;
    private List<ThrowingResults> resultsList;
    private List<ThrowingResults> resultsListFull;

    public ThrowingAdapter(Context mCtx, List<ThrowingResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public ThrowingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.throwing_result_card, null);
        return new ThrowingViewHolder(view);
    }

    public void onBindViewHolder(ThrowingViewHolder holder, int position) {
        //getting the product of the specified position
        ThrowingResults results = resultsList.get(position);

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
        holder.tvDistance.setText(String.valueOf(results.getDistance()));
        holder.tvRank.setText(String.valueOf(results.getRank()));
        holder.tvEvent.setText(String.valueOf(results.getEvent()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class ThrowingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvDate,tvUni,tvPlayer,tvDistance,tvRank,tvGender,tvEvent,tvMatchNo;

        public ThrowingViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvUni=itemView.findViewById(R.id.uni);
            tvPlayer=itemView.findViewById(R.id.playerName);
            tvEvent=itemView.findViewById(R.id.event);
            tvRank=itemView.findViewById(R.id.rank);
            tvDistance=itemView.findViewById(R.id.distance);
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
            List<ThrowingResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(ThrowingResults item:resultsListFull){
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