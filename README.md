# Automotive Diagnostic Tool & HMI 🚗

Ein Java-basiertes Diagnose-System für Fahrzeug-Telemetriedaten. Dieses Projekt simuliert die Verarbeitung und Visualisierung von Automobil-Daten, angelehnt an reale HMI- (Human-Machine-Interface) und Diagnose-Konzepte.

## 🌟 Kernfunktionen

* **LogReader (Backend):** Einlesen und Parsen von simulierten Testfahrtdaten (CSV).
* **DiagnosticService (Logik):** Analyse der Telemetriedaten zur Erkennung kritischer Fahrzeugzustände (z.B. Motorüberhitzung, kritische Drehzahlen).
* **DashboardUI (Frontend):** Echtzeit-Visualisierung von Geschwindigkeit, RPM und Warnmeldungen über ein Java Swing HMI-Dashboard.
* **SystemTest (QA):** Automatisierte Testszenarien zur Validierung der Diagnose-Logik.

## 💻 Verwendete Technologien

* **Programmiersprache:** Java 
* **Benutzeroberfläche:** Java Swing
* **Architektur-Pattern:** MVC (Model-View-Controller)
* **Datenverarbeitung:** File I/O & CSV-Parsing
* **Versionsverwaltung:** Git & GitHub

## 🚀 Ausführung

1. Repository klonen oder als ZIP herunterladen.
2. Das Projekt in einer IDE (z.B. IntelliJ IDEA) öffnen.
3. Die Klasse `CarDiagnosisApp.java` ausführen, um das HMI-Dashboard und die Analyse zu starten.
