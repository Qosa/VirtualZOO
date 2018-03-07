package animals.view;

import animals.Main;
import animals.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static animals.view.TreeViewController.getIndexOfFamily;
import static animals.view.TreeViewController.getIndexOfType;
import static animals.view.TreeViewController.getZ;

public class AnimalViewController {
    private Main main;

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label l10;
    @FXML
    private ImageView imageView;
    @FXML
    private void goBack() throws IOException {
        main.showTreeView();
    }

    @FXML
    private void initialize(){
        l1.setText(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList.get(getZ()).getGenreName());
        l2.setText(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList.get(getZ()).getDateOfDiscover());
        l3.setText(Integer.toString(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList.get(getZ()).getNrOfLimbs()));
        l4.setText(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList.get(getZ()).getNameOfFamousOne());
        l5.setText(Model.typesList.get(getIndexOfType()).famillyList.get(getZ()).getFamilly_name());
        l6.setText(Model.typesList.get(getIndexOfType()).famillyList.get(getZ()).getCharacteristic_signs());
        l7.setText(Integer.toString(Model.typesList.get(getIndexOfType()).famillyList.get(getZ()).getApproxNrOfLimbs()));
        l8.setText(Model.typesList.get(getZ()).getName());
        l9.setText(Integer.toString(Model.typesList.get(getZ()).getApprox_amount()));
        l10.setText(Model.typesList.get(getZ()).getBody_descrption());
        Image image = new Image(Model.typesList.get(getIndexOfType()).famillyList.get(getIndexOfFamily()).genreList.get(getZ()).getImagePath().toURI().toString());
        imageView.setImage(image);
    }
}
