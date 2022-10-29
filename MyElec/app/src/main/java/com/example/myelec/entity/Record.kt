package com.example.myelec.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Record(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="Date") val recordDate: Date?,
    @ColumnInfo(name = "Day_Index") val dayIndex: Double?,
    @ColumnInfo(name = "Night_Index") val nightIndex: Double?,
    @ColumnInfo(name = "Night_Index") val productionIndex: Double?
)
