package com.pj.PratyushAssignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> implements Filterable {

    ArrayList<ItemClass> mlist;
    ArrayList<ItemClass> FullList;


    public  static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, price, rank, date, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            rank = itemView.findViewById(R.id.rank);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
        }
    }


    public itemAdapter(ArrayList<ItemClass> ilist){
        mlist = ilist;
        FullList = new ArrayList<>(mlist);
    }



    @NonNull
    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_layout,parent,false);
    ViewHolder vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.ViewHolder holder, int position) {
    ItemClass itemcurr =mlist.get(position);

    holder.name.setText("name: " + itemcurr.getName());
    holder.price.setText("price: " + itemcurr.getPrice());
    holder.rank.setText("rank: " + itemcurr.getRank());
    holder.date.setText("date: " + itemcurr.getDate());
    holder.status.setText("status: " + itemcurr.getStatus());


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public itemAdapter(){

    }




    @Override
    public Filter getFilter() {

        return exampleFilter;
    }



     Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ItemClass> filteredList = new ArrayList<>();
            if( charSequence == null || charSequence.length()==0){
                filteredList.addAll(FullList);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(ItemClass items: FullList){
                    if(items.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(items);
                    }
                }
            }

            FilterResults res = new FilterResults();
            res.values = filteredList;
            return res;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mlist.clear();
            mlist.addAll((Collection<? extends ItemClass>) filterResults.values);
            notifyDataSetChanged();
        }
    };

}
