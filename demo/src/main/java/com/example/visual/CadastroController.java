package com.example.visual;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.Conexao;
import com.example.dao.Dao;
import com.example.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroController {

    private Connection conn; 

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoSenh;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Label lblMensagem;


    

     @FXML
    private void cadastro() throws IOException {

        App.setRoot("cadastro");
    }

      @FXML
    public void initialize()throws SQLException{
        try {
            this.conn = Conexao.getConnection();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void switchToTerceiro() throws  IOException{
        App.setRoot("atualizar");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void cadastrar()throws IOException, SQLException{
        Dao dao = new Dao(conn);
        Usuario user = new Usuario();

        if(campoNome.getText().isEmpty() ||
          campoEmail.getText().isEmpty() ||
          campoEndereco.getText().isEmpty() ||
          campoSenh.getText().isEmpty() || 
          campoTelefone.getText().isEmpty() ){
            
            lblMensagem.setText("Preencha todos os dados");
            return;
          }

        user.setNome(campoNome.getText());
        user.setEmail(campoEmail.getText());
        user.setEndereco(campoEndereco.getText());
        user.setTelefone(Integer.parseInt(campoTelefone.getText()));
        user.setSenha(campoSenh.getText());

        dao.inserir(user);

        
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("Cadastro com sucesso!!");
         alerta.showAndWait();




    } 







    
}
