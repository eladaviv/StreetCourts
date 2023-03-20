package colman.android.streetcourts.model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import colman.android.streetcourts.MyApplication;

@Database(entities = {Member.class, Post.class, Category.class}, version = 17)
@TypeConverters({GeoPointConverter.class})
abstract class AppLocalDbRepository extends RoomDatabase {
    public abstract MemberDao memberDao();

    public abstract PostDao postDao();

    public abstract CategoryDao categoryDao();
}

public class AppLocalDb {
    static public AppLocalDbRepository db =
            Room.databaseBuilder(MyApplication.getContext(),
                    AppLocalDbRepository.class,
                    "MembersDb.db")
                    .fallbackToDestructiveMigration()
                    .build();
}
