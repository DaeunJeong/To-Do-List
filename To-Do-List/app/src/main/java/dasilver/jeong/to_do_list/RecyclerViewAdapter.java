package dasilver.jeong.to_do_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static dasilver.jeong.to_do_list.MainActivity.memoPercentText;
import static dasilver.jeong.to_do_list.MainActivity.total;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<RecyclerItem> recyclerItems;
    private int percent;
    public static double count= 0;
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
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {

        holder.memoListText.setText(recyclerItems.get(position).memoListText);

        holder.radioBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.radioBtnDone.isChecked()) {
                    count++;
                    percent = (int) ((count/total)*100);
                    memoPercentText.setText(Integer.toString(percent) + "%");
                } else if(holder.radioBtnDont.isChecked()) {
                    count--;
                    percent = (int) ((count/total)*100);
                    memoPercentText.setText(Integer.toString(percent) + "%");
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }
}
