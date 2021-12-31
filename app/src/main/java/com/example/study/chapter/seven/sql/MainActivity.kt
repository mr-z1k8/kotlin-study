package com.example.study.chapter.seven.sql

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.study.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    private lateinit var btn_createdb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)
        val db = dbHelper.writableDatabase

        btn_createdb = findViewById(R.id.btn_createdb)
        btn_createdb.setOnClickListener {
        }

        findViewById<Button>(R.id.btn_add).setOnClickListener {
            val value1 = ContentValues().apply {
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 456)
                put("price", 16.96)
            }
            db.insert("Book", null, value1)
            val value2 = ContentValues().apply {
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, value2)
        }
        findViewById<Button>(R.id.btn_update).setOnClickListener {
            val value = ContentValues()
            value.put("price", 9.99)
            // "?" is placeholder(占位符).
            db.update("Book", value, "name = ?", arrayOf("The Da Vinci Code"))
        }
        findViewById<Button>(R.id.btn_delete).setOnClickListener {
            db.delete("Book", "pages > ?", arrayOf("500"))
        }
        findViewById<Button>(R.id.btn_query).setOnClickListener {
            /**
             * table: 表
             * columns: 某列项
             * selection & selectionArgs: 约束查询某行或某几行的数据
             * groupBy: 指定需要去group by的列，不指定则表示不对查询结果进行group by操作
             * having: 对group by 之后的数据进行进一步过滤
             * orderBy: 指定查询结果的排序方式
             *
             * return cursor: 返回查询信息的对象
             */
            val cursor = db.query("Book", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getString(cursor.getColumnIndex("pages"))
                    val price = cursor.getString(cursor.getColumnIndex("price"))
                    Log.d(TAG, "book name is $name")
                    Log.d(TAG, "book author is $author")
                    Log.d(TAG, "book pages is $pages")
                    Log.d(TAG, "book price is $price")
                } while (cursor.moveToNext())
            }
        }

        /**
         * beginTransaction: sqlite has acdi事务性，保证一系列操作要么全部完成，要么都不完成
         */
        findViewById<Button>(R.id.btn_replace).setOnClickListener {
            db.beginTransaction() // 开启事务
            try {
                db.delete("Book", null, null)
                // 手动抛出异常，让事务失败
                if (true) {
                    throw NullPointerException()
                }
                val values = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "George Martin")
                    put("pages", 720)
                    put("price", 20.85)
                }
                db.insert("Book", null, values)
                db.setTransactionSuccessful() // 事务已经执行成功
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction() // 结束事务
            }
        }
    }

}