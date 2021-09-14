package com.example.odev_7_todo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.odev_7_todo.İsler


@Database(entities = [İsler::class],version = 1)
 abstract class VeriTabani:RoomDatabase()
{
     abstract fun islerDao():IslerDao

     companion object{
         var INSTANCE:VeriTabani?=null
         fun veritabaniErişim(context: Context):VeriTabani? {

             if(INSTANCE==null){

                 synchronized(VeriTabani::class){
                     INSTANCE= Room.databaseBuilder(context.applicationContext,
                         VeriTabani::class.java,
                         "todo.sqlite").createFromAsset("todo.sqlite").build()

                 }
             }

             return INSTANCE

         }


     }


}