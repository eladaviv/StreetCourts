package colman.android.streetcourts.model;

import androidx.room.TypeConverter;

import com.google.firebase.firestore.GeoPoint;

public class GeoPointConverter {
    @TypeConverter
    public static GeoPoint toGeoPoint(String value) {
        if (value == null) {
            return null;
        }

        String[] parts = value.split(",");
        double lat = Double.parseDouble(parts[0]);
        double lng = Double.parseDouble(parts[1]);
        GeoPoint geoPoint = new GeoPoint(lat, lng);
        return geoPoint;
    }

    @TypeConverter
    public static String toString(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }

        return geoPoint.getLatitude() + "," + geoPoint.getLongitude();
    }
}