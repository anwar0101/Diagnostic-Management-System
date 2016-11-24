/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Muhi
 */
public class RefundController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAdd1;
    @FXML
    private TextField tfAdd2;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void browseImage(MouseEvent event) {
    }

    @FXML
    private void addPatient(ActionEvent event) {
    }

    @FXML
    private void gotoHome(ActionEvent event) {
    }
    
}
