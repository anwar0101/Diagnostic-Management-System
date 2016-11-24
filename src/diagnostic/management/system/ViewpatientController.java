/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic.management.system;

import diagnostic.management.system.model.Patient;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * FXML Controller class
 *
 * @author Muhi
 */
public class ViewpatientController implements Initializable {

    @FXML
    private TableView<Patient> tableReport;
    @FXML
    private TableColumn<Patient, Number> colSl;
    @FXML
    private TableColumn<Patient, String> colName;
    @FXML
    private TableColumn<Patient, String> colHouseRent;
    @FXML
    private TableColumn<Patient, String> colBillMonth;
    @FXML
    private TableColumn<Patient, String> colBillPaid;
    @FXML
    private Button btnSaveBill;
    
    
    private Sql2o sql2o;
    private List<Patient> myList;
    private DiagnosticManagementSystem application;
    @FXML
    private TextField tfSearch;
    
    
    
    public void setApp(DiagnosticManagementSystem application) {
        this.application = application;
    }

    private void prepareList() {
        myList = getMonthBill();
    }
    
    
    private List<Patient> getMonthBill() {
        String sql
                = "SELECT * from APP.patient";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Patient.class);
        }
    }

    private List<Patient> getMonthBill(String name) {
        String sql
                = "SELECT * from APP.patient where p_name=:p_name";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("p_name", name)
                    .executeAndFetch(Patient.class);
        }
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        sql2o = new Sql2o(DBConn.DBURL, DBConn.USERNAME, DBConn.PASSWORD);

        //bind cell value
        colName.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        colHouseRent.setCellValueFactory(new PropertyValueFactory<>("p_address"));
        colBillMonth.setCellValueFactory(new PropertyValueFactory<>("p_phoneno"));
        colBillPaid.setCellValueFactory(new PropertyValueFactory<>("p_ref"));
        
        
        //sl
        colSl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Patient, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Patient, Number> column) {
                return new ReadOnlyObjectWrapper<>(tableReport.getItems().indexOf(column.getValue()) + 1);
            }
        });
        
        
        
        //
        prepareList();
        ObservableList<Patient> bills = FXCollections.observableList(myList);

        //set to table view
        tableReport.setItems(bills);
        
        
    }    

    @FXML
    private void viewReport(ActionEvent event) {
        myList = getMonthBill(tfSearch.getText());
            ObservableList<Patient> bills = FXCollections.observableList(myList);
            tableReport.setItems(bills);
    }

    @FXML
    private void printTable(ActionEvent event) {
    }

    @FXML
    private void gotoHome(ActionEvent event) {
        application.gotoHome();
    }
    
}
