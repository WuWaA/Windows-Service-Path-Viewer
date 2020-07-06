import javafx.beans.property.SimpleStringProperty;

public class Service {
    private final SimpleStringProperty name, path, state;

    Service(String name, String path, String state) {
        this.name = new SimpleStringProperty(name);
        this.path = new SimpleStringProperty(path);
        this.state = new SimpleStringProperty(state);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String s_name) {
        name.set(s_name);
    }

    public String getPath() {
        return path.get();
    }

    public void setPath(String s_path) {
        path.set(s_path);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String s_state) {
        path.set(s_state);
    }
}