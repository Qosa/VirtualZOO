package animals;

import animals.model.Model;
import animals.model.Type;

import java.io.*;
import java.util.ArrayList;

public class Serializator {

    //SolarisIP1996
    public static void serialize() throws FileNotFoundException {
        ArrayList<Type> alist = Model.typesList;
        File f = new File("Obj.txt");
        FileOutputStream fos = new FileOutputStream(f);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(alist);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Type> deserialize() throws FileNotFoundException {
        ArrayList<Type> objj= new ArrayList<Type>();
        File f = new File("Obj.txt");
        FileInputStream fis = new FileInputStream(f);
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            objj = (ArrayList<Type>) ois.readObject();
            ois.close();
            fis.close();
            return objj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
