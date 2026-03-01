package main;

import java.util.List;
import javax.swing.SwingUtilities;

public class CarDiagnosisApp {
    public static void main(String[] args) {
        // 1. Daten laden (wie vorher)
        LogReader reader = new LogReader();
        List<TelemetryData> daten = reader.readFile("fahrtdaten.csv");
        System.out.println(daten.size() + " Datensätze geladen.");

        // 2. Dashboard starten (in einem eigenen Thread für GUIs)
        SwingUtilities.invokeLater(() -> {
            DashboardUI dashboard = new DashboardUI(daten);
            dashboard.setVisible(true); // Fenster sichtbar machen
        });
    }
}