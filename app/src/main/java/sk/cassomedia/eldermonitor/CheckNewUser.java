package sk.cassomedia.eldermonitor;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Matus on 28. 11. 2015.
 */
public class CheckNewUser {

    File userFile;

    public boolean userExists() {
        this.userFile = new File(Environment.getExternalStorageDirectory() + File.separator + "EldersApp/user.conf");

        if(this.userFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void userCreate(String userData) {
        try {
            File userFilePath = new File(Environment.getExternalStorageDirectory(),"EldersApp");

            if (!userFilePath.exists()) {
                userFilePath.mkdirs();
            }

            File userFile = new File(userFilePath,"user.conf");
            FileWriter writer = new FileWriter(userFile);

            writer.append(userData);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
