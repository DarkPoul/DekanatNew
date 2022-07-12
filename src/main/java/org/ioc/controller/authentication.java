package org.ioc.controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;

import org.ioc.App;
import org.ioc.database.DataBase;

public class authentication {

    @FXML
    private Button authentication_GO;

    @FXML
    private TextField authentication_Login;

    @FXML
    private Button Settings;

    @FXML
    private PasswordField authentication_password;

    public static String Login = "";
    public static String Password = "";
    public static String Name_dekanat = "";
    public static String Id_User = "";

    @FXML
    private void keyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Authentication_Button();
        }
    }

    @FXML
    void initialize() throws IOException {


//        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
//        Ini Login_Dekanat_set = new Ini(new File("src/main/resources/org/ioc/property/Config.ini"));
//        String Login_Dekanat = Login_Dekanat_set.get("login", "login_Dekanat");
//        authentication_Login.setText(Login_Dekanat);

        authentication_Login.setText("dekanat_TT");

        authentication_GO.setOnAction(actionEvent -> {
            try {
                Authentication_Button();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Settings.setOnAction(ActionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ini Files", "*.ini"));
            File file = fileChooser.showOpenDialog(new Stage());
//            Ini ini = null;
//            try {
//                ini = new Ini(new File(String.valueOf(file)));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            assert ini != null;
//            String Login =  ini.get("login", "login");
//            String Password = ini.get("password", "password");
//            String Host = ini.get("host", "host");
//            String Login_Dekanat_getter = ini.get("login", "login_Dekanat");
//            try {
//                Ini update_properties = new Ini(new File("src/main/resources/org/ioc/property/Config.ini"));
//                update_properties.put("login", "login", Login);
//                update_properties.put("password", "password", Password);
//                update_properties.put("host", "host", Host);
//                update_properties.put("login", "login_Dekanat", Login_Dekanat_getter);
//                update_properties.store();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });
    }

    public void Authentication_Button() throws IOException {
        Login = String.valueOf(authentication_Login.getText());
        Password = String.valueOf(authentication_password.getText());
//        Ini Login_Dekanat_set = new Ini(new File("src/main/resources/org/ioc/property/Config.ini"));
//        authentication_Login.setText(Login_Dekanat_set.get("login", "login_Dekanat"));
//        Login_Dekanat_set.put("login", "login_Dekanat", Login);
//        Login_Dekanat_set.store();

        try {
            DataBase.Open_DB();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (DataBase.True_connection){
            //////////////////////////////////////////////////////////////////////////
            boolean Connection_dekanat = false;
            DataBase dataBaseHandler = new DataBase();//Створюємо нову змінну на основі створеного нами класу
            ResultSet Log_pass = dataBaseHandler.Connection_Dekanat();//Викликаємо функцію з іншого класу
            List<String> var_1_List = new LinkedList<>();
            List<String> var_2_List = new LinkedList<>();//Створюємо список
            List<String> var_3_List = new LinkedList<>();//Створюємо список

            while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
                try {
                    if (!Log_pass.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String Login_string = null;
                String Password_string = null;
                String Login_ID = null;
                try {
                    Login_string = Log_pass.getString("Login");
                    Password_string = Log_pass.getString("password");
                    Login_ID = Log_pass.getString("ID_Faculty");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                var_1_List.add(Login_string);//додаємо отримані результати у список
                var_2_List.add(Password_string);
                var_3_List.add(Login_ID);
            }
            for (int i = 0; i < var_1_List.size(); i++) {
                if(Objects.equals(Login, var_1_List.get(i))){
                    Connection_dekanat = Objects.equals(Password, var_2_List.get(i));
                    Name_dekanat = var_1_List.get(i);
                    Id_User = var_3_List.get(i);
                }
            }

            if (Connection_dekanat) {
//
                System.out.println("hello");
                App.setRoot("gui/MainWindow");
            }
            else {
                App.setRoot("gui/error_connection");
                System.out.println("Connection failed...");
            }
        }
    }




}