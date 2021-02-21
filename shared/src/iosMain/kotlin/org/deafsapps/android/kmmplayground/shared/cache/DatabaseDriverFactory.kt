package org.deafsapps.android.kmmplayground.shared.cache

import org.deafsapps.android.kmmplayground.shared.cache.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(AppDatabase.Schema, "test.db")

}
