package colman.android.streetcourts.model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MemberDao_Impl implements MemberDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Member> __insertionAdapterOfMember;

  private final EntityDeletionOrUpdateAdapter<Member> __deletionAdapterOfMember;

  public MemberDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMember = new EntityInsertionAdapter<Member>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Member` (`id`,`name`,`phone`,`address`,`avatar`,`updateDate`,`isDeleted`,`userType`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Member value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getAvatar() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAvatar());
        }
        if (value.getUpdateDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUpdateDate());
        }
        final int _tmp = value.isDeleted() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getUserType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserType());
        }
      }
    };
    this.__deletionAdapterOfMember = new EntityDeletionOrUpdateAdapter<Member>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Member` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Member value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insertAll(final Member... members) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMember.insert(members);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Member member) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMember.handle(member);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Member> getAllMembers() {
    final String _sql = "select * from Member";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar");
      final int _cursorIndexOfUpdateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "updateDate");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfUserType = CursorUtil.getColumnIndexOrThrow(_cursor, "userType");
      final List<Member> _result = new ArrayList<Member>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Member _item;
        _item = new Member();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _item.setPhone(_tmpPhone);
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final String _tmpAvatar;
        if (_cursor.isNull(_cursorIndexOfAvatar)) {
          _tmpAvatar = null;
        } else {
          _tmpAvatar = _cursor.getString(_cursorIndexOfAvatar);
        }
        _item.setAvatar(_tmpAvatar);
        final Long _tmpUpdateDate;
        if (_cursor.isNull(_cursorIndexOfUpdateDate)) {
          _tmpUpdateDate = null;
        } else {
          _tmpUpdateDate = _cursor.getLong(_cursorIndexOfUpdateDate);
        }
        _item.setUpdateDate(_tmpUpdateDate);
        final boolean _tmpIsDeleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp != 0;
        _item.setDeleted(_tmpIsDeleted);
        final String _tmpUserType;
        if (_cursor.isNull(_cursorIndexOfUserType)) {
          _tmpUserType = null;
        } else {
          _tmpUserType = _cursor.getString(_cursorIndexOfUserType);
        }
        _item.setUserType(_tmpUserType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Member getMemberById(final String sid) {
    final String _sql = "select * from Member where id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar");
      final int _cursorIndexOfUpdateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "updateDate");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
      final int _cursorIndexOfUserType = CursorUtil.getColumnIndexOrThrow(_cursor, "userType");
      final Member _result;
      if(_cursor.moveToFirst()) {
        _result = new Member();
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _result.setPhone(_tmpPhone);
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _result.setAddress(_tmpAddress);
        final String _tmpAvatar;
        if (_cursor.isNull(_cursorIndexOfAvatar)) {
          _tmpAvatar = null;
        } else {
          _tmpAvatar = _cursor.getString(_cursorIndexOfAvatar);
        }
        _result.setAvatar(_tmpAvatar);
        final Long _tmpUpdateDate;
        if (_cursor.isNull(_cursorIndexOfUpdateDate)) {
          _tmpUpdateDate = null;
        } else {
          _tmpUpdateDate = _cursor.getLong(_cursorIndexOfUpdateDate);
        }
        _result.setUpdateDate(_tmpUpdateDate);
        final boolean _tmpIsDeleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp != 0;
        _result.setDeleted(_tmpIsDeleted);
        final String _tmpUserType;
        if (_cursor.isNull(_cursorIndexOfUserType)) {
          _tmpUserType = null;
        } else {
          _tmpUserType = _cursor.getString(_cursorIndexOfUserType);
        }
        _result.setUserType(_tmpUserType);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
