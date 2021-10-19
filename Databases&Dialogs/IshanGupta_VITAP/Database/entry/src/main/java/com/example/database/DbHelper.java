package com.example.database;

import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.rdb.RdbOpenCallback;
import ohos.data.rdb.RdbStore;
import ohos.data.rdb.StoreConfig;

public class DbHelper extends DatabaseHelper {
    public DbHelper(Context context) {
        super(context);
    }

    private static  final RdbOpenCallback callback = new RdbOpenCallback() {
        @Override
        public void onCreate(RdbStore rdbStore) {
            rdbStore.executeSql("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, email TEXT NOT NULL,password TEXT NOT NULL)");
        }

        @Override
        public void onUpgrade(RdbStore rdbStore, int i, int i1) {

        }
    };

    public RdbStore initRdb(Context context) {
        StoreConfig config = StoreConfig.newDefaultConfig("storeUser.db");
        return getRdbStore(config, 1, callback, null);
    }
}
