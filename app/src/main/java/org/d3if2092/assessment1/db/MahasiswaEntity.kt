package org.d3if2092.assessment1.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mhs")
data class MahasiswaEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var nama: String,
    var nim: String,
    var kelas: String
)