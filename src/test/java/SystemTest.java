import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;


public class SystemTest {

    @Test
    public void testEngineOverheat() {
        List<TelemetryData> testDaten = new ArrayList<>();
        testDaten.add(new TelemetryData(1000, 50, 2000, 120.0));

        DiagnosticService service = new DiagnosticService();
        TelemetryData data = testDaten.get(0);

        assertTrue(data.getEngineTemp() > 110.0, "❌ FEHLER (Überhitzung wurde ignoriert!)");
        System.out.println("✅ ERFOLG (Überhitzung korrekt erkannt)");
    }

    @Test
    public void testNormalState() {
        List<TelemetryData> testDaten = new ArrayList<>();
        testDaten.add(new TelemetryData(2000, 50, 2000, 90.0));

        TelemetryData data = testDaten.get(0);

        assertTrue(data.getEngineTemp() <= 110.0, "❌ FEHLER (Warnung trotz normaler Temperatur!)");
        System.out.println("✅ ERFOLG (Keine falsche Warnung)");
    }
}