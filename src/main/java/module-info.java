module com.station.lab8 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.commons.lang3;
    requires java.logging;

    opens com.station.lab8 to javafx.fxml;
    exports com.station.lab8;
}