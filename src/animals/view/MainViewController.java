package animals.view;
import animals.Main;
import animals.model.Model;
import animals.model.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class MainViewController {

    private Main main;
    ObservableList<String> addElements = FXCollections.observableArrayList("Typ","Rodzina","Gatunek");
    ObservableList<String> editElements = FXCollections.observableArrayList("Typ","Rodzina","Gatunek");

    @FXML
    private ComboBox<String> addElementBox;
    @FXML
    private ComboBox<String> editElementBox;

    @FXML
    private void initialize(){
        editElementBox.setItems(editElements);
    }

    @FXML
    private void sortOnAction() throws IOException {
        Collections.sort(Model.typesList, new TypeComparator().reversed());
        main.showTreeView();
    }

    class TypeComparator implements Comparator<Type> {
        @Override
        public int compare(Type a, Type b) {
            return a.name.compareToIgnoreCase(b.name);
        }
    }

    @FXML
    private void OnClickAction() throws IOException {
        int x = editElementBox.getSelectionModel().getSelectedIndex();
        if(x==0) {
            main.showAddStage("view/AddView.fxml");
        }
        if(x==1){
            main.showAddStage("view/AddFamilyView.fxml");
        }
        if(x==2){
            main.showAddStage("view/AddGenreView.fxml");
        }
    }
}
