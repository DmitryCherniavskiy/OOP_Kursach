package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.classes.Employee;
import sample.classes.Vacation;

public class EmployeeController {
    @FXML
    private Label labelId;
    @FXML
    private TextField inputFullName;
    @FXML
    private TextField inputPosition;
    @FXML
    private TextField inputSubvision;
    @FXML
    private Label labelLastVac;
    @FXML
    private TextField inputDateStart;
    @FXML
    private TextField inputSalary;
    @FXML
    private TextField inputRegime;
    @FXML
    private TextField inputPassport;
    @FXML
    private TextField inputAddVacDate;
    @FXML
    private TextField inputAddVacTime;
    @FXML
    private TextField inputAddVacType;
    @FXML
    private Label errorLabel;


    private Main mainApp;
    private Employee emp;

    @FXML
    private void EditEmp(){
        emp = new Employee(Integer.parseInt(labelId.getText()),inputFullName.getText(), inputPosition.getText(),
        inputSubvision.getText(),"", inputDateStart.getText(), Double.parseDouble(inputSalary.getText()),
                inputRegime.getText(),inputPassport.getText());
        mainApp.editEmp(emp);
    }

    @FXML
    private void AddVac(){
        errorLabel.setText("");
        Vacation vac = new Vacation(Integer.parseInt(labelId.getText()),inputFullName.getText(),inputPosition.getText(),
                inputAddVacDate.getText(), inputAddVacTime.getText(), inputAddVacType.getText());
        mainApp.addVac(vac);
        /*try{
        Vacation vac = new Vacation(Integer.parseInt(labelId.getText()),inputFullName.getText(),inputPosition.getText(),
                inputAddVacDate.getText(), inputAddVacTime.getText(), inputAddVacType.getText());
        mainApp.addVac(vac);}
        catch (Exception ex){
            errorLabel.setText("Ошибка ввода");
        }*/
        mainApp.showVacations();
    }

    @FXML
    private void DeleteEmp(){
        mainApp.DelEmp(labelId.getText());
        mainApp.showWorkersList();
    }

    public void setMain(Main mApp) {
        this.mainApp = mApp;
    }

    public void setEmployee(Employee employee) {
        labelId.setText(employee.getID().toString());
        inputFullName.setText(employee.getFullName());
        inputPosition.setText(employee.getPosition());
        inputSubvision.setText(employee.getSubdivision());
        inputDateStart.setText(employee.getStartDate());
        labelLastVac.setText(employee.getLastVac());
        inputRegime.setText(employee.getRegime());
        inputSalary.setText(employee.getSalary().toString());
        inputPassport.setText(employee.getPassport());
    }
}

