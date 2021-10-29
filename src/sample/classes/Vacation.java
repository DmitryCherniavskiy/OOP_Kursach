package sample.classes;

import javafx.beans.property.*;

public class Vacation {
    IntegerProperty ID;
    StringProperty FullName;
    StringProperty Position;
    StringProperty StartVac;
    StringProperty EndVac;
    StringProperty Type;

    public Integer getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getFullName() {
        return FullName.get();
    }

    public StringProperty fullNameProperty() {
        return FullName;
    }

    public void setFullName(String fullName) {
        this.FullName.set(fullName);
    }

    public String getPosition() {
        return Position.get();
    }

    public StringProperty positionProperty() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position.set(position);
    }

    public String getStartVac() {
        return StartVac.get();
    }

    public StringProperty startVacProperty() {
        return StartVac;
    }

    public void setStartVac(String startVac) {
        this.StartVac.set(startVac);
    }

    public String getEndVac() {
        return EndVac.get();
    }

    public StringProperty endVacProperty() {
        return EndVac;
    }

    public void setEndVac(String endVac) {
        this.EndVac.set(endVac);
    }

    public String getType() {
        return Type.get();
    }

    public StringProperty typeProperty() {
        return Type;
    }

    public void setType(String type) {
        this.Type.set(type);
    }

    public Vacation(Integer id, String fullName, String position, String startVac,
                    String endVac, String type){
        ID = new SimpleIntegerProperty(id);
        FullName = new SimpleStringProperty(fullName);
        Position = new SimpleStringProperty(position);
        StartVac = new SimpleStringProperty(startVac);
        EndVac = new SimpleStringProperty(endVac);
        Type = new SimpleStringProperty(type);
    }


}
