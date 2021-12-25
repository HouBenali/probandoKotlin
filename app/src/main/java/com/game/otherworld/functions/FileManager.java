package com.game.otherworld.functions;

import android.content.Context;

import com.game.otherworld.models.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Llegir i escriure en arxiu txt extern
public class FileManager {
    private final Context context;
    public String filename = "user.txt";

    public FileManager(Context context) {
        this.context = context;
    }

    /**
     * Pre condition: The file already exists
     * Pre condition: Assumes that there is only one User on the file
     * @return Returns a single User
     */
    public User readObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user = (User) ois.readObject();
        ois.close();
        return user;
    }

    public void writeObject(User user) throws IOException, ClassNotFoundException {
        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
    }
}
