/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic.system.management;

import diagnostic.management.system.DBConn;
import diagnostic.management.system.DiagnosticManagementSystem;
import diagnostic.management.system.model.Patient;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * FXML Controller class
 *
 * @author Muhi
 */
public class EntryController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfMobile;
    @FXML
    private TextField tfRef;
    @FXML
    private ImageView ivRenterProfile;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    private DiagnosticManagementSystem application;
    @FXML
    private TextField tfAdd1;
    @FXML
    private TextField tfAdd2;
    
    private Image image;
    private byte[] imagebyte;
    private Patient patient;
    private Sql2o sql2o;

    
    public void setApp(DiagnosticManagementSystem application) {
        this.application = application;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sql2o = new Sql2o(DBConn.DBURL, DBConn.USERNAME, DBConn.PASSWORD);
    }    

    @FXML
    private void browseImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(application.stage);
        if (file != null) {
            try {
                imagebyte =  Files.readAllBytes(file.toPath());
                image = new Image(file.toURI().toString());
                ivRenterProfile.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    @FXML
    private void gotoHome(ActionEvent event) {
        application.gotoHome();
    }

    @FXML
    private void addPatient(ActionEvent event) {
        
        try(Connection con= sql2o.open()){
            String sql = "INSERT INTO APP.patient("
                    + "p_id, p_name, p_address, p_phoneno, p_ref, p_photo)"
                    + "VALUES ("
                    + ":p_id, :p_name, :p_address, :p_phoneno, :p_ref, :p_photo)";
            
            patient = new Patient(new Random().nextInt(1000 - 100) + 1,
                    tfName.getText(), tfAdd1.getText() + tfAdd2.getText(),
                    tfMobile.getText(), tfRef.getText(), imagebyte);
            
            
            con.createQuery(sql).bind(patient).executeUpdate();
            Alert alart = new Alert(Alert.AlertType.INFORMATION, "Successfylly Added.", ButtonType.OK);
            alart.showAndWait();
            
            tfName.clear();
            tfAdd1.clear();
            tfAdd2.clear();
            tfMobile.clear();
            tfRef.clear();
            
            
        }
        
    }

    
    
    //file choser configration
    private void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setTitle("Select Renter Profile Picture");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg","*.png", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
                //new FileChooser.ExtensionFilter("All Files", "*.*")
        );
    }
    
    
}
