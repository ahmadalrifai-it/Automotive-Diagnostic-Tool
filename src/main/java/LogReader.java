import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogReader {

    public List<TelemetryData> readFile(String filename) {
        List<TelemetryData> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Zeile zerteilen: "1000,0,800,90.5" -> ["1000", "0", "800", "90.5"]
                String[] values = line.split(",");

                // Text in Zahlen umwandeln
                long time = Long.parseLong(values[0]);
                double speed = Double.parseDouble(values[1]);
                int rpm = Integer.parseInt(values[2]);
                double temp = Double.parseDouble(values[3]);

                // Objekt erstellen und zur Liste hinzufügen
                dataList.add(new TelemetryData(time, speed, rpm, temp));
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }

        return dataList;
    }
}