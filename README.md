# Zeugnisgeldrechner

## 1. Voraussetzungen

Stelle sicher, dass du die folgenden Softwarekomponenten installiert hast:

- **Java Development Kit (JDK)**: Installiere eine aktuelle Version des JDK (z.B. JDK 11 oder JDK 17). Du kannst das JDK von der [Oracle-Website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) oder von [Adoptium](https://adoptium.net/) herunterladen.
- **Entwicklungsumgebung (IDE)**: Eine IDE wie IntelliJ IDEA, Eclipse, NetBeans oder Visual Studio Code wird empfohlen.

## 2. Projektstruktur

Die Projektstruktur sieht wie folgt aus:

```
/zeugnisgeldrechner
|-- /src
|   |-- Zeugnisgeldrechner.java
|-- README.md
|-- .gitignore
```

## 3. Projekt öffnen und ausführen

1. **Projekt öffnen**  
   Öffne das Projektverzeichnis `/zeugnisgeldrechner` in deiner IDE.

2. **Kompilieren**  
   Kompiliere die Datei `Zeugnisgeldrechner.java`. In den meisten IDEs genügt ein Klick auf "Build" oder "Kompilieren".

3. **Ausführen**  
   Starte die Anwendung, indem du die `main`-Methode in `Zeugnisgeldrechner.java` ausführst.

   Alternativ kannst du das Projekt auch im Terminal kompilieren und starten:
   ```sh
   javac src/Zeugnisgeldrechner.java
   java -cp src Zeugnisgeldrechner
   ```

## 4. Hinweise zur Benutzung

- Die Anwendung bietet eine grafische Oberfläche zur Eingabe von Noten und zur Berechnung des Zeugnisgeldes.
- Folge den Anweisungen auf dem Bildschirm und benutze die Buttons zur Navigation.

## 5. Fehlerbehebung

- Überprüfe die Konsole auf Fehlermeldungen.
- Stelle sicher, dass das richtige JDK installiert und in der IDE eingestellt ist.
- Bei Problemen mit der Darstellung: Stelle sicher, dass Java Swing unterstützt wird.