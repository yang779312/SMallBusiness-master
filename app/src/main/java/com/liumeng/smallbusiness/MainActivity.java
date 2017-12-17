package com.liumeng.smallbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liumeng.smallbusiness.db.CommodityManager;
import com.liumeng.smallbusiness.db.DBUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.OnItemClickListener {

    private RecyclerView rvShop;
    private ShopListAdapter shopListAdapter;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        shopListAdapter = new ShopListAdapter(R.layout.item_shop);
        btnAdd = findViewById(R.id.add);
        rvShop = findViewById(R.id.rv_shop);
        rvShop.setAdapter(shopListAdapter);
        rvShop.setLayoutManager(new LinearLayoutManager(this));
        shopListAdapter.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        checkDB();
    }

    private void checkDB() {
        CommodityManager manager = DBUtils.getManager(this);
        List<Commodity> commodities = manager.QueryAll(Commodity.class);
        if (commodities != null && !commodities.isEmpty()) {
            updateList(commodities);
        }
    }

    private void updateList(List<Commodity> commodities) {
        if (shopListAdapter != null) {
            shopListAdapter.setNewData(commodities);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                startActivity(new Intent(this, AddActivity.class));
                break;
            case R.id.update:

                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Commodity o = (Commodity) adapter.getData().get(position);
        Long id = o.getId();
        startEdit(id);
    }


    private void startEdit(Long id) {
        Intent intent = new Intent();
        intent.putExtra("edit", true);
        intent.putExtra("id", id);
        intent.setClass(this, AddActivity.class);
        startActivity(intent);
    }

}
