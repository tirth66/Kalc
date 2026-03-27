import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [EntityName::class], version = 1) // Replace EntityName with actual entity classes
abstract class AppDatabase : RoomDatabase() {
    abstract fun yourDao(): YourDao // Replace YourDao with actual DAO interface

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database" // Change the database name if necessary
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}