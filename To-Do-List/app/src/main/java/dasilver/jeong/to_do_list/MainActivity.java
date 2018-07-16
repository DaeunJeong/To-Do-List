package dasilver.jeong.to_do_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView)findViewById(R.id.recycler_main_memo_list);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        final ArrayList<RecyclerItem>recyclerItems = new ArrayList();

        FloatingActionButton addMemoBtn = (FloatingActionButton)findViewById(R.id.btn_add_memo);
        final EditText memoListEdit = (EditText)findViewById(R.id.edit_main_memo);
        TextView memoPercentText = (TextView)findViewById(R.id.text_memo_percent);

        addMemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItems.add(new RecyclerItem(memoListEdit.getText().toString()));
            }
        });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerAdapter = new RecyclerViewAdapter(recyclerItems);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
