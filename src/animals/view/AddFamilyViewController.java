package animals.view;

import animals.Main;
import animals.model.Familly;
import animals.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class AddFamilyViewController {
    ObservableList<String> cbTypesList = FXCollections.observableArrayList(Model.getTypes());
    final PseudoClass errorClass = PseudoClass.getPseudoClass("error");

    //Family
    @FXML
    private ComboBox<String> typeBox;
    @FXML
    private Label label1;
    @FXML
    private TextField nameOfFamily;
    @FXML
    private TextField charSigns;
    @FXML
    private TextField approxAmountOfLimbs;
    @FXML
    private Button addButton;

    @FXML
    private void addFamily() throws IOException {
        if(typeBox.getSelectionModel().isEmpty()==true){
          label1.pseudoClassStateChanged(errorClass,true);
        } else if(nameOfFamily.getText().isEmpty()==true){
            nameOfFamily.pseudoClassStateChanged(errorClass, true);
        } else if(charSigns.getText().isEmpty()==true){
            charSigns.pseudoClassStateChanged(errorClass, true);
        } else if(approxAmountOfLimbs.getText().isEmpty()==true){
            approxAmountOfLimbs.pseudoClassStateChanged(errorClass, true);
        } else {
            Model.typesList.get(typeBox.getSelectionModel().getSelectedIndex()).famillyList.add(new Familly(nameOfFamily.getText(), charSigns.getText(), Integer.parseInt(approxAmountOfLimbs.getText())));
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
            Main.showTreeView();
        }
    }

    @FXML
    private void initialize() {
        typeBox.setItems(cbTypesList);
        Tooltip test = new Tooltip();
        test.setText("xoxoxo");
        typeBox.setTooltip(test);
    }
}
