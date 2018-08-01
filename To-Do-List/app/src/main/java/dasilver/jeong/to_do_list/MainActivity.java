package dasilver.jeong.to_do_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static dasilver.jeong.to_do_list.RecyclerViewAdapter.count;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerAdapter;
    private FloatingActionButton addMemoBtn;
    private EditText memoListEdit;
    public static TextView memoPercentText;
    public static double total;
    private int percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_main_memo_list);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        final ArrayList<RecyclerItem> recyclerItems = new ArrayList();
        total = 0;

        addMemoBtn = (FloatingActionButton) findViewById(R.id.btn_add_memo);
        memoListEdit = (EditText) findViewById(R.id.edit_main_memo);
        memoPercentText = (TextView) findViewById(R.id.text_memo_percent);

        addMemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memoListEdit.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "메모를 작성하여 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    recyclerItems.add(new RecyclerItem(memoListEdit.getText().toString()));
                    total++;
                    recyclerAdapter.notifyDataSetChanged();
                    memoListEdit.setText(" ");
                    if (count == 0) {
                        memoPercentText.setText("0%");
                    } else {
                        percent = (int) ((count / total) * 100);
                        memoPercentText.setText(Integer.toString(percent) + "%");
                    }
                }
            }
        });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerAdapter = new RecyclerViewAdapter(recyclerItems);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
