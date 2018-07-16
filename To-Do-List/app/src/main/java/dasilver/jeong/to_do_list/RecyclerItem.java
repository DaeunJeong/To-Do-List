package dasilver.jeong.to_do_list;

import android.widget.RadioButton;

public class RecyclerItem {
    String memoListText;
    RadioButton radioBtnDone;

    public String getMemoListText() {
        return memoListText;
    }

    public RadioButton getRadioBtnDone() {
        return radioBtnDone;
    }

    RecyclerItem(String memoListText) {
        this.memoListText = memoListText;
    }
}
