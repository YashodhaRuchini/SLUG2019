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
import lk.uordcs.slug.REST_Classes.JumpingResults;
import lk.uordcs.slug.REST_Classes.RunningResults;


public class JumpingAdapter  extends RecyclerView.Adapter<JumpingAdapter.JumpingViewHolder> implements Filterable {
    private Context mCtx;
    private List<JumpingResults> resultsList;
    private List<JumpingResults> resultsListFull;

    public JumpingAdapter(Context mCtx, List<JumpingResults> resultsList) {
        this.mCtx = mCtx;
        this.resultsList = resultsList;
        resultsListFull=new ArrayList<>(resultsList);
    }

    public JumpingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.jumping_result_card, null);
        return new JumpingViewHolder(view);
    }

    public void onBindViewHolder(JumpingViewHolder holder, int position) {
        //getting the product of the specified position
        JumpingResults results = resultsList.get(position);

        //binding the data with the viewholder views
        holder.tvRound.setText(String.valueOf(results.getRound()));

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
        holder.tvheight.setText(String.valueOf(results.getHeightDistance()));
        holder.tvRank.setText(String.valueOf(results.getRank()));
        holder.tvEvent.setText(String.valueOf(results.getEvent()));

    }

    public int getItemCount() {
        return resultsList.size();
    }

    class JumpingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRound,tvDate,tvUni,tvPlayer,tvheight,tvRank,tvGender,tvEvent,tvMatchNo;

        public JumpingViewHolder(View itemView) {
            super(itemView);

            tvMatchNo=itemView.findViewById(R.id.matchNo);
            tvDate=itemView.findViewById(R.id.date);
            tvRound=itemView.findViewById(R.id.round);
            tvUni=itemView.findViewById(R.id.uni);
            tvPlayer=itemView.findViewById(R.id.playerName);
            tvEvent=itemView.findViewById(R.id.event);
            tvRank=itemView.findViewById(R.id.rank);
            tvheight=itemView.findViewById(R.id.height);
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
            List<JumpingResults> filteredList=new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(resultsListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();

                for(JumpingResults item:resultsListFull){
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


