package com.example.colordetect.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.colordetect.R;
import com.example.colordetect.adapter.DataAdapter;
import com.example.colordetect.component.DataItem;
import com.example.colordetect.listener.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private DataAdapter dataAdapter;
    private DataItem dataItem;
    private List<DataItem> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        clickData();
        prepareData();
    }

    //==============================================================================================
    private void clickData() {
        recyclerView = (RecyclerView) findViewById(R.id._item_data);
        dataAdapter = new DataAdapter(itemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dataAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                dataItem = itemList.get(position);
                Toast.makeText(getApplicationContext(), "mengunduh data print "+dataItem.getNo_responden(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                dataItem = itemList.get(position);
                Toast.makeText(getApplicationContext(), dataItem.getNo_responden() + " terpilih!", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //==============================================================================================
    private void prepareData() {
        itemList.add(new DataItem("0821", "One", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0822", "Two", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0823", "Three", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0824", "Four", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0825", "Five", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0826", "Six", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0827", "Seven", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0828", "Eight", R.drawable.ic_photo_camera));
        itemList.add(new DataItem("0829", "Nine", R.drawable.ic_photo_camera));
    }

    //==============================================================================================
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    //==============================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_data, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id._action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dataAdapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                dataAdapter.getFilter().filter(query);
                return false;
            }
        });
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
        } else if (id == R.id._action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
