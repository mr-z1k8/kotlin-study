package com.example.databasetest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.contentValuesOf

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    private var bookId: String? = null
    private val content = "content://com.example.study.chapter.eight.provider/book"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_add).setOnClickListener {
            val uri = Uri.parse(content)
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin",
                "pages" to 1040,
                "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }
        findViewById<Button>(R.id.btn_query).setOnClickListener {
            val uri = Uri.parse(content)
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val pages = getInt(getColumnIndex("pages"))
                    val price = getDouble(getColumnIndex("price"))
                    Log.d(TAG, "book name is $name")
                    Log.d(TAG, "book author is $author")
                    Log.d(TAG, "book pages is $pages")
                    Log.d(TAG, "book price is $price")
                }
            }
        }
        findViewById<Button>(R.id.btn_update).setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("$content/$it")
                val values = contentValuesOf(
                    "name" to "A Storm of Swords",
                    "pages" to 1216,
                    "price" to 24.05
                )
                contentResolver.update(uri, values, null, null)
            }
        }
        findViewById<Button>(R.id.btn_delete).setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("$content/$it")
                contentResolver.delete(uri, null, null)
            }
        }
    }
}