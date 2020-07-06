import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class View {
    public View(Stage stage) {
        Scene scene = new Scene(new Group());
        ScrollPane scrollPane = new ScrollPane();
        TableView<Service> table = new TableView<Service>(fillData());

        TableColumn<Service, String> s_name = new TableColumn<Service, String>("Service Name");
        s_name.setMinWidth(100);
        s_name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Service, String> s_path = new TableColumn<Service, String>("Path");
        s_path.setMinWidth(200);
        s_path.setCellValueFactory(new PropertyValueFactory<>("path"));

        TableColumn<Service, String> s_state = new TableColumn<Service, String>("State");
        s_state.setMinWidth(100);
        s_state.setCellValueFactory(new PropertyValueFactory<>("state"));

        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getColumns().add(s_name);
        table.getColumns().add(s_path);
        table.getColumns().add(s_state);

        s_name.setSortType(TableColumn.SortType.ASCENDING);

        scrollPane.setContent(table);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scene.setRoot(scrollPane);

        stage.setScene(scene);
        stage.setTitle("Windows Service Viewer");
        stage.centerOnScreen();
        stage.show();
    }

    private ObservableList<Service> fillData() {
        ObservableList<Service> data = FXCollections.observableArrayList();
        ArrayList<Service> services = Functions.getServices();
        data.addAll(services);
        return data;
    }
}
