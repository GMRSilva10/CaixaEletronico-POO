package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import control.BancoControl;
import entity.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BoundaryCadastroCliente extends Application implements EventHandler<ActionEvent> {

	private TextField txtNome = new TextField();
	private TextField txtCPF = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtProfissao = new TextField();
	private TextField txtDataNascimento = new TextField();

	private ObservableList<String> estadoCivilList = FXCollections.observableArrayList("Solteiro", "Casado", "Separado",
			"Divorciado", "Viuvo");
	private ObservableList<String> sexoList = FXCollections.observableArrayList("Masculino", "Feminino");
	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

	private ComboBox<String> cmbEstadoCivil = new ComboBox<>(estadoCivilList);
	private ComboBox<String> cmbSexo = new ComboBox<>(sexoList);

	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");

	private BancoControl control = new BancoControl();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private TableView<Cliente> tableView = new TableView<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();
		vBox.setSpacing(20);
		vBox.setAlignment(Pos.CENTER);
		GridPane painel = new GridPane();
		painel.setAlignment(Pos.CENTER);
		painel.setHgap(20);
		painel.setVgap(10);
		HBox hBox = new HBox();
		hBox.setSpacing(20);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btnSalvar, btnPesquisar);
		vBox.getChildren().addAll(painel, hBox, tableView);
		Scene scn = new Scene(vBox, 600, 500);
		//tableView.setStyle(STYLESHEET_MODENA);
		tabelaCliente();

		painel.add(new Label("Nome"), 0, 0);
		painel.add(txtNome, 1, 0);
		painel.add(new Label("CPF"), 0, 1);
		painel.add(txtCPF, 1, 1);
		painel.add(new Label("Data Nascimento"), 0, 2);
		painel.add(txtDataNascimento, 1, 2);
		painel.add(new Label("Endereco"), 0, 3);
		painel.add(txtEndereco, 1, 3);
		painel.add(new Label("Profissao"), 0, 4);
		painel.add(txtProfissao, 1, 4);
		painel.add(new Label("Estado Civil"), 0, 5);
		painel.add(cmbEstadoCivil, 1, 5);
		painel.add(new Label("Sexo"), 0, 6);
		painel.add(cmbSexo, 1, 6);

		btnSalvar.addEventFilter(ActionEvent.ACTION, this);
		btnPesquisar.addEventFilter(ActionEvent.ACTION, this);

		primaryStage.setScene(scn);
		primaryStage.setTitle("Cadastro de Clientes");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		Cliente cliente;
		if (event.getTarget() == btnSalvar) {
			cliente = bondaryToCliente();
			control.adicionarCliente(cliente);
			tabelaCliente();
			Date data = null;
			clienteToBoundary(new Cliente("", "", "", data, "", "", ""));
		} else {
			if (event.getTarget() == btnPesquisar) {
				clienteToBoundary(control.pesquisar(txtNome.getText()));

			}
		}
	}

	private void clienteToBoundary(Cliente cliente) {
		txtNome.setText(cliente.getNome());
		txtCPF.setText(cliente.getCpf());
		txtProfissao.setText(cliente.getProfissao());
		try{
			txtDataNascimento.setText(sdf.format(cliente.getDataNascimento()));
		}catch(Exception e){
			txtDataNascimento.setText("");	
			}
		cmbEstadoCivil.setValue(cliente.getEstadoCivil());
		txtEndereco.setText(cliente.getEndereco());
		cmbSexo.setValue(cliente.getSexo());

	}

	public Cliente bondaryToCliente() {
		Cliente c1 = new Cliente();

		c1.setNome(txtNome.getText());
		c1.setCpf(txtCPF.getText());
		c1.setEndereco(txtEndereco.getText());
		c1.setProfissao(txtProfissao.getText());
		c1.setEstadoCivil(cmbEstadoCivil.getValue());
		c1.setSexo(cmbSexo.getValue());
		try {
			Date data = sdf.parse(txtDataNascimento.getText());
			c1.setDataNascimento(data);
			control.adicionarCliente(c1);
		} catch (ParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Informe a data no padrão dd/MM/yyyy");
		}
		
		return c1;
	}

	public void tabelaCliente() {
		for (Cliente cliente : control.clientes) {
			listaClientes.add(cliente);
		}
		tableView.setItems(listaClientes);
		
		TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableView.getColumns().add(colunaNome);

		TableColumn<Cliente, String> colunaCPF = new TableColumn<>("CPF");
		colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableView.getColumns().add(colunaCPF);

		TableColumn<Cliente, Date> colunaDataNascimento = new TableColumn<>("Nascimento");
		colunaCPF.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
		tableView.getColumns().add(colunaDataNascimento);

		TableColumn<Cliente, String> colunaEndereco = new TableColumn<>("Endereco");
		colunaCPF.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tableView.getColumns().add(colunaEndereco);

		TableColumn<Cliente, String> colunaProfissao = new TableColumn<>("Profissao");
		colunaProfissao.setCellValueFactory(new PropertyValueFactory<>("profissao"));
		tableView.getColumns().add(colunaProfissao);

		TableColumn<Cliente, String> colunaEstadoCivil = new TableColumn<>("Estado Civil");
		colunaProfissao.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
		tableView.getColumns().add(colunaEstadoCivil);

		TableColumn<Cliente, String> colunaSexo = new TableColumn<>("Sexo");
		colunaProfissao.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		tableView.getColumns().add(colunaSexo);
		
		
	}
}
