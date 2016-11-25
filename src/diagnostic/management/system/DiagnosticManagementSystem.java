/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic.management.system;

import diagnostic.management.system.model.User;
import diagnostic.management.system.security.Authonicator;
import diagnostic.system.management.EntryController;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author anwar
 */
public class DiagnosticManagementSystem extends Application {

    public Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(DiagnosticManagementSystem.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Diagnostic Management System");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean userLogging(String userId, String password) {
        Authonicator autho = new Authonicator(userId, password);
        if (Authonicator.validate(userId, password)) {
            loggedUser = User.getInstance();
            loggedUser.setUsername(userId);
            gotoManagerHome();
            return true;
        } else {
            return false;
        }
    }

    private void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void gotoHome() {
        try {
            
            HomeController home = (HomeController) replaceSceneContent("home.fxml");
            home.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gotoManagerHome() {
        try {
            ManagerHomeController home = (ManagerHomeController) replaceSceneContent("managerhome.fxml");
            home.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void gotoEntry() {
        try {
            
            EntryController home = (EntryController) replaceSceneContent("entry.fxml");
            home.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gotoView() {
        try {
            
            ViewpatientController view = (ViewpatientController) replaceSceneContent("viewpatient.fxml");
            view.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(DiagnosticManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = DiagnosticManagementSystem.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(DiagnosticManagementSystem.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

}
