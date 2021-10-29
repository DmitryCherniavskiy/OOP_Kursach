package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.classes.Employee;

public class WorkersListController {
    @FXML
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee, Integer> columnID;
    @FXML
    private TableColumn<Employee, String> columnFullName;
    @FXML
    private TableColumn<Employee, String> columnPosition;
    @FXML
    private TableColumn<Employee, String> columnVacation;
    @FXML
    private TableColumn<Employee, Double> columnSalary;
    @FXML
    private TableColumn<Employee, String> columnRegime;
    @FXML
    private TextField textfieldFind;

    @FXML
    private void findEmployee(){
        String findName = textfieldFind.getText();
        this.table.setItems(this.mainApp.findEmp(findName));
    };

    @FXML
    private void addEmployee(){
        this.mainApp.showAddEmployee();
    };

    @FXML
    private void initialize() {
        this.columnID.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).IDProperty().asObject();
        });
        this.columnFullName.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).fullNameProperty();
        });
        this.columnPosition.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).positionProperty();
        });
        this.columnRegime.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).regimeProperty();
        });
        this.columnSalary.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).salaryProperty().asObject();
        });
        this.columnVacation.setCellValueFactory((cellData) -> {
            return ((Employee)cellData.getValue()).lastVacProperty();
        });
        this.table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                mainApp.showEmployee(newValue);
            }catch (Exception ex){
                System.out.println("Список обновлен");
            }
        });
    }

    private Main mainApp;

    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    public void setItems(ObservableList<Employee> list){
        this.table.setItems(list);
    }
}
