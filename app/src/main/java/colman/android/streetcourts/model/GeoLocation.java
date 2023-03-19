package colman.android.streetcourts.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;

import java.util.HashMap;
import java.util.Map;

@Entity(foreignKeys = {@ForeignKey(entity = Post.class,
        parentColumns = "id", childColumns = "PostId"),
        @ForeignKey(entity = Member.class, parentColumns = "id",
                childColumns = "UserId")})
public class GeoLocation {
    public static final String COLLECTION_NAME = "Locations";

    @PrimaryKey
    @NonNull
    String id;

    @NonNull
    String PostId;

    @NonNull
    String UserId;
    String name;
    double lat;
    double lng;

    Long updateDate = new Long(0);
    boolean isDeleted;

    // Empty constructor
    public GeoLocation() {
    }

    public GeoLocation(@NonNull String id, @NonNull String postId, String UserId, String name, double lat, double lng) {
        this.id = id;
        PostId = postId;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.UserId = UserId;
        this.isDeleted = false;
    }

    // Clone constructor
    public GeoLocation(GeoLocation loc)
    {
        this.id = loc.id;
        this.PostId = loc.PostId;
        this.UserId = loc.UserId;
        this.name = loc.name;
        this.lat = loc.lat;;
        this.lng = loc.lng;
        this.isDeleted = loc.isDeleted;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getPostId() {
        return PostId;
    }

    public void setPostId(@NonNull String postId) {
        PostId = postId;
    }

    @NonNull
    public String getUserId() {
        return UserId;
    }

    public void setUserId(@NonNull String userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public GeoLocation create(Map<String, Object> json) {
        String id = (String) json.get("id");
        String postId = (String) json.get("postId");
        String userId = (String) json.get("UserId");
        String name = (String) json.get("name");
        double lat = (double) json.get("lat");
        double lng = (double) json.get("lng");
        Timestamp time = (Timestamp) json.get("UpdateDate");
        long updated = time.getSeconds();
        boolean isDeleted = (boolean) json.get("isDeleted");
        GeoLocation loc = new GeoLocation(id, postId, userId, name, lat, lng);
        loc.setDeleted(isDeleted);
        loc.setUpdateDate(updated);
        return loc;
    }

    public Map<String, Object> toJson()
    {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("id", this.id);
        json.put("postId", this.PostId);
        json.put("UserId", this.UserId);
        json.put("name", this.name);
        json.put("lat", this.lat);
        json.put("lng", this.lng);
        json.put("UpdateDate", FieldValue.serverTimestamp());
        json.put("isDeleted", this.isDeleted);
        return json;
    }
}
