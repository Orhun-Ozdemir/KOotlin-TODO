package com.example.odev_7_todo.room

import androidx.room.*
import com.example.odev_7_todo.İsler

@Dao
interface IslerDao
{

    @Query("Select * from İsler")
    suspend fun tumIsler():List<İsler>

    @Query("Select *from İsler Where is_detay like '%' || :arananKelimesi || '%'")
    suspend fun isAra(arananKelimesi:String):List<İsler>

    @Update
    suspend fun isGuncelle(isler: İsler)
    @Insert
    suspend fun isEkle(isler:İsler)
    @Delete
    suspend fun isSil(isler:İsler)

}