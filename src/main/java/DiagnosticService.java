import java.util.List;

public class DiagnosticService {

    public void analyze(List<TelemetryData> dataList) {
        System.out.println("--- Starte Diagnose ---");
        int errorCount = 0;

        for (TelemetryData data : dataList) {
            // Regel 1: Motor zu heiß
            if (data.getEngineTemp() > 110.0) {
                System.out.println("WARNUNG [Zeit " + data.getTimestamp() + "]: Motor überhitzt (" + data.getEngineTemp() + "°C)");
                errorCount++;
            }

            // Regel 2: Drehzahl zu hoch (Roter Bereich)
            if (data.getRpm() > 6500) {
                System.out.println("KRITISCH [Zeit " + data.getTimestamp() + "]: Drehzahl zu hoch (" + data.getRpm() + " U/min)");
                errorCount++;
            }
        }

        System.out.println("--- Diagnose beendet. Gefundene Probleme: " + errorCount + " ---");
    }
}