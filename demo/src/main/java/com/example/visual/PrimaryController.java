package com.example.visual;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.Conexao;
import com.example.dao.Dao;
import com.example.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    private Connection conn;

    @FXML
    private Label lblMensagem;

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button login;

    @FXML
    private Button cadastrar;

  

    public void setConnection(Connection conn){
        this.conn = conn;
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
    private void cadastro() throws IOException {

        App.setRoot("cadastro");
    }




    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("tabela");
    }

    @FXML
    private void switchToTerceiro() throws  IOException{
        App.setRoot("atualizar");
    }

    @FXML
    private void login()throws IOException, SQLException{
        Usuario user = new Usuario();
        user.setEmail(campoEmail.getText());
        user.setSenha(campoSenha.getText());
       
       
       

      try{           Dao dao = new Dao(conn);
        if(dao.validarLogin(user.getEmail(), user.getSenha())){
                lblMensagem.setText("Login realizado com sucesso!");
            
             switchToSecondary();

               
            
            }else{
                lblMensagem.setText("Email ou senha inválidos!");
            }
            }catch(SQLException e){
        lblMensagem.setText("Erro de conexão" + e.getMessage());
        }
    }



    
         
       
}

 



    



