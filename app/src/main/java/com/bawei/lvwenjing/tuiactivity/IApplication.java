package com.bawei.lvwenjing.tuiactivity;

import android.app.Application;
import android.os.Environment;
import android.util.Config;


import com.bawei.lvwenjing.tuiactivity.newsdrag.db.SQLHelper;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by muhanxi on 17/5/1.
 */
//

public class IApplication extends Application {


    private static IApplication mAppApplication;
    private SQLHelper sqlHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        mAppApplication = this ;




        getDaoConfig();



    }

    public  static DbManager.DaoConfig daoConfig;
    public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null){
            daoConfig=new DbManager.DaoConfig()
                    .setDbVersion(1)
                    .setDbName("tt")//设置数据库的名字
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });
        }
        return daoConfig;
    }

    /** 获取Application */
    public static IApplication getApp() {
        return mAppApplication;
    }

    /** 获取数据库Helper */
    public SQLHelper getSQLHelper() {
        if (sqlHelper == null)
            sqlHelper = new SQLHelper(mAppApplication);
        return sqlHelper;
    }

    /** 摧毁应用进程时候调用 */
    public void onTerminate() {
        if (sqlHelper != null)
            sqlHelper.close();
        super.onTerminate();
    }

    public void clearAppCache() {
    }


}
