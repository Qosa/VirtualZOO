package animals.view;

import animals.Main;
import animals.model.Model;
import animals.model.Type;
import animals.model.Familly;
import animals.model.Genre;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class TreeViewController {
    private Main main;
    static String x;
    static String y;
    static int z;
    static int indexOfType;
    static int indexOfFamily;

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public static String getX() {
        return x;
    }

    public static String getY() {
        return y;
    }

    public static int getZ() {
        return z;
    }

    public static int getIndexOfType() {
        return indexOfType;
    }

    public static int getIndexOfFamily() {
        return indexOfFamily;
    }

    @FXML
    private TreeView<String> animalsTreeView;
    @FXML
    private ContextMenu eddelMenu;
    @FXML
    private MenuItem usun;
    @FXML
    private MenuItem edytuj;

    @FXML
    private void goAnimal() throws IOException {
        animalsTreeView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if(event.getClickCount() == 2 && getX()!=null && getY()!=null){
                    try {
                        main.showAnimalView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @FXML
    private void editItemOnAction() throws IOException {
        main.showAddStage("view/EditView.fxml");
    }

    @FXML
    private void  deleteItemOnAction() throws IOException {
        if(x==null && y==null){
            System.out.println(x);
            System.out.println(y);
            Model.typesList.remove(z);
            System.out.println("Type");
        }else if(x!=null && y==null){
            System.out.println("Family");
            Model.typesList.get(indexOfType).famillyList.remove(z);
        }else{
            System.out.println("Genre");
            System.out.println(indexOfType);
            System.out.println(indexOfFamily);
            Model.typesList.get(indexOfType).famillyList.get(indexOfFamily).genreList.remove(z);
        }
        main.showTreeView();
    }

    @FXML
    private void sortOnAction() throws IOException {
        if(x==null && y==null){
            Collections.sort(Model.typesList, new TypeComparator());
        }else if(x!=null && y==null){
            Collections.sort(Model.typesList.get(getIndexOfType()).famillyList, new FamilyComparator());
        }else{
            Collections.sort(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList, new GenreComparator());
        }
        main.showTreeView();
    }

    @FXML
    private void revSortOnAction() throws IOException {
        if(x==null && y==null){
            Collections.sort(Model.typesList, new TypeComparator().reversed());
        }else if(x!=null && y==null){
            Collections.sort(Model.typesList.get(getIndexOfType()).famillyList, new FamilyComparator().reversed());
        }else{
            Collections.sort(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList, new GenreComparator().reversed());
        }
        main.showTreeView();
    }
    // ---------------------------> comparator classes
    class TypeComparator implements Comparator<Type> {
        @Override
        public int compare(Type a, Type b) {
            return a.name.compareToIgnoreCase(b.name);
        }
    }
    class FamilyComparator implements Comparator<Familly> {
        @Override
        public int compare(Familly a, Familly b) {
            return a.getFamilly_name().compareToIgnoreCase(b.getFamilly_name());
        }
    }
    class GenreComparator implements Comparator<Genre> {
        @Override
        public int compare(Genre a, Genre b) {
            return a.getGenreName().compareToIgnoreCase(b.getGenreName());
        }
    }
    //
    @FXML
    private int findIndexofType(String item){
        for(int i=0;i<Model.typesList.size();i++){
            if(Model.typesList.get(i).getName()==item){
                return(i);
            }
        }
        return -1;
    }

    @FXML
    private int findIndexofFamilly(String item1,String item2){
        for(int i=0;i<Model.typesList.get(findIndexofType(item1)).famillyList.size();i++){
            if(Model.typesList.get(findIndexofType(item1)).famillyList.get(i).getFamilly_name()==item2){
                return(i);
            }
        }
        return -1;
    }

    @FXML
    private void initialize(){
        Model.init();
        animalsTreeView.setRoot(Model.getRoot());
        animalsTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                z = selectedItem.getParent().getChildren().indexOf(selectedItem);
                indexOfType = findIndexofType(selectedItem.getParent().getValue());
                try {
                    setX(selectedItem.getParent().getValue());
                    setY(selectedItem.getParent().getParent().getValue());
                } catch (java.lang.NullPointerException e) {
                    setX(selectedItem.getParent().getValue());
                    setY(null);
                }
                System.out.println("Type: " + x);
                System.out.println("Familly: " + y);
                System.out.println(MouseEvent.MOUSE_CLICKED);
                System.out.println(indexOfType);
                if(x!=null && y!=null){
                    indexOfType = findIndexofType(selectedItem.getParent().getParent().getValue());
                    indexOfFamily = findIndexofFamilly(selectedItem.getParent().getParent().getValue(),selectedItem.getParent().getValue());
                    System.out.println(indexOfFamily);
                    System.out.println(indexOfType);
                }
            }
        });
    }

}
