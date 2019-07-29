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

    private List<DataComponent> __dataList = new ArrayList<>();
    private RecyclerView __recyclerView;
    private DataAdapter __dataAdapter;
    private DataComponent __dataComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        __recyclerView = (RecyclerView) findViewById(R.id._item_data);
        __dataAdapter = new DataAdapter(__dataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        __recyclerView.setHasFixedSize(true);
        __recyclerView.setLayoutManager(mLayoutManager);
        __recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        __recyclerView.setItemAnimator(new DefaultItemAnimator());
        __recyclerView.setAdapter(__dataAdapter);

        __recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), __recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                __dataComponent = __dataList.get(position);
                Toast.makeText(getApplicationContext(), __dataComponent.getNo_responden() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareData();
    }

    //==============================================================================================
    private void prepareData() {
        __dataComponent = new DataComponent("0811234567890", "Arya Rezza", R.drawable.ic_photo_camera);
        __dataList.add(__dataComponent);

        __dataComponent = new DataComponent("0811234567890", "H. Praditia", R.drawable.ic_photo_camera);
        __dataList.add(__dataComponent);

        __dataComponent = new DataComponent("0811234567890", "Didik Maulana", R.drawable.ic_photo_camera);
        __dataList.add(__dataComponent);

        __dataComponent = new DataComponent("0811234567890", "Zidni Ridwan", R.drawable.ic_photo_camera);
        __dataList.add(__dataComponent);

        __dataComponent = new DataComponent("0811234567890", "Prabowo S.", R.drawable.ic_photo_camera);
        __dataList.add(__dataComponent);

        __dataAdapter.notifyDataSetChanged();
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
