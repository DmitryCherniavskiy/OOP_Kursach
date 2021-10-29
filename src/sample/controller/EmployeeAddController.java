package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.classes.Employee;

public class EmployeeAddController {
    @FXML
    private TextField inputFullName;
    @FXML
    private TextField inputPosition;
    @FXML
    private TextField inputSubvision;
    @FXML
    private TextField inputDateStart;
    @FXML
    private TextField inputSalary;
    @FXML
    private TextField inputRegime;
    @FXML
    private TextField inputPassport;

    private Employee employeeAdded;

    private Main mainApp;

    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    public void setEmployee() {
        employeeAdded = new Employee(0,
        inputFullName.getText(), inputPosition.getText(),
        inputSubvision.getText(), null,
        inputDateStart.getText(), Double.parseDouble(inputSalary.getText()),
        inputRegime.getText(), inputPassport.getText());
    }

    public void AddEmployee(){
        setEmployee();
        mainApp.addEmployee(employeeAdded);
        mainApp.showWorkersList();
    }
}

