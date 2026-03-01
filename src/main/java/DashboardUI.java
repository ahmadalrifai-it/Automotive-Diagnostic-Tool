import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {

    // UI-Elemente (Die "Anzeigen")
    private JLabel speedLabel = new JLabel("0 km/h");
    private JProgressBar rpmBar = new JProgressBar(0, 8000);
    private JLabel tempLabel = new JLabel("Motor: OK");

    // Daten-Verarbeitung
    private List<TelemetryData> daten;
    private int aktuellerIndex = 0;
    private Timer simulationTimer;

    public DashboardUI(List<TelemetryData> daten) {
        this.daten = daten;

        // 1. Fenster einrichten
        setTitle("VW HMI Simulation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // 4 Reihen untereinander

        // 2. Elemente stylen
        rpmBar.setStringPainted(true); // Zeige Zahlen auf dem Balken
        Font grosseSchrift = new Font("Arial", Font.BOLD, 24);
        speedLabel.setFont(grosseSchrift);
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        tempLabel.setOpaque(true); // Damit wir die Hintergrundfarbe ändern können
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 3. Elemente ins Fenster legen
        add(new JLabel("Geschwindigkeit:", SwingConstants.CENTER));
        add(speedLabel);
        add(new JLabel("Drehzahl (RPM):", SwingConstants.CENTER));
        add(rpmBar);
        add(tempLabel);

        // 4. Timer starten (aktualisiert das Bild alle 500 Millisekunden)
        simulationTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDashboard();
            }
        });
        simulationTimer.start();
    }

    // Diese Methode wird immer wieder aufgerufen (Loop)
    private void updateDashboard() {
        if (aktuellerIndex >= daten.size()) {
            simulationTimer.stop(); // Stoppen, wenn Daten zu Ende sind
            return;
        }

        // Aktuellen Datensatz holen
        TelemetryData currentData = daten.get(aktuellerIndex);

        // UI aktualisieren
        speedLabel.setText(currentData.getSpeed() + " km/h");
        rpmBar.setValue(currentData.getRpm());
        rpmBar.setString(currentData.getRpm() + " U/min");

        // Logik für Warnungen (HMI-Logik)
        if (currentData.getEngineTemp() > 110.0) {
            tempLabel.setText("WARNUNG: ÜBERHITZUNG (" + currentData.getEngineTemp() + "°C)");
            tempLabel.setBackground(Color.RED);
            tempLabel.setForeground(Color.WHITE);
        } else {
            tempLabel.setText("Temperatur: " + currentData.getEngineTemp() + "°C");
            tempLabel.setBackground(Color.GREEN);
            tempLabel.setForeground(Color.BLACK);
        }

        aktuellerIndex++; // Zum nächsten Datensatz springen
    }
}