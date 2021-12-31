package com.example.study.chapter.eight.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.study.chapter.seven.sql.MyDatabaseHelper

class DatabseProvider : ContentProvider() {

    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "com.example.study.chapter.eight.provider"
    private var dbHelper: MyDatabaseHelper? = null

    private val matcher: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)


    init {
        matcher.addURI(authority, "book", bookDir)
        matcher.addURI(authority, "book/#", bookItem)
        matcher.addURI(authority, "category", categoryDir)
        matcher.addURI(authority, "category/#", categoryItem)
    }


    /**
     * Simplify Usage:
     * override fun onCreate() = context?.let {
     *  dbHelper = MyDatabaseHelper(it, "BookStore.db", 2)
     *  true
     * } ?: false
     */
    override fun onCreate(): Boolean {
        if (context != null) {
            dbHelper = MyDatabaseHelper(context!!, "BookStore.db", 2)
            return true
        }
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ) = dbHelper?.let {
        val db = it.readableDatabase
        val cursor = when (matcher.match(uri)) {
            bookDir -> {
                db.query("Book", projection, selection, selectionArgs, null, null, sortOrder)
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.query("Book", projection, "id = ?", arrayOf(bookId), null, null, sortOrder)
            }
            categoryDir -> {
                db.query("Category", projection, selection, selectionArgs, null, null, sortOrder)
            }
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.query(
                    "Category",
                    projection,
                    "id = ?",
                    arrayOf(categoryId),
                    null,
                    null,
                    sortOrder
                )
            }
            else -> {
                null
            }
        }
        cursor
    }

    override fun getType(uri: Uri) = when (matcher.match(uri)) {
        bookDir -> "vnd.android.cursor.dir/vnd.com.example.study.chapter.eight.provider.book"
        bookItem -> "vnd.android.cursor.item/vnd.com.example.study.chapter.eight.provider.book"
        categoryDir -> "vnd.android.cursor.dir/vnd.com.example.study.chapter.eight.provider.category"
        categoryItem -> "vnd.android.cursor.item/vnd.com.example.study.chapter.eight.provider.category"
        else -> null
    }

    override fun insert(uri: Uri, contentValues: ContentValues?) = dbHelper?.let {
        val db = it.readableDatabase
        val uriReturn = when (matcher.match(uri)) {
            bookDir, bookItem -> {
                val newBookId = db.insert("Book", null, contentValues)
                Uri.parse("content://$authority/book/$newBookId")
            }
            categoryDir, categoryItem -> {
                val newCategoryId = db.insert("Category", null, contentValues)
                Uri.parse("content://$authority/category/$newCategoryId")
            }
            else -> null
        }
        uriReturn
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) =
        dbHelper?.let {
            val db = it.readableDatabase
            val deletedRows = when (matcher.match(uri)) {
                bookDir -> db.delete("Book", selection, selectionArgs)
                bookItem -> {
                    val bookId = uri.pathSegments[1]
                    db.delete("Book", "id = ?", arrayOf(bookId))
                }
                categoryDir -> db.delete("Category", selection, selectionArgs)
                categoryItem -> {
                    val categoryId = uri.pathSegments[1]
                    db.delete("Category", "id = ?", arrayOf(categoryId))
                }
                else -> 0
            }
            deletedRows
        } ?: 0

    override fun update(
        uri: Uri,
        contentValues: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ) = dbHelper?.let {
        val db = it.readableDatabase
        val updateRows = when (matcher.match(uri)) {
            bookDir -> {
                db.update("Book", contentValues, selection, selectionArgs)
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.update("Book", contentValues, "id = ?", arrayOf(bookId))
            }
            categoryDir -> {
                db.update("Category", contentValues, selection, selectionArgs)
            }
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.update("Category", contentValues, "id = ?", arrayOf(categoryId))
            }
            else -> 0
        }
        updateRows
    } ?: 0
}