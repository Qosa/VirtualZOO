package animals.view;

import animals.Main;
import animals.model.Familly;
import animals.model.Genre;
import animals.model.Model;
import animals.model.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AddViewController {
    private Main main;
    ObservableList<String> cbTypesList = FXCollections.observableArrayList(Model.getTypes());

    // Type
    @FXML
    private TextField nameOfType;
    @FXML
    private TextField approxAmount;
    @FXML
    private TextField bodyDescription;
    @FXML
    private Button addButton;

    @FXML
    private void addType() throws IOException {
        Model.typesList.add(new Type(nameOfType.getText(),Integer.parseInt(approxAmount.getText()),bodyDescription.getText()));
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
        Main.showTreeView();
    }

    }
