package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.Socket;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();




        Network network = new Network();
        if (!network.connect())
        {
            showErrorMessage("","Ошибка подключения к серверу." );
        }

        Controller controller = loader.getController();
        controller.setNetwork();

        network.waitMessage(controller.addWordToList("???????"));

        primaryStage.setOnCloseRequest(windowEvent -> network.close());

    }


    public static void showErrorMessage(String message, String errorMessage)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Проблемы с соединением.");
        alert.setHeaderText(errorMessage);
        alert.setContentText(message);
        alert.showAndWait();

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
