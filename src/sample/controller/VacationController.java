package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.Main;
import sample.classes.Employee;
import sample.classes.Vacation;

public class VacationController {
    @FXML
    private TableView<Vacation> table;
    @FXML
    private TableColumn<Vacation, Integer> columnID;
    @FXML
    private TableColumn<Vacation, String> columnFullName;
    @FXML
    private TableColumn<Vacation, String> columnPosition;
    @FXML
    private TableColumn<Vacation, String> columnVacStart;
    @FXML
    private TableColumn<Vacation, String> columnVacEnd;
    @FXML
    private TableColumn<Vacation, String> columnType;
    @FXML
    private TextField textfieldFind;

    @FXML
    private void FindVac(){
        String findName = textfieldFind.getText();
        this.table.setItems(this.mainApp.findVac(findName));
    };

    @FXML
    private void delVac(){
        try {
            mainApp.DelVac(table.getSelectionModel().getSelectedItem().getID());
        } catch(Exception ex){}
        mainApp.showVacations();
    };

    private Main mainApp;

    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    @FXML
    private void initialize() {
        this.columnID.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).IDProperty().asObject();
        });
        this.columnFullName.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).fullNameProperty();
        });
        this.columnPosition.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).positionProperty();
        });
        this.columnVacStart.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).startVacProperty();
        });
        this.columnVacEnd.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).endVacProperty();
        });
        this.columnType.setCellValueFactory((cellData) -> {
            return ((Vacation)cellData.getValue()).typeProperty();
        });
    }

    public void setItems(ObservableList<Vacation> list){
        this.table.setItems(list);
    }
}
