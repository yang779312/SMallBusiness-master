package com.liumeng.smallbusiness.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.liumeng.smallbusiness.Commodity;
import com.liumeng.smallbusiness.DaoMaster;

import org.greenrobot.greendao.internal.SqlUtils;

import java.util.Collection;

/**
 * Created by Administrator on 2017/11/22.
 */

public class ShopContentProvider extends ContentProvider {
    private DaoMaster.DevOpenHelper mSqliteHelper;
    private SQLiteDatabase mDatabase;
    private UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private CommodityManager manager;

    private static final int code = 1;

    @Override
    public boolean onCreate() {
        manager = DBUtils.getManager(getContext());
        mUriMatcher.addURI(CourseProviders.AUTHORITIES, CourseProviders.COURSE_PATH, code);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (mUriMatcher.match(uri)) {
            case code:
                String selectAll = "select * from " + manager.getTableName(Commodity.class);
                return manager.getDB().rawQuery(selectAll, null);
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
