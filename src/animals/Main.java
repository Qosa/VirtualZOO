package animals;

import animals.model.Familly;
import animals.model.Genre;
import animals.model.Model;
import animals.model.Type;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application{
    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.resizableProperty().setValue(Boolean.FALSE);
        this.primaryStage.setTitle("Employee app");
        showMainView();
        showTreeView();
    }

    public static void showMainView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,600,450);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                try {
                    Serializator.serialize();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void showAnimalView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AnimalView.fxml"));
        BorderPane mainItems = loader.load();
        mainLayout.setCenter(mainItems);
    }

    public static void showTreeView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/TreeView.fxml"));
        BorderPane electricalDep = loader.load();
        mainLayout.setCenter(electricalDep);
    }

    public static void showAddStage(String localization) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(localization));
        BorderPane addNewEmployee = loader.load();

        Stage addDialogStage = new Stage();
        addDialogStage.resizableProperty().setValue(Boolean.FALSE);
        addDialogStage.setTitle("Add New Employee");
        addDialogStage.initModality(Modality.WINDOW_MODAL);
        addDialogStage.initOwner(primaryStage);
        Scene scene = new Scene(addNewEmployee);
        scene.getStylesheets().add("style.css");
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();
    }

    public static void main(String[] args){
        //Model.typesList.add(new Type("Electrical",1004304,"feffef"));
        //Model.typesList.add(new Type("Mechanical",1004304,"feffef"));
        //Model.typesList.get(0).addFamilly(new Familly("Mietki","gownwo",2));
        //Model.typesList.get(0).addFamilly(new Familly("Wieski","gownwo",2));
        //Model.typesList.get(0).famillyList.get(0).addGenre(new Genre("Wieslaw Paleta","032002",000,"dfdf"")));
        //Model.typesList.get(0).famillyList.get(0).addGenre(new Genre("Adrian Puchacki","032002",000,"dfdf"));
        launch(args);
    }
}
