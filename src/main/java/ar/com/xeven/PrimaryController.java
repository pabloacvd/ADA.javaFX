package ar.com.xeven;

import java.io.IOException;
import java.util.List;

import ar.com.xeven.entities.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML public TableView<Cliente> tabla = new TableView<>();
    @FXML public TableColumn<Cliente, String> nombreCol;
    @FXML public TableColumn<Cliente, String> cargoCol;
    @FXML public TableColumn<Cliente, String> empresaCol;
    @FXML public Label titulo;

    @FXML
    public void initialize() {
        titulo.setText("Lista de clientes");
        TableColumn<Cliente, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("idCliente"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        cargoCol.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        empresaCol.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        //tabla.getColumns().clear();
        tabla.getColumns().addAll(idCol);
        tabla.getItems().addAll(ClienteDAO.getClientes());
    }
}