package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller
{
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;



    ObservableList<String> wordList = FXCollections.observableArrayList();

    @FXML
    public void initialize()
    {
        listView.setItems(wordList);
    }

    private  Network network;

    public void setNetwork()
    {
        this.network = network;
    }

//    public void sendMessage()
//    {
//        String message = inputField.getText();
//        appendMessage(message);
//        inputField.clear();
//
//    }



    @FXML
    public void addWordToList()
    {
        String word = inputField.getText();
        if (!word.isEmpty()) {
            listView.getItems().add(word);
        }
        inputField.setText("");

        try {
            network.getDataOutputStream().writeUTF(word);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Ошибка при отправке!";
            Main.showErrorMessage(e.getMessage(),errorMessage);
        }


    }



    @FXML
    public void exit()
    {
        System.exit(0);
    }


    @FXML
    public void ABOUT_INFORMATION()
    {
        String name = " Создатель: Лупанов Никита";
        String date = "Дата создания: 20th of November,2020";
        listView.getItems().add(name);
        listView.getItems().add(date);
    }

    public void addWordToList(String message) {
        String word = inputField.getText();
        if (!word.isEmpty()) {
            listView.getItems().add(word);
        }
        inputField.setText("");

        try {
            network.getDataOutputStream().writeUTF(word);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Ошибка при отправке!";
            Main.showErrorMessage(e.getMessage(), errorMessage);
        }


    }

//    private void appendMessage()
//    {
//        wordList
//    }



}
