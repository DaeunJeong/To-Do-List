package dasilver.jeong.to_do_list;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import static dasilver.jeong.to_do_list.MainActivity.count;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView memoListText;
    public RadioButton radioBtnDone, radioBtnDont;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        memoListText = (TextView)itemView.findViewById(R.id.text_memo_list);
        radioBtnDone = (RadioButton)itemView.findViewById(R.id.radiobtn_done);
        radioBtnDont = (RadioButton)itemView.findViewById(R.id.radiobtn_dont);
    }
}
