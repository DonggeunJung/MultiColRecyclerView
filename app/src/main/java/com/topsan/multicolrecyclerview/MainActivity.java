package com.topsan.multicolrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BaseRvAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);

        List<String> data = new ArrayList<>();
        for(int i=1; i <= 100; i++) {
            String text = "" + i;
            data.add(text);
        }

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColums = 4;
        adapter = new MyRecyclerViewAdapter(this, (Object)data);
        adapter.setLayoutManager(recyclerView, numberOfColums);
        adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        tv.setText(position + " - " + adapter.getItem(position).toString());
    }
}