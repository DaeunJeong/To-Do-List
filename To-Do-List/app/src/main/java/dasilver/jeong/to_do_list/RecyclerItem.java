package dasilver.jeong.to_do_list;

import android.widget.RadioButton;

public class RecyclerItem {
    String memoListText;

    public String getMemoListText() {
        return memoListText;
    }

    RecyclerItem(String memoListText) {
        this.memoListText = memoListText;
    }
}
