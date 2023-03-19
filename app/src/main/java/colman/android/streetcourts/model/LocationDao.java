package colman.android.streetcourts.model;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("select * from GeoLocation")
    List<GeoLocation> getAllLocations();
}
