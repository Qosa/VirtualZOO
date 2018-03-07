package animals.model;

import animals.Serializator;
import animals.model.Type;
import animals.model.Genre;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;
import org.omg.PortableServer.AdapterActivator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Model {

    private static TreeItem<String> root = new TreeItem<>();
    //public static ArrayList<Type> typesList = new ArrayList<Type>();
    public static ArrayList<Type> typesList;

    static {
        try {
            typesList = Serializator.deserialize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getTypes() {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<typesList.size();i++){
            names.add(typesList.get(i).name);
        }
        return names;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }

    public static TreeItem<String> getRoot() {
        return root;
    }

    public static void init(){
        initRoot(typesList);
    }

    private static void initRoot(ArrayList<Type> types){
        root.getChildren().clear();
        types.forEach(c->{
            TreeItem<String> typeItem = new TreeItem<String>(c.name);
            c.famillyList.forEach(b->{
                TreeItem<String> familyItem = new TreeItem<String>(b.familly_name);
                typeItem.getChildren().add(familyItem);
                b.genreList.forEach(d->{
                    familyItem.getChildren().add(new TreeItem<String>(d.genreName));
                });
            });
            root.getChildren().add(typeItem);
        });
    }

}
