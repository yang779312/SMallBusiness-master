package com.liumeng.smallbusiness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.liumeng.smallbusiness.db.CommodityManager;
import com.liumeng.smallbusiness.db.DBUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etId;
    private EditText etName;
    private EditText etTitle;
    private EditText etPrice;
    private EditText etQuantifier;
    private EditText etReserve;
    private EditText etSales;
    private EditText etImageUrl;
    private long newId;
    private Button btnAdd;
    private Button btnRem;
    private CommodityManager manager;
    private EditText etDes;
    private EditText etDetail;
    private boolean edit;
    private Long id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);
        if (getIntent() != null) {
            edit = getIntent().getBooleanExtra("edit", false);
            id = getIntent().getLongExtra("id", -1);
        }
        initView();
        initData();
    }

    private void initData() {
        checkDb();
        if (edit) {
            Commodity commodity = manager.QueryById(id, Commodity.class);
            etId.setText(commodity.getId() + "");
            etName.setText(commodity.getName() + "");
            etTitle.setText(commodity.getTitle() + "");
            etPrice.setText(commodity.getPrice() + "");
            etQuantifier.setText(commodity.getQuantifier() + "");
            etReserve.setText(commodity.getReserve() + "");
            etSales.setText(commodity.getSales() + "");
            etImageUrl.setText(commodity.getImgUrl() + "");
            etDes.setText(commodity.getDes() + "");
            etDetail.setText(commodity.getDes() + "");
        } else {
            etId.setText(newId + "");
        }
    }

    private void checkDb() {
        manager = DBUtils.getManager(this);
        List<Commodity> commodities = manager.QueryAll(Commodity.class);
        if (commodities != null && !commodities.isEmpty()) {
            newId = commodities.get(commodities.size() - 1).getId() + 1;
        }
    }

    private void initView() {
        etId = findViewById(R.id.id);
        etName = findViewById(R.id.name);
        etTitle = findViewById(R.id.title);
        etPrice = findViewById(R.id.price);
        etQuantifier = findViewById(R.id.quantifier);
        etReserve = findViewById(R.id.reserve);
        etSales = findViewById(R.id.sales);
        etImageUrl = findViewById(R.id.imgUrl);
        etDes = findViewById(R.id.des);
        etDetail = findViewById(R.id.detail);

        btnAdd = findViewById(R.id.add);
        btnRem = findViewById(R.id.remove);
        if (edit) btnRem.setVisibility(View.VISIBLE);
        else btnRem.setVisibility(View.GONE);
        btnRem.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            if (etNotNull(etId, etName, etTitle, etPrice, etPrice, etQuantifier, etReserve, etSales, etImageUrl, etDes)) {

                Commodity commodity = new Commodity();
                commodity.setId(Long.parseLong(getText(etId)));
                commodity.setName(getText(etName));
                commodity.setTitle(getText(etTitle));
                commodity.setPrice(Double.parseDouble(getText(etPrice)));
                commodity.setQuantifier(getText(etName));
                commodity.setReserve(Integer.parseInt(getText(etReserve)));
                commodity.setSales(Integer.parseInt(getText(etSales)));
                commodity.setImgUrl(getText(etImageUrl));
                commodity.setDes(getText(etDes));
                commodity.setDetail(getText(etDetail));

                if (edit) {
                    manager.updateObject(commodity);
                    Toast.makeText(this, "更改成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    if (manager.insertObj(commodity)) {
                        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } else {
            manager.deleteObjectById(id);
            finish();
        }

    }

    private String getText(EditText editText) {
        if (editText == null) return "0";

        return editText.getText().toString();
    }

    public boolean etNotNull(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getText() == null || editText.getText().toString().isEmpty()) {
                editText.requestFocus();
                editText.setError("这个也得填写");
                return false;
            }
        }
        return true;
    }
}
