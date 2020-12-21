package com.book.govdatafr.networkUtils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.book.govdatafr.departmentDetail.local.DepartmentDetailDao;
import com.book.govdatafr.departmentList.local.DepartmentListDao;
import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.models.DepartmentModel;

@Database(version = 1, entities = {DepartmentModel.class, DepartmentDetail.class},exportSchema = false)
public abstract class DatabaseHolder extends RoomDatabase {
    private static DatabaseHolder INSTANCE;

    // access department list DAO
    public abstract DepartmentListDao departmentListDao();

    //access department details DAO
    public abstract DepartmentDetailDao departmentDetailDao();

    /**
     * Get singleton database instance
     * @param context
     * @return DatabaseHolder
     */
    public static DatabaseHolder getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseHolder.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), DatabaseHolder.class, "gov_fr_database")
                                    // allow queries on the main thread.
                                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                                    .allowMainThreadQueries()
                                    .fallbackToDestructiveMigration()
                                    .build();
                }
            }

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
