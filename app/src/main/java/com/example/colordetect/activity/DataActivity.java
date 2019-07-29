package com.example.colordetect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.colordetect.R;
import com.example.colordetect.adapter.DataAdapter;
import com.example.colordetect.component.DataComponent;
import com.example.colordetect.listener.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private List<DataComponent> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    private DataComponent dataComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id._item_data);
        mAdapter = new DataAdapter(mList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                dataComponent = mList.get(position);
                Toast.makeText(getApplicationContext(), dataComponent.getNo_responden() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareData();
    }

    //==============================================================================================
    private void prepareData() {
        dataComponent = new DataComponent("0811234567890", "Arya Rezza", R.drawable.ic_photo_camera);
        mList.add(dataComponent);

        dataComponent = new DataComponent("0811234567890", "H. Praditia", R.drawable.ic_photo_camera);
        mList.add(dataComponent);

        dataComponent = new DataComponent("0811234567890", "Didik Maulana", R.drawable.ic_photo_camera);
        mList.add(dataComponent);

        dataComponent = new DataComponent("0811234567890", "Zidni Ridwan", R.drawable.ic_photo_camera);
        mList.add(dataComponent);

        dataComponent = new DataComponent("0811234567890", "Prabowo S.", R.drawable.ic_photo_camera);
        mList.add(dataComponent);

        mAdapter.notifyDataSetChanged();
    }

    //==============================================================================================
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //==============================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id._action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
