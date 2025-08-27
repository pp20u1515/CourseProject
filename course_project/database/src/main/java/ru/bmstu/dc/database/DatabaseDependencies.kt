package ru.bmstu.dc.database

import ru.bmstu.dc.database.db.Database

interface DatabaseDependencies {
    fun provideDatabase(): Database
}