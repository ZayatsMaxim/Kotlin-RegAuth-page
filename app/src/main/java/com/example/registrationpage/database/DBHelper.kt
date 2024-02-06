package com.example.registrationpage.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.registrationpage.user.User
import com.example.registrationpage.utils.PasswordHasher

class DBHelper(private val context: Context, private val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "appDB", factory, 1) {

    private val passwordHasher = PasswordHasher()

    override fun onCreate(database: SQLiteDatabase?) {
        val query = "CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT UNIQUE," +
                "email TEXT," +
                "pass TEXT)"

        database!!.execSQL(query)
    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
        database!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(database)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", passwordHasher.hashPassword(user.password))

        val database = this.writableDatabase
        database.insert("users", null, values)
        database.close()
    }

    fun authUser(login: String, password: String): Boolean {
        val database = this.readableDatabase

        val result = database.rawQuery("SELECT * FROM users WHERE login = '$login'", null)
        if(result.moveToFirst()) {
            val passwordFromDB = result.getString(result.getColumnIndexOrThrow("pass"))
            return passwordHasher.checkPassword(password, passwordFromDB)
        }

        return false
    }
}