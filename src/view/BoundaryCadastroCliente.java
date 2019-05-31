package view;

import entity.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoundaryCadastroCliente extends Application {

	private TextField txtNome = new TextField();
	private TextField txtCPF = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtProfissao = new TextField();
	
	private ObservableList <String> estadoCivilList = FXCollections.observableArrayList("Solteiro", "Casado", "Separado", "Divorciado", "Viuvo");
	private ObservableList <String> sexoList = FXCollections.observableArrayList("Masculino", "Feminino");
	
	private ComboBox<String> estadoCivil = new ComboBox<>(estadoCivilList); 
	private ComboBox<String> sexo = new ComboBox<>(sexoList);

	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private TableView <Cliente> tableView = new TableView<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box = new VBox();
		GridPane painel = new GridPane();
		Scene scn = new Scene(box, 600, 500);
		box.getChildren().addAll(painel, tableView);
		tableView.setStyle(STYLESHEET_MODENA);
		
		
		painel.add(new Label("Nome"), 0, 0);
		painel.add(txtNome, 1, 0);
		painel.add(new Label("CPF"), 0, 1);
		painel.add(txtCPF, 1, 1);
		painel.add(new Label("Endereco"), 0, 2);
		painel.add(txtEndereco, 1, 2);
		painel.add(new Label("Profissao"), 0, 3);
		painel.add(txtProfissao, 1, 3);
		painel.add(new Label("Estado Civil"), 0, 4);
		painel.add(estadoCivil, 1, 4);
		painel.add(new Label("Sexo"), 0, 5);
		painel.add(sexo, 1, 5);
		painel.add(btnSalvar, 0, 6);
		painel.add(btnPesquisar, 1, 6);
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Cadastro de Clientes");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
