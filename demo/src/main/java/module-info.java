module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive  java.sql;
    requires transitive javafx.base;

    opens com.example.visual to javafx.fxml, javafx.graphics;
    opens com.example.model to javafx.base;
    exports com.example.visual;
    exports com.example.dao;
    exports com.example.model;
}
