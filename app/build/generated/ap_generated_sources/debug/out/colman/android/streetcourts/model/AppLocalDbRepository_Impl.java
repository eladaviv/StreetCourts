package colman.android.streetcourts.model;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppLocalDbRepository_Impl extends AppLocalDbRepository {
  private volatile MemberDao _memberDao;

  private volatile PostDao _postDao;

  private volatile CategoryDao _categoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(11) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Member` (`id` TEXT NOT NULL, `name` TEXT, `phone` TEXT, `address` TEXT, `avatar` TEXT, `updateDate` INTEGER, `isDeleted` INTEGER NOT NULL, `userType` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Post` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `name` TEXT, `area` TEXT, `address` TEXT, `category` TEXT, `image` TEXT, `description` TEXT, `updateDate` INTEGER, `isDeleted` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`userId`) REFERENCES `Member`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`name` TEXT NOT NULL, `isDeleted` INTEGER, `updateDate` INTEGER, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'eb1a16c2d500b0bb7d5eeded663a36a0')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Member`");
        _db.execSQL("DROP TABLE IF EXISTS `Post`");
        _db.execSQL("DROP TABLE IF EXISTS `Category`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMember = new HashMap<String, TableInfo.Column>(8);
        _columnsMember.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("avatar", new TableInfo.Column("avatar", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("updateDate", new TableInfo.Column("updateDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMember.put("userType", new TableInfo.Column("userType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMember = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMember = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMember = new TableInfo("Member", _columnsMember, _foreignKeysMember, _indicesMember);
        final TableInfo _existingMember = TableInfo.read(_db, "Member");
        if (! _infoMember.equals(_existingMember)) {
          return new RoomOpenHelper.ValidationResult(false, "Member(colman.android.streetcourts.model.Member).\n"
                  + " Expected:\n" + _infoMember + "\n"
                  + " Found:\n" + _existingMember);
        }
        final HashMap<String, TableInfo.Column> _columnsPost = new HashMap<String, TableInfo.Column>(10);
        _columnsPost.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("area", new TableInfo.Column("area", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("updateDate", new TableInfo.Column("updateDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPost.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPost = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPost.add(new TableInfo.ForeignKey("Member", "NO ACTION", "NO ACTION",Arrays.asList("userId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPost = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPost = new TableInfo("Post", _columnsPost, _foreignKeysPost, _indicesPost);
        final TableInfo _existingPost = TableInfo.read(_db, "Post");
        if (! _infoPost.equals(_existingPost)) {
          return new RoomOpenHelper.ValidationResult(false, "Post(colman.android.streetcourts.model.Post).\n"
                  + " Expected:\n" + _infoPost + "\n"
                  + " Found:\n" + _existingPost);
        }
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(3);
        _columnsCategory.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("updateDate", new TableInfo.Column("updateDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("Category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(_db, "Category");
        if (! _infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "Category(colman.android.streetcourts.model.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "eb1a16c2d500b0bb7d5eeded663a36a0", "2ace5139bdf6fca0570343a01ccca785");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Member","Post","Category");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Post`");
      _db.execSQL("DELETE FROM `Member`");
      _db.execSQL("DELETE FROM `Category`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MemberDao.class, MemberDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PostDao.class, PostDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MemberDao memberDao() {
    if (_memberDao != null) {
      return _memberDao;
    } else {
      synchronized(this) {
        if(_memberDao == null) {
          _memberDao = new MemberDao_Impl(this);
        }
        return _memberDao;
      }
    }
  }

  @Override
  public PostDao postDao() {
    if (_postDao != null) {
      return _postDao;
    } else {
      synchronized(this) {
        if(_postDao == null) {
          _postDao = new PostDao_Impl(this);
        }
        return _postDao;
      }
    }
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }
}
