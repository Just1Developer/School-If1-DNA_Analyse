import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 11.01.2022
 * Using as many methods as possible
 * @Just1Developer 
 */
 
 /** done, but cooler ^^
  * A, T, G, C, U
  * AnzA, AnzG - A/G etc. kommt X mal vor
  * A?T - ja/nein vbnbnbnbnnbn
  * AT?
  */

public class DNA_Programm extends Application {
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
  
  public void setResult(String res) {
    
    lResult.setText("Ergebnis:   " + res);  
    
  }
  //Start Inputreaders
  public String getSequence() {
    return tfSequence.getText();
  }
  public String getOperation() {
    return tfOperation.getText();
  }
  //End Inputreaders
  
  boolean differentiate = true;
  int minLenSeq = 2, maxLenSeq = 5; //Both valus are inclusive, max length of the A?T Operation
  
  //Execute Operation
  public String execute(String seq, String op) {
    String result = "", OGop = op;
    op = op.toUpperCase();
    seq = seq.toUpperCase();
    
    if(op.startsWith("ANZ")) {
      
      if(op.length() == 4) {
        //Ausgabe der Zählen-Methode direkt weitergeben
        return checkAnz(seq, op);
        
      } else return "Ungültiges Format: " + OGop + "; Bitte gib einen gültigen Zählbefehl an!";
      
    } else if(op.contains("?")) {
        if(op.length() >= minLenSeq && op.length() <= maxLenSeq) {
          
          return checkSequence(seq, op, OGop);
          
        } else if(minLenSeq == maxLenSeq) return "Ungültiges Format: " + OGop + "; Länge muss " + maxLenSeq + " betragen.";
          else return "Ungültiges Format: " + OGop + "; Länge muss zwischen " + minLenSeq + " und " + maxLenSeq + " liegen.";
      }
    
    return "Unbekannter Befehl: \"" + OGop + "\"";
  }
  
  //Count
  public String checkAnz(String seq, String op) {
    char c = op.charAt(3);
    int i = 0;
    for(char s : seq.toCharArray()) {
      if(s == c) i++;
    }
    return String.format("Das Zeichen %c kommt in der Sequenz " + i + " mal vor.", c);
  }
  
  //Checks the Sequence and differentiates between one and multiple question marks for the different methods
  public String checkSequence(String seq, String op, String OGop) {
    
    String match, newS = seq.toLowerCase();
    int count = 0;
    
    if(op.replace("?", "").length() == op.length()-1 && differentiate /*|| !op.replace("?", " ").trim().contains(" ")*/ ) {
      
      Object[] result = checkSingleQ(seq, op, newS);
      newS = (String) result[0];
      count = (Integer) result[1];
      
    } else if(op.replace("?", "").length() < op.length()-1) {
        
        //More complicated method for multiple ?
        
        Object[] result = checkMultipleQ(seq, op, newS);
        newS = (String) result[0];
        count = (Integer) result[1];
        
      }
    if(count > 0) return "Ja, " + count + " mal:  " + newS;
    else return "Nein:  " + seq.toLowerCase();
  }
  
  //Simple version for one Questionmark
  public Object[] checkSingleQ(String seq, String op, String newS) {
    
    //Simpler Version for max one ? between chars
    String match;
    int count = 0;
    
    for(String s : seq.split("")) {
      match = op.replace("?", s).toLowerCase();
      if(newS.contains(match)) {                       //So it only recognizes parts that havent been found yet  
        newS = newS.replaceFirst(match, match.toUpperCase());
        count++;
      }
    }
    
    Object[] result = {newS, count};
    
    return result;
  }
  
  
  //For Checking Multiple Questionmarks (Longer, so only used if there actually are multiple)
  public Object[] checkMultipleQ(String seq, String op, String newS) {
    
    String match;
    int count = 0;
    
    
    
    for(int i = 0; i < seq.length(); i++) {
      if(Character.toUpperCase(seq.charAt(i)) == op.charAt(0) || op.charAt(0) == '?') {
        match = "" + Character.toUpperCase(seq.charAt(i));
        
        try {
          
          for(int i2 = 1; i2 < op.length(); i2++) {
            if(op.charAt(i2) == '?' || op.charAt(i2) == seq.charAt(i+i2)) {   //i =^= 0 für i2
              match += Character.toUpperCase(seq.charAt(i+i2));
              if(i2 == op.length()-1) {
                newS = newS.replaceFirst(match.toLowerCase(), match);
                count++; 
              }  
            } else break;      
          }
          
        } catch(IndexOutOfBoundsException e) {
          continue;
        } 
      }
    }
    
    Object[] result = {newS, count};
    
    return result;
  }         
  
   
  public void bOK_Action(Event evt) {
    // TODO hier Quelltext einfügen
    setResult("");
    
    String sequence = getSequence(), op = getOperation();
    
    String result = execute(sequence, op);
    setResult(result);
    
  } // end of bOK_Action
  
  
  //Randomly Generated Sequences (RGS)
  
  
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

