package dasilver.jeong.to_do_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<RecyclerItem> recyclerItems;
    Context recyclerContext;

    public RecyclerViewAdapter(ArrayList itemList) {
        recyclerItems = itemList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo_list, parent, false);
        recyclerContext = parent.getContext();
        RecyclerViewHolder holder = new RecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.memoListText.setText(recyclerItems.get(position).memoListText);
        if(holder.radioBtnDone.isChecked()) {
        }

    }


    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }
}
