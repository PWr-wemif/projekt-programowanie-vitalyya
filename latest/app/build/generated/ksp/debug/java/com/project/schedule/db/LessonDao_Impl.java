package com.project.schedule.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.project.schedule.models.Lesson;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LessonDao_Impl implements LessonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Lesson> __insertionAdapterOfLesson;

  private final EntityDeletionOrUpdateAdapter<Lesson> __updateAdapterOfLesson;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLessonById;

  public LessonDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLesson = new EntityInsertionAdapter<Lesson>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `lessons` (`id`,`day_of_week`,`week_even`,`time_start_hours`,`time_start_mins`,`time_end_hours`,`time_end_min`,`name`,`address`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Lesson entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getDayOfWeek());
        statement.bindLong(3, entity.getWeekEven());
        statement.bindLong(4, entity.getTimeStartHours());
        statement.bindLong(5, entity.getTimeStartMins());
        statement.bindLong(6, entity.getTimeEndHours());
        statement.bindLong(7, entity.getTimeEndMin());
        statement.bindString(8, entity.getName());
        statement.bindString(9, entity.getAddress());
      }
    };
    this.__updateAdapterOfLesson = new EntityDeletionOrUpdateAdapter<Lesson>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `lessons` SET `id` = ?,`day_of_week` = ?,`week_even` = ?,`time_start_hours` = ?,`time_start_mins` = ?,`time_end_hours` = ?,`time_end_min` = ?,`name` = ?,`address` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Lesson entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getDayOfWeek());
        statement.bindLong(3, entity.getWeekEven());
        statement.bindLong(4, entity.getTimeStartHours());
        statement.bindLong(5, entity.getTimeStartMins());
        statement.bindLong(6, entity.getTimeEndHours());
        statement.bindLong(7, entity.getTimeEndMin());
        statement.bindString(8, entity.getName());
        statement.bindString(9, entity.getAddress());
        statement.bindLong(10, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteLessonById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM lessons WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertNewLesson(final Lesson lesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLesson.insert(lesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateLesson(final Lesson lesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLesson.handle(lesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLessonById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLessonById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteLessonById.release(_stmt);
    }
  }

  @Override
  public List<Lesson> getLessonByDayAndWeek(final int day, final int weekEven) {
    final String _sql = "SELECT * FROM lessons WHERE day_of_week=? AND week_even = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, day);
    _argIndex = 2;
    _statement.bindLong(_argIndex, weekEven);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDayOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "day_of_week");
      final int _cursorIndexOfWeekEven = CursorUtil.getColumnIndexOrThrow(_cursor, "week_even");
      final int _cursorIndexOfTimeStartHours = CursorUtil.getColumnIndexOrThrow(_cursor, "time_start_hours");
      final int _cursorIndexOfTimeStartMins = CursorUtil.getColumnIndexOrThrow(_cursor, "time_start_mins");
      final int _cursorIndexOfTimeEndHours = CursorUtil.getColumnIndexOrThrow(_cursor, "time_end_hours");
      final int _cursorIndexOfTimeEndMin = CursorUtil.getColumnIndexOrThrow(_cursor, "time_end_min");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final List<Lesson> _result = new ArrayList<Lesson>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Lesson _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final int _tmpDayOfWeek;
        _tmpDayOfWeek = _cursor.getInt(_cursorIndexOfDayOfWeek);
        final int _tmpWeekEven;
        _tmpWeekEven = _cursor.getInt(_cursorIndexOfWeekEven);
        final int _tmpTimeStartHours;
        _tmpTimeStartHours = _cursor.getInt(_cursorIndexOfTimeStartHours);
        final int _tmpTimeStartMins;
        _tmpTimeStartMins = _cursor.getInt(_cursorIndexOfTimeStartMins);
        final int _tmpTimeEndHours;
        _tmpTimeEndHours = _cursor.getInt(_cursorIndexOfTimeEndHours);
        final int _tmpTimeEndMin;
        _tmpTimeEndMin = _cursor.getInt(_cursorIndexOfTimeEndMin);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item = new Lesson(_tmpId,_tmpDayOfWeek,_tmpWeekEven,_tmpTimeStartHours,_tmpTimeStartMins,_tmpTimeEndHours,_tmpTimeEndMin,_tmpName,_tmpAddress);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Lesson getLessonById(final long id) {
    final String _sql = "SELECT * FROM lessons WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDayOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "day_of_week");
      final int _cursorIndexOfWeekEven = CursorUtil.getColumnIndexOrThrow(_cursor, "week_even");
      final int _cursorIndexOfTimeStartHours = CursorUtil.getColumnIndexOrThrow(_cursor, "time_start_hours");
      final int _cursorIndexOfTimeStartMins = CursorUtil.getColumnIndexOrThrow(_cursor, "time_start_mins");
      final int _cursorIndexOfTimeEndHours = CursorUtil.getColumnIndexOrThrow(_cursor, "time_end_hours");
      final int _cursorIndexOfTimeEndMin = CursorUtil.getColumnIndexOrThrow(_cursor, "time_end_min");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final Lesson _result;
      if (_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final int _tmpDayOfWeek;
        _tmpDayOfWeek = _cursor.getInt(_cursorIndexOfDayOfWeek);
        final int _tmpWeekEven;
        _tmpWeekEven = _cursor.getInt(_cursorIndexOfWeekEven);
        final int _tmpTimeStartHours;
        _tmpTimeStartHours = _cursor.getInt(_cursorIndexOfTimeStartHours);
        final int _tmpTimeStartMins;
        _tmpTimeStartMins = _cursor.getInt(_cursorIndexOfTimeStartMins);
        final int _tmpTimeEndHours;
        _tmpTimeEndHours = _cursor.getInt(_cursorIndexOfTimeEndHours);
        final int _tmpTimeEndMin;
        _tmpTimeEndMin = _cursor.getInt(_cursorIndexOfTimeEndMin);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _result = new Lesson(_tmpId,_tmpDayOfWeek,_tmpWeekEven,_tmpTimeStartHours,_tmpTimeStartMins,_tmpTimeEndHours,_tmpTimeEndMin,_tmpName,_tmpAddress);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
