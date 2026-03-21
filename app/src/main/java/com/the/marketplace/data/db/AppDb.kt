package com.the.marketplace.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CartEntity::class], version = 3, exportSchema = false)

abstract class AppDb: RoomDatabase() {

    abstract fun userDao(): CartDao


}