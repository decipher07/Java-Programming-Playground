filename=$1
javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml,javafx.media $filename
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml,javafx.media $filename