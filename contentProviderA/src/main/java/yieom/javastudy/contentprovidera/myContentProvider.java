package yieom.javastudy.contentprovidera;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

import static android.content.UriMatcher.NO_MATCH;

public class myContentProvider extends ContentProvider {
    private String TAG = getClass().getName();

    private SQLiteDatabase mDatabase;
    static final String PROVIDER_NAME = "yieom.javastudy.contentprovidera.myContentProvider";
    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;
    static final int GET_ALL = 1;
    static final int INSERT = 2;
    static final int UPDATE = 3;
    static final int DELETE = 4;
    static final int MY_TABLE = 5;
    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(NO_MATCH);
//        uriMatcher.addURI(PROVIDER_NAME, "getAll", GET_ALL);
//        uriMatcher.addURI(PROVIDER_NAME, "insert", INSERT);
        uriMatcher.addURI(PROVIDER_NAME,"my_table",MY_TABLE);

        STUDENTS_PROJECTION_MAP = new HashMap<String,String>();
        STUDENTS_PROJECTION_MAP.put(BaseColumns._ID,BaseColumns._ID);
        STUDENTS_PROJECTION_MAP.put("contents","contents");
        STUDENTS_PROJECTION_MAP.put("name","name");
        STUDENTS_PROJECTION_MAP.put("num","num"+" as noo");
    }

    @Override
    public boolean onCreate() {
        AppModule appModule = AppModule.getInstance();
        appModule.init(getContext());

        DBHelper dbHelper = new DBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();
        return (mDatabase == null)? false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch(uriMatcher.match(uri)) {
            case NO_MATCH :
                Log.v(TAG,"query, NO_MATCH");
                break;
            case MY_TABLE :
                Log.v(TAG,"query, MY_TABLE");
                break;
        }

        Log.d("test","uri : "+uri);
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables("my_table");
        qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
        if (sortOrder == null || sortOrder == ""){
            sortOrder = /*NAME*/"contents";
        }

        Cursor c = qb.query(mDatabase, projection, selection, selectionArgs,null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
