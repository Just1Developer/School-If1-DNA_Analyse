import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 * u know what this is
 *
 * @version 1.0 vom 11.01.2022
 * @author JustOneDeveloper
 */
 
 /** done, but cooler ^^
  * A, T, G, C, U
  * AnzA, AnzG - A/G etc. kommt X mal vor
  * A?T - ja/nein vbnbnbnbnnbn
  * AT?
  */

public class DNA_Programm_Einfach extends Application {
  // Anfang Attribute
  private Label lResult = new Label();
  private TextField tfSequence = new TextField();
  private Label lSequence = new Label();
  private TextField tfOperation = new TextField();
  private Label lOperation = new Label();
  private Button bOK = new Button();
  private Button bRandomSeq = new Button();
  private TextField tfRandLength = new TextField();
  private Button bOKwithRNG = new Button();
  private Label lCredithttpsgithubcomJust1Developer = new Label();
  private Button bOKbisJa1 = new Button();
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 546, 272);
    // Anfang Komponenten
    
    lResult.setLayoutX(22);
    lResult.setLayoutY(156);
    lResult.setPrefHeight(28);
    lResult.setPrefWidth(518);
    lResult.setText("Ergebnis: ");
    root.getChildren().add(lResult);
    tfSequence.setLayoutX(104);
    tfSequence.setLayoutY(16);
    tfSequence.setPrefHeight(25);
    tfSequence.setPrefWidth(150);
    root.getChildren().add(tfSequence);
    lSequence.setLayoutX(40);
    lSequence.setLayoutY(16);
    lSequence.setPrefHeight(28);
    lSequence.setPrefWidth(54);
    lSequence.setText("Sequenz:");
    root.getChildren().add(lSequence);
    tfOperation.setLayoutX(104);
    tfOperation.setLayoutY(56);
    tfOperation.setPrefHeight(25);
    tfOperation.setPrefWidth(150);
    root.getChildren().add(tfOperation);
    lOperation.setLayoutX(32);
    lOperation.setLayoutY(56);
    lOperation.setPrefHeight(28);
    lOperation.setPrefWidth(62);
    lOperation.setText("Operation:");
    root.getChildren().add(lOperation);
    bOK.setLayoutX(104);
    bOK.setLayoutY(104);
    bOK.setPrefHeight(25);
    bOK.setPrefWidth(75);
    bOK.setOnAction(
    (event) -> {bOK_Action(event);} 
    );
    bOK.setText("OK");
    root.getChildren().add(bOK);
    bRandomSeq.setLayoutX(296);
    bRandomSeq.setLayoutY(16);
    bRandomSeq.setPrefHeight(25);
    bRandomSeq.setPrefWidth(123);
    bRandomSeq.setOnAction(
    (event) -> {bRandomSeq_Action(event);} 
    );
    bRandomSeq.setText("Zufällige Sequenz");
    root.getChildren().add(bRandomSeq);
    tfRandLength.setLayoutX(437);
    tfRandLength.setLayoutY(16);
    tfRandLength.setPrefHeight(25);
    tfRandLength.setPrefWidth(78);
    tfRandLength.setPromptText("Länge");
    root.getChildren().add(tfRandLength);
    bOKwithRNG.setLayoutX(208);
    bOKwithRNG.setLayoutY(104);
    bOKwithRNG.setPrefHeight(25);
    bOKwithRNG.setPrefWidth(171);
    bOKwithRNG.setOnAction(
    (event) -> {bOKwithRNG_Action(event);} 
    );
    bOKwithRNG.setText("OK mit zufälliger Sequenz");
    root.getChildren().add(bOKwithRNG);
    lCredithttpsgithubcomJust1Developer.setLayoutX(323);
    lCredithttpsgithubcomJust1Developer.setLayoutY(254);
    lCredithttpsgithubcomJust1Developer.setPrefHeight(20);
    lCredithttpsgithubcomJust1Developer.setPrefWidth(230);
    lCredithttpsgithubcomJust1Developer.setText("Credit: https://github.com/Just1Developer");
    root.getChildren().add(lCredithttpsgithubcomJust1Developer);
    bOKbisJa1.setLayoutX(408);
    bOKbisJa1.setLayoutY(104);
    bOKbisJa1.setPrefHeight(25);
    bOKbisJa1.setPrefWidth(75);
    bOKbisJa1.setOnAction(
    (event) -> {bOKbisJa1_Action(event);} 
    );
    bOKbisJa1.setText("OK bis Ja");
    root.getChildren().add(bOKbisJa1);
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("DNA_Programm");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public DNA_Programm
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  
  //Übergibt einen String
  public void setResult(String res) {
    //Setzt die Ausgabe auf Ergebnis: Ausgabe
    lResult.setText("Ergebnis:   " + res);  
    
  }
  
  //Zum Einlesen der beiden Eingabefelder
  public String getSequence() {
    return tfSequence.getText();
  }
  public String getOperation() {
    return tfOperation.getText();
  }
  
  
  
  //Operation ausführen, gibt die Ausgabe als String zurück, man übergibt den String Sequenz und den String Operation
  public String ausführen(String Sequenz, String Operation) {
    
  //Definition von einem Duplikat von Operation (für die Ausgabe) und der Ausgabe selbst
  String Ausgabe = "";
  String OriginalOperation = Operation;   //Originale Operation (Für die Ausgabe später)
  
    Operation = Operation.toUpperCase();  //Operation und Sequenz werden zu Großbuchstaben gemacht
    Sequenz = Sequenz.toUpperCase();    //Dies löst das Problem der Groß- und Kleinschreibung
    
  //Falls Operation (jetzt in Großbuchstaben) mit ANZ anfängt
    if(Operation.startsWith("ANZ")) {
      
      if(Operation.length() == 4) {
        //Ausgabe der Zählen-Methode direkt weitergeben
        Ausgabe = zählen(Sequenz, Operation);
        
    //Fehler
      } else {
        Ausgabe = "Ungültiges Format: " + OriginalOperation + "; Bitte gib einen gültigen Zählbefehl an!";
      }
      
    } else if((Operation.contains("?")) && Operation.replace("?", "").length() == 2) {  //Else if tritt nur ein, wenn das vorherige if nicht zugetroffen hat
    
    //Falls irgendwo in der Operation ein Fragezeichen vorkommt und
    //die Operation, wenn man alle Fragezeichen wegnimmt, nur um 1 kürzer wird (Überprüfung auf mehrere Fragezeichen)
    
        if(Operation.length() == 3) {   //Prüft, ob die Länge der Operation 3 ist
      //Wenn ja, wird die Sequenz überprüft und Ausgabe wird auf den zurückgegebenen Wert gesetzt
          Ausgabe = FragezeichenChecker(Sequenz, Operation);
          
        } else {
      //Wenn nicht, wird ein Fehler ausgegeben
      //Bei Operation A?TT steht dann da: Ungültiges Format: A?TT; Länge muss 3 betragen.
      Ausgabe = "Ungültiges Format: " + OriginalOperation + "; Länge muss 3 betragen.";
    }
    
      } else {  //Falls keines der Beiden obigen zutrifft, landet das Programm hier
    
      //Ausgabe wird auf unbekannter Befehl gesetzt, ähnlich wie die Fehler(); methode im Unterricht
      Ausgabe = "Unbekannter Befehl: \"" + OriginalOperation + "\"";
    }
    
  //Ausgabewert wird zurückgegeben
    return Ausgabe;
  }
  
  
  
  //Zählmethode, gibt String zurück
  public String zählen(String Sequenz, String Operation) {
    //Erstellen vom Kontrollwert und dem Zähler
  char kontrolle = Operation.charAt(3);
    int count = 0;
  
  //Schleife, die jeden Buchstaben durchgeht und diesen kontrolliert
    for(int i = 0; i < Sequenz.length(); i += 1) {
      if(Sequenz.charAt(i) == kontrolle) count += 1;
    }
  
  //Wert in einem Antwortsatz zurückgeben
    return "Das Zeichen " + kontrolle + " kommt in der Sequenz " + count + " mal vor.";
  }
  
  
  
  //Überprüfung für das Fragezeichen
  public String FragezeichenChecker(String Sequenz, String Operation) {
    
    //Deklarierung Rückgabewert, falls er nicht geändert wird, wird später ein falsch zurückgegeben
  String Rückgabe = "Nein, die Operation " + Operation + " kommt in der Sequenz nicht vor.";
    
  for(int i = 0; i < Sequenz.length(); i += 1) {
    char buchstabe = Sequenz.charAt(i);
    String aktuellerBuchstabe = Character.toString(buchstabe);  //Buchstabe muss für den nächsten Schritt ein String sein; Für die Experten: Nein, casten geht hier nicht
    String Kontrollwert = Operation.replace("?", aktuellerBuchstabe); //Aus A?T und dem aktuellen Buchstaben G wird AGT:
                                      //Wenn AGT vorkommt, kommt A?T logischerweise auch vor.
    if(Sequenz.contains(Kontrollwert)) Rückgabe = "Ja, die Operation " + Operation + " kommt in der Sequenz vor.";
  }
    
  //Rückgabe des Rückgabewerts
    return Rückgabe;
  }   
  
  
  
  
  
  //Knopf-Methoden 
  public void bOK_Action(Event evt) {
    // TODO hier Quelltext einfügen
    setResult("");
    
  //Felder auslesen
    String Sequenz = getSequence();
  String Operation = getOperation();
    
  //Operation auswerten
    String result = ausführen(Sequenz, Operation);
    setResult(result);
    
  } // end of bOK_Action
  
  
  
  
  
  //          ACHTUNG, BITTE LESEN!
  //Randomly Generated Sequences (RGS) | Das hier ist komplizierter Stuff für zufällige String-Generation. Ich mache ihn nicht weg, vereinfache ihn aber auch nicht.
  //          Nicht vereinfachter Code ist in der Normalen Datei zu finden.
  
  
  
  
  
  String possible = "AGTUC";     //DNA: AGTC    RNA: AGUC
    
  public int getRandLength() {
    if((tfRandLength.getText()).equals("")) return 12;   //Standard Value
    try {
      return Integer.parseInt(tfRandLength.getText());
    } catch(NumberFormatException e) {}
    return 0;
  }

  public void bRandomSeq_Action(Event evt) {
    // TODO hier Quelltext einfügen
    StringBuilder seq = new StringBuilder();
    //Random r = new Random();
    int len = getRandLength();
    if(len == 0) return;
    for(int i = 0; i < len; i++) {
      seq.append(possible.charAt((int)(Math.random() * possible.length())));
    }
    tfSequence.setText(seq.toString());
  } // end of bRandomSeq_Action

  public void bOKwithRNG_Action(Event evt) {
    
    //Executes the operation with a random sequence
    
    bRandomSeq_Action(evt);
    bOK_Action(evt);
  } // end of bOKwithRNG_Action

  public void bOKbisJa1_Action(Event evt) {
    
    //Executes the Operation with a new random String until it got a positive result
    
    String Res = lResult.getText();
    
    if(Res.split(" ").length > 1) Res = Res.toLowerCase().split(":")[1].trim();
    
    if(getRandLength() < tfOperation.getText().length() && tfOperation.getText().contains("?")) {
      setResult("Fehler: Operationsparameter länger als Sequenz");
      return;
    }
    
    do {
      //Button mit RNG drücken 
      bOKwithRNG_Action(evt);
      //Ergebnis updaten
      Res = lResult.getText().toLowerCase().split(":")[1].trim();
      //Falls ein Fehler auftritt
      if(!Res.startsWith("ja") && !Res.startsWith("nein")) break;
    } while (!Res.startsWith("ja")); // end of while
  } // end of bOKbisJa1_Action

  // Ende Methoden
} // end of class DNA_Programm

