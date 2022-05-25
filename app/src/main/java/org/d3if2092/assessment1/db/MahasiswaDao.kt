package org.d3if2092.assessment1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MahasiswaDao {

    @Insert
    fun insert(mhs: MahasiswaEntity)

    @Query("SELECT * FROM mhs ORDER BY id DESC LIMIT 1")
    fun getLastMhs(): LiveData<MahasiswaEntity>
}