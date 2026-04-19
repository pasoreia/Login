package com.example.visual;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.Conexao;
import com.example.dao.Dao;
import com.example.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TerceiroController {
    private Connection conn;

    //campos e botoes para atualizar o email
    @FXML
    private TextField atualizarEmail;

    @FXML
    private TextField id_1;

    @FXML
    private Button emailAtualizado;

    //campos e botoes para atualizar o nome

    @FXML
    private TextField atualizarNome;

    @FXML
    private TextField id;

    @FXML
    private Button nomeAtualizado;

    //campos e botoes para atualizar o telefone

    @FXML
    private Button telefoneAtualizado;

    @FXML
    private TextField id_2;

    @FXML
    private TextField atualizarTelefone;
    
    //campos e botoes para atualizar o endereço 

    @FXML
    private Button enderecoAtualizado;

    @FXML
    private TextField atualizarEndereco;

    @FXML
    private TextField id_3;

    //campos e botoes para atualizar o senha 
    @FXML
    private Button senhaAtualizado;

    @FXML
    private TextField id_4;

    @FXML
    private TextField atualizarSenha;


    //conexão com o banco de dados 
    public void setConnection(Connection conn)throws SQLException{
        this.conn =conn;
    }

    @FXML
    public void initialize()throws SQLException{
        try {
            this.conn = Conexao.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //botão parar voltar para o login 

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }

    //botão para voltra para o cadastro
    @FXML
    private void cadastro() throws IOException{
        App.setRoot("cadastro");

    }


    //função de atualizar o nome
    @FXML
    private void nomeAtualizado()throws IOException, SQLException{
        Dao dao = new Dao(conn);
        Usuario user = new Usuario();
        
        int ide = Integer.parseInt(id.getText());
        String novoNome = atualizarNome.getText();
        user.setId(ide);
        user.setNome(atualizarNome.getText());
        
        dao.atualizarNome(ide, novoNome);

          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("Nome atualizado com sucesso!!");
         alerta.showAndWait();

    }


    //funcção para atualziar email
    @FXML
    private void emailAtualizado()throws IOException, SQLException{
        Dao dao = new Dao(conn);
        Usuario user=new Usuario();

        int ide = Integer.parseInt(id_1.getText());
        String novoEmail = atualizarNome.getText();
        user.setId(ide);

        dao.atualizarEmail(ide, novoEmail);
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("E-mail atualizado com sucesso!!");
         alerta.showAndWait();

    }

    //função para atualizar telefone
    @FXML
    private void telefoneAtualizado()throws IOException, SQLException{
        Dao dao = new Dao(conn);
        Usuario user =new Usuario();

        int id = Integer.parseInt(id_2.getText());
        int novoTelefone = Integer.parseInt(atualizarTelefone.getText());

        user.setId(id);
        dao.atualizarTelefone(id, novoTelefone);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("Telefone atualizado com sucesso!!");
         alerta.showAndWait();

    }

    //função de atualizar endereço
    @FXML
    private void enderecoAtualizado()throws IOException, SQLException{
        Dao dao = new Dao(conn);
        Usuario user = new Usuario();

        int id = Integer.parseInt(id_3.getText());
        String novoEndereco = atualizarEndereco.getText();
        user.setId(id);

        dao.atualizarEndereco(id, novoEndereco);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("Endereço atualizado com sucesso!!");
         alerta.showAndWait();
        
    }

    @FXML
    private void senhaAtualizado()throws IOException,SQLException{
        Dao dao = new Dao(conn);
        Usuario user = new Usuario();

        int id = Integer.parseInt(id_4.getText());
        String novaSenha = atualizarSenha.getText();
        user.setId(id);
        dao.atualizarSenha(id, novaSenha);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("Cadastro ");
         alerta.setHeaderText(null);
         alerta.setContentText("Endereço atualizado com sucesso!!");
         alerta.showAndWait();
    }

    



}
