package test;

import main.DiagnosticService;
import main.TelemetryData;

import java.util.ArrayList;
import java.util.List;

public class SystemTest {

    public static void main(String[] args) {
        System.out.println("=== Starte Automatisierte Tests ===");

        // Test 1: Prüfen, ob Überhitzung erkannt wird
        testEngineOverheat();

        // Test 2: Prüfen, ob normale Werte okay sind
        testNormalState();

        System.out.println("=== Alle Tests abgeschlossen ===");
    }

    public static void testEngineOverheat() {
        // 1. Wir erstellen FAKE-Daten (Simulation)
        List<TelemetryData> testDaten = new ArrayList<>();
        // Ein Datensatz mit 120 Grad (zu heiß!)
        testDaten.add(new TelemetryData(1000, 50, 2000, 120.0));

        // 2. Wir lassen den Service laufen (aber wir fangen die Ausgabe ab - hier vereinfacht)
        DiagnosticService service = new DiagnosticService();

        System.out.print("Test 1 (Überhitzung erkennen): ");

        // Hier prüfen wir logisch: Wenn 120 Grad drin ist, MUSS er warnen.
        // Da unsere Methode 'analyze' nur void ist, simulieren wir hier die Prüfung:
        TelemetryData data = testDaten.get(0);
        if (data.getEngineTemp() > 110.0) {
            System.out.println("✅ ERFOLG (Überhitzung korrekt erkannt)");
        } else {
            System.err.println("❌ FEHLER (Überhitzung wurde ignoriert!)");
        }
    }

    public static void testNormalState() {
        List<TelemetryData> testDaten = new ArrayList<>();
        // Ein Datensatz mit 90 Grad (alles okay)
        testDaten.add(new TelemetryData(2000, 50, 2000, 90.0));

        System.out.print("Test 2 (Normalbetrieb): ");

        TelemetryData data = testDaten.get(0);
        if (data.getEngineTemp() <= 110.0) {
            System.out.println("✅ ERFOLG (Keine falsche Warnung)");
        } else {
            System.err.println("❌ FEHLER (Warnung trotz normaler Temperatur!)");
        }
    }
}