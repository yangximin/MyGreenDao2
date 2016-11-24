package com.yang.mygreendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yang.mygreendao.bean.User;
import com.yang.mygreendao.dao.DaoMaster;
import com.yang.mygreendao.dao.DaoSession;

/**
 * Created by YXM
 * on 2016/11/24.
 */

public class DBManager {

    private final static String DB_NAME = "yang_db";

    private static DBManager mInstance;

    private Context mContext;

    private DaoMaster.DevOpenHelper mOpenHelper;

    public DBManager() {
    }

    public DBManager(Context context) {
        mContext = context;
        mOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
    }

    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }

            }
        }
        return mInstance;
    }

    private SQLiteDatabase getWritableDatabase() {
        if (mOpenHelper == null) {
            mOpenHelper = new DaoMaster.DevOpenHelper(mContext, DB_NAME, null);
        }
        return mOpenHelper.getWritableDatabase();
    }

    public void insertUser(User user)
    {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession session = daoMaster.newSession();

    }
}
