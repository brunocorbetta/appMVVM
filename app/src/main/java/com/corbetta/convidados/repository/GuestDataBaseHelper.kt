package com.corbetta.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import com.corbetta.convidados.model.GuestModel


@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBaseHelper : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var INSTANCE: GuestDataBaseHelper

        fun guestDataBase(context: Context): GuestDataBaseHelper {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDataBaseHelper::class) {
                    INSTANCE = databaseBuilder(context, GuestDataBaseHelper::class.java, "guestdb")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }
        }
    }
}


