package com.example.study.chapter.seven.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    private val createBook = "create table Book(" +
            "id integer primary key autoincrement," +
            "author text, " +
            "price real, pages integer, " +
            "name text)"

    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase) {
        // if data/data/packagename/databases had table, onCreate will not be executed
        db.execSQL(createBook)
        db.execSQL(createCategory)
        Toast.makeText(context, "Create successed", Toast.LENGTH_SHORT).show()
    }

    /**
     * Upgrade databases logic(升级数据库逻辑)
     * In formal development, this operation will cause data loss. The best practice is based on OldVersion add operation.
     * Usage:
     * override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
     *  if (oldVersion <= 1){
     *      db.execSQL(createCategory)
     *   }
     * }
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // create table need delete old table, otherwise error
        db.execSQL("drop table if exists Book")
        db.execSQL("drop table if exists Category")
        onCreate(db)
    }

}