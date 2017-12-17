package com.liumeng.smallbusiness.db;

import android.content.Context;

/**
 * Created by Administrator on 2017/11/13.
 */

public class DBUtils {
    private static CommodityManager commodityManager;

    public static CommodityManager getManager(Context context) {
        if (commodityManager == null) {
            synchronized (DBUtils.class) {
                if (commodityManager == null) {
                    commodityManager = new CommodityManager(context);
                }
            }
        }
        return commodityManager;

    }
}
