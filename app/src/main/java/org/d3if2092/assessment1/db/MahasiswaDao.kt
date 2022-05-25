package org.d3if2092.assessment1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.d3if2092.assessment1.Mahasiswa

@Dao
interface MahasiswaDao {

    @Insert
    fun insertData(mahasiswa: Mahasiswa)
}