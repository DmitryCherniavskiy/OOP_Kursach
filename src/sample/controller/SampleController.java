package sample.controller;

import javafx.fxml.FXML;
import sample.Main;

public class SampleController {
    private Main mainApp;
    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    @FXML
    private void showAdd(){
        mainApp.showAddEmployee();
    }

    @FXML
    private void showWorkers(){
        mainApp.showWorkersList();
    }

    @FXML
    private void showVacation(){
        mainApp.showVacations();
    }
}
