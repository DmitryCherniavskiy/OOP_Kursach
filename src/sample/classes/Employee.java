package sample.classes;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Employee {
    IntegerProperty ID;
    StringProperty FullName;
    StringProperty Position;
    StringProperty Subdivision;
    StringProperty LastVac;
    StringProperty StartDate;
    DoubleProperty Salary;
    StringProperty Regime;
    StringProperty Passport;

    public Employee(Integer id, String fullName, String position,String subdivision,
             String lastVac, String startDate, Double salary,
             String regime, String passport){
        ID = new SimpleIntegerProperty(id);
        FullName = new SimpleStringProperty(fullName);
        Position = new SimpleStringProperty(position);
        Subdivision = new SimpleStringProperty(subdivision);
        LastVac = new SimpleStringProperty(lastVac);
        StartDate = new SimpleStringProperty(startDate);
        Salary = new SimpleDoubleProperty(salary);
        Regime = new SimpleStringProperty(regime);
        Passport = new SimpleStringProperty(passport);
    }

    void set (Integer id, String fullName, String position,String subdivision,
             String lastVac, String startDate, Double salary,
             String regime, String passport){
        ID = new SimpleIntegerProperty(id);
        FullName = new SimpleStringProperty(fullName);
        Position = new SimpleStringProperty(position);
        Subdivision = new SimpleStringProperty(subdivision);
        LastVac = new SimpleStringProperty(lastVac);
        StartDate = new SimpleStringProperty(startDate);
        Salary = new SimpleDoubleProperty(salary);
        Regime = new SimpleStringProperty(regime);
        Passport = new SimpleStringProperty(passport);
    }

    public Integer getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public String getFullName() {
        return FullName.get();
    }

    public StringProperty fullNameProperty() {
        return FullName;
    }

    public String getPosition() {
        return Position.get();
    }

    public StringProperty positionProperty() {
        return Position;
    }

    public String getSubdivision() {
        return Subdivision.get();
    }

    public StringProperty subdivisionProperty() {
        return Subdivision;
    }

    public String getLastVac() {
        return LastVac.get();
    }

    public StringProperty lastVacProperty() {
        return LastVac;
    }

    public String getStartDate() {
        return StartDate.get();
    }

    public StringProperty startDateProperty() {
        return StartDate;
    }

    public Double getSalary() {
        return Salary.get();
    }

    public DoubleProperty salaryProperty() {
        return Salary;
    }

    public String getRegime() {
        return Regime.get();
    }

    public StringProperty regimeProperty() {
        return Regime;
    }

    public String getPassport() {
        return Passport.get();
    }

    public StringProperty passportProperty() {
        return Passport;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public void setFullName(String fullName) {
        this.FullName.set(fullName);
    }

    public void setPosition(String position) {
        this.Position.set(position);
    }

    public void setSubdivision(String subdivision) {
        this.Subdivision.set(subdivision);
    }

    public void setLastVac(String lastVac) {
        this.LastVac.set(lastVac);
    }

    public void setStartDate(String startDate) {
        this.StartDate.set(startDate);
    }

    public void setSalary(double salary) {
        this.Salary.set(salary);
    }

    public void setRegime(String regime) {
        this.Regime.set(regime);
    }

    public void setPassport(String passport) {
        this.Passport.set(passport);
    }
}
