package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller
{
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;



    ObservableList<String> wordList = FXCollections.observableArrayList("HI","Table","Kaban");

    @FXML
    public void initialize()
    {
        listView.setItems(wordList);
    }

    @FXML
    public void addWordToList()
    {
        String word = inputField.getText();
        if (!word.isEmpty()) {
            listView.getItems().add(word);
        }
        inputField.setText("");
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
}
