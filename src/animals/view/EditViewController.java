package animals.view;

import animals.Main;
import animals.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EditViewController {
    @FXML
    private Label titleLabel;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private TextField editName;
    @FXML
    private TextField editField1;
    @FXML
    private TextField editField2;
    @FXML
    private GridPane genreGridPane;
    @FXML
    private Button confirmButton;

    @FXML
    private void initialize(){
        if(TreeViewController.getX()==null && TreeViewController.getY()==null){
            titleLabel.setText("Edytuj typ");
            label1.setText("Nazwa:");
            label2.setText("Śr.liczba:");
            label3.setText("B.ciała:");
            editName.setText(Model.typesList.get(TreeViewController.getZ()).getName());
            editField1.setText(Integer.toString(Model.typesList.get(TreeViewController.getZ()).getApprox_amount()));
            editField2.setText(Model.typesList.get(TreeViewController.getZ()).getBody_descrption());
        } else if(TreeViewController.getX()!=null && TreeViewController.getY()==null){
            titleLabel.setText("Edytuj rodzinę");
            label1.setText("Nazwa:");
            label2.setText("Znak charakter.:");
            label3.setText("Śr.liczba kończyn:");
            editName.setText(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).getFamilly_name());
            editField1.setText(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).getCharacteristic_signs());
            editField2.setText(Integer.toString(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).getApproxNrOfLimbs()));
        } else {
            titleLabel.setText("Edytuj gatunek");
            label1.setText("Nazwa:");
            label2.setText("Data odkrycia:");
            label3.setText("Liczba kończyn:");
            Label label4 = new Label("Slynny przedstaw.:");
            TextField famousOne = new TextField();
            editName.setText(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).getGenreName());
            editField1.setText(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).getDateOfDiscover());
            editField2.setText(Integer.toString(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).getNrOfLimbs()));
            famousOne.setText(Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).getNameOfFamousOne());
            genreGridPane.add(label4,0,3);
            genreGridPane.add(famousOne,1,3);
        }
    }

    @FXML
    private void setEditedFields() throws IOException {
        if (TreeViewController.getX() == null && TreeViewController.getY() == null) {
            Model.typesList.get(TreeViewController.getZ()).setName(editName.getText());
            Model.typesList.get(TreeViewController.getZ()).setApprox_amount(Integer.parseInt(editField1.getText()));
            Model.typesList.get(TreeViewController.getZ()).setBody_descrption(editField2.getText());
        } else if (TreeViewController.getX() != null && TreeViewController.getY() == null) {
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).setFamilly_name(editName.getText());
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).setCharacteristic_signs(editField1.getText());
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getZ()).setApproxNrOfLimbs(Integer.parseInt(editField2.getText()));
        } else {
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).setGenreName(editName.getText());
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).setDateOfDiscover(editField1.getText());
            Model.typesList.get(TreeViewController.getIndexOfType()).famillyList.get(TreeViewController.getIndexOfFamily()).genreList.get(TreeViewController.getZ()).setNameOfFamousOne(editField2.getText());
        }
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
        Main.showTreeView();
    }

}
