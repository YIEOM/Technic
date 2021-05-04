package yieom.javastudy.contentproviderb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String authority = "yieom.javastudy.contentprovidera.myContentProvider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.v("second","start");

//        Cursor c = getContentResolver().query(Uri.parse("content://"+authority+"/getdataall"), null, null, null, null);
        Cursor c = getContentResolver().query(Uri.parse("content://"+authority+"/my_table"), null, null, null, null);
        if(c == null) return;
        Log.v("second","run");

        StringBuilder aa = new StringBuilder();
        int idCol = c.getColumnIndex(BaseColumns._ID);
        int contentsCol = c.getColumnIndex("contents");
        int nameCol = c.getColumnIndex("name");
        int numCol = c.getColumnIndex("noo");

        Log.e("second","onCreate,  idCol : "+idCol+", contentsCol : "+contentsCol+", nameCol : "+nameCol+", numCol : "+numCol);
        while(c.moveToNext()) {
            String str = c.getLong(idCol) + " , " + c.getString(contentsCol)+" , "+c.getString(nameCol)+" , "+c.getInt(numCol);
            System.out.println(str);
            aa.append(str+"\n");
        }

//        while(c.moveToNext()) {
//            String str = c.getLong(0) + " , " + c.getString(1)+" , "+c.getString(2)+" , "+c.getInt(3);
//            System.out.println(str);
//            aa.append(str+"\n");
//        }
        c.close();

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(aa);
    }
}