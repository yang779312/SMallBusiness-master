package com.liumeng.smallbusiness;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.awt.font.TextAttribute;

/**
 * Created by Administrator on 2017/11/21.
 */

public class ShopListAdapter extends BaseQuickAdapter<Commodity, BaseViewHolder> {
    public ShopListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity item) {
        helper.setText(R.id.shop_id, item.getId() + "")
                .setText(R.id.shop_title, item.getTitle())
                .setText(R.id.shop_des, item.getDes());
        View view = helper.getView(R.id.imageView);

        Glide.with(mContext)
                .load(item.getImgUrl())
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into((ImageView) view);
    }
}
