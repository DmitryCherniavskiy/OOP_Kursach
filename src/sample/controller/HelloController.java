package sample.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;

public class HelloController {
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputPassword;
    @FXML
    private Label Error;
    private Main mainApp;

    public HelloController() {
    }

    @FXML
    private void signIn() throws IOException {
        if (this.checkInput()) {
            //this.mainApp.readFromFile();
            this.mainApp.showWorkersList();
        }

    }

    @FXML
    private void initialize() {
    }

    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    public boolean checkInput() {
        try {
            if (!this.inputPassword.getText().equals("123")) {
                throw new Exception("Неверный пароль");
            }

            if (this.inputName.getText().isEmpty()) {
                throw new Exception("Введите название отеля");
            }
        } catch (Exception var2) {
            this.Error.setText(var2.getMessage());
            return false;
        }

        return true;
    }
}