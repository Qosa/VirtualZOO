package animals.view;

import animals.Main;
import animals.model.Genre;
import animals.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddGenreViewController {
    ObservableList<String> cbTypesList = FXCollections.observableArrayList(Model.getTypes());
    File selFile;
    //Genre
    @FXML
    private ComboBox<String> typeBox2;
    @FXML
    private ComboBox<String> familyBox;
    @FXML
    private TextField nameOfGenre;
    @FXML
    private TextField dateOfDiscover;
    @FXML
    private TextField nrOfLimbs;
    @FXML
    private TextField famousOne;
    @FXML
    private Button addButton;
    @FXML
    private void addGenre() throws IOException {
        Model.typesList.get(typeBox2.getSelectionModel().getSelectedIndex()).famillyList.get(familyBox.getSelectionModel().getSelectedIndex()).addGenre(new Genre(nameOfGenre.getText(), dateOfDiscover.getText(), Integer.parseInt(nrOfLimbs.getText()),famousOne.getText(),selFile));
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
        Main.showTreeView();
    }

    @FXML
    private void initialize() {
        typeBox2.setItems(cbTypesList);
    }

    @FXML
    private void initialize2(){
        ObservableList<String> cbFamilyList = FXCollections.observableArrayList(getFamilies());
        familyBox.setItems(cbFamilyList);
    }
    public ArrayList<String> getFamilies() {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<Model.typesList.get(typeBox2.getSelectionModel().getSelectedIndex()).famillyList.size();i++){
            names.add(Model.typesList.get(typeBox2.getSelectionModel().getSelectedIndex()).famillyList.get(i).getFamilly_name());
        }
        return names;
    }

    @FXML
    private void addImageAction(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"));
        selFile = fileChooser.showOpenDialog(null);
    }
}
