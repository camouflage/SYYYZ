package com.example.hansity.syyyz;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by sunsheng on 5/28/16.
 */
public class CopyDB {
    private String DB_NAME = "syyyz.db";

    public void copyDbToExternal(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//data//" + context.getApplicationContext().getPackageName() + "//databases//"
                        + DB_NAME;
                String backupDBPath = DB_NAME;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
