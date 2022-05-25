package org.d3if2092.assessment1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MahasiswaEntity::class], version = 1, exportSchema = false)
abstract class MahasiswaDb : RoomDatabase() {

    abstract val dao: MahasiswaDao

    companion object {
        @Volatile
        private var INSTANCE: MahasiswaDb? = null

        fun getInstance(context: Context): MahasiswaDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MahasiswaDb::class.java,
                        "bmi.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}