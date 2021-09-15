package com.example.odev_7_todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "İsler")
data class İsler(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "is_id")  @NotNull  var is_id:Int,
                 @ColumnInfo(name="is_detay") @NotNull  var is_detay:String):Serializable{

                 }

