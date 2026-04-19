package com.example.visual;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.dao.Conexao;
import com.example.dao.Dao;
import com.example.model.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable {

    private Connection conn;

    @FXML
    private TableView <Usuario>tabela;

    @FXML
    private TableColumn<Usuario, String> colNome;

    @FXML 
    private TableColumn<Usuario, String> colEmail;

    @FXML
    private TableColumn<Usuario, String> colSenha;

    @FXML
    private TableColumn <Usuario, Integer> colId;

    @FXML
    private TableColumn <Usuario, Integer> colTelefone;

    @FXML
    private TableColumn <Usuario, String> colEndereco;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void switchToTerceiro() throws  IOException{
        App.setRoot("cadastro");
    }



    public void setConnection(Connection conn){
        this.conn = conn;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
            colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
            

            
           
            try {
                conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Usuarios",
                "postgres",
                "123456");
                
                 Dao dao = new Dao(conn);
                List<Usuario> lista;
                lista = dao.listar();
                ObservableList<Usuario>usuario = FXCollections.observableArrayList(lista);
                tabela.setItems(usuario);

            } catch (SQLException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            







    }



    

    
}