filename=$1
javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls $filename
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls $filename