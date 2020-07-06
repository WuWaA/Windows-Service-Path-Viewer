import java.util.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;

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
        table.getColumns().addAll(s_name, s_path, s_state);

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
