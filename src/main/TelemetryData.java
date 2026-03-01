package main;

public class TelemetryData {
    // Die Attribute (Eigenschaften)
    private long timestamp;
    private double speed;
    private int rpm;
    private double engineTemp;

    // Der Konstruktor (zum Erstellen des Objekts)
    public TelemetryData(long timestamp, double speed, int rpm, double engineTemp) {
        this.timestamp = timestamp;
        this.speed = speed;
        this.rpm = rpm;
        this.engineTemp = engineTemp;
    }

    // Getter-Methoden (damit andere Klassen die Werte lesen können)
    public double getSpeed() { return speed; }
    public double getEngineTemp() { return engineTemp; }
    public int getRpm() { return rpm; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Zeit: " + timestamp + " | " + speed + " km/h | " + engineTemp + "°C";
    }
}