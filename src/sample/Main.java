//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.classes.Employee;
import sample.classes.Vacation;
import sample.controller.*;


public class Main extends Application {
    private static final String url = "jdbc:mysql://localhost:3306/hrd";
    private static final String user = "root";
    private static final String password = "36613661";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Employee> personData = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("HRD");
        this.initRootLayout();
        this.showHello();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("front/Sample.fxml"));
            this.rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            SampleController controller = (SampleController) loader.getController();
            controller.setMain(this);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public void showHello() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("front/Hello.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            this.rootLayout.setCenter(personOverview);
            HelloController controller = (HelloController) loader.getController();
            controller.setMain(this);
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }

    public void showWorkersList() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("front/WorkersList.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            this.rootLayout.setCenter(personOverview);
            WorkersListController controller = (WorkersListController) loader.getController();
            controller.setMain(this);
            controller.setItems(getWorkersData());
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void showEmployee(Employee employee) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Front/Employee.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Employee");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            EmployeeController controller = (EmployeeController) loader.getController();
            controller.setEmployee(employee);
            controller.setMain(this);
            dialogStage.showAndWait();
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    public void showAddEmployee() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Front/AddEmployee.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Adding employee");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            EmployeeAddController controller = (EmployeeAddController) loader.getController();
            controller.setMain(this);
            dialogStage.showAndWait();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public void showVacations() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("front/Vacation.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            this.rootLayout.setCenter(personOverview);
            VacationController controller = (VacationController) loader.getController();
            controller.setMain(this);
            controller.setItems(getVacation());
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Employee> getWorkersData() {
        String query = "select id_employee,full_name, pos, subvision, max(start_vac), start_date,\n" +
                "salary, regime, passport from Employee\n" +
                "left join Vacation on Employee.id_employee = Vacation.id_emp\n" +
                "group by id_employee;";

        return getQueryEmp(query);
    }

    public ObservableList<Employee> findEmp(String fullName) {
        String query = "select id_employee,full_name, pos, subvision, max(start_vac), start_date,\n" +
                "salary, regime, passport from Employee\n" +
                "left join Vacation on Employee.id_employee = Vacation.id_emp\n" +
                "where full_name like'%"+fullName+
                "%' group by id_employee;";

        return getQueryEmp(query);
    }

    public ObservableList<Vacation> findVac(String fullName) {
        String query = "select id_employee,full_name, pos, start_vac, end_vac,\n" +
                " type_vac from Employee\n" +
                "left join Vacation on Employee.id_employee = Vacation.id_emp\n" +
                "where full_name like'%"+fullName+
                "%' group by id_employee;";

        return getQueryVac(query);
    }

    public void addEmployee(Employee emp) {
        String query = "insert into employee (full_name, pos, subvision, start_date, salary, regime, passport)\n"+
                "values (?,?,?,?,?,?,?);";
        try {
            // opening database connection to MySQL server/
            con = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, emp.getFullName()); // 1 - порядковый номер параметра ("?") внутри запроса
            stmt.setString(2, emp.getPosition());
            stmt.setString(3, emp.getSubdivision());
            stmt.setString(4, emp.getStartDate());
            stmt.setDouble(5, emp.getSalary());
            stmt.setString(6, emp.getRegime());
            stmt.setString(7, emp.getPassport());
            stmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    public void addVac(Vacation vac) {
        String query = "insert into vacation (id_emp, start_vac, end_vac, type_vac)\n"+
                "values (?,?,?,?);";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Connection con=(Connection)DriverManager.getConnection(url, user, password);
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, vac.getID());
            Date ds= new Date(format.parse(vac.getStartVac()).getTime());
            ps.setDate(2,ds);
            Date de= new Date(format.parse(vac.getStartVac()).getTime());
            ps.setDate(3,de);
            ps.setString(4, vac.getType());
            ps.executeUpdate();
        } catch (SQLException | ParseException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    private ObservableList<Employee> getQueryEmp(String query) {
        ObservableList<Employee> employeesData = FXCollections.observableArrayList();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                employeesData.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),
                        rs.getDouble(7),rs.getString(8),rs.getString(9)));
            }
            return employeesData;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return employeesData;
    }

    public void DelEmp(String Id){
        String query = "delete from employee where id_employee = ?";

        try {
            // opening database connection to MySQL server/
            con = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,Integer.parseInt(Id));
            stmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    public void DelVac(Integer Id){
        String query = "delete from vacation where id_vacation = ?";
        try {
            // opening database connection to MySQL server/
            con = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,Id);
            stmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    public ObservableList<Vacation> getVacation() {
        String query = "select id_vacation,full_name, pos, start_vac, end_vac,\n" +
                " type_vac from Employee\n" +
                "right join Vacation on Employee.id_employee = Vacation.id_emp;";

        return getQueryVac(query);
    }

    private ObservableList<Vacation> getQueryVac(String query) {
        ObservableList<Vacation> vacationsData = FXCollections.observableArrayList();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                vacationsData.add(new Vacation(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6)));
            }
            return vacationsData;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return vacationsData;
    }

    public void editEmp(Employee emp){
        String query = "UPDATE employee SET full_name = ?, pos = ?, subvision = ?, start_date = ?," +
                " salary = ?, regime = ?, passport = ?" +
                " WHERE (id_employee = ?);";
        try {
            // opening database connection to MySQL server/
            con = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, emp.getFullName()); // 1 - порядковый номер параметра ("?") внутри запроса
            stmt.setString(2, emp.getPosition());
            stmt.setString(3, emp.getSubdivision());
            stmt.setString(4, emp.getStartDate());
            stmt.setDouble(5, emp.getSalary());
            stmt.setString(6, emp.getRegime());
            stmt.setString(7, emp.getPassport());
            stmt.setInt(8, emp.getID());
            stmt.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}