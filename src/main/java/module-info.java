module ar.com.xeven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ar.com.xeven to javafx.fxml;
    opens ar.com.xeven.entities to javafx.fxml, javafx.base;
    exports ar.com.xeven;
}