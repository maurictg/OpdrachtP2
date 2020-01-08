# Welkom bij ons project!
Dit is de opdracht van Programmeren 2 / Relationele Databases 2 van Aart, Lauran & Maurice

# Openen van het project in IntelliJ
1. Clone de repository of download hem als zip van Github
2. Open de map OpdrachtP2, dus niet de map Netflix maar de map daarvoor, in Intellij.
3. Stel de _VM-options_ in
4. Voeg in intellij bij _Project Structure_ de volgende SDK's toe:
- OpenJFX mapje _bin_
- OpenJFX mapje _lib_
- JDBC driver
5. Voer de SQL scripts uit om de database goed in te stellen (op dit moment nog niet aanwezig in de repo)
6. ... (database connectie instellen, Database db = new Database..);

## LET OP: Je hebt de volgende VM-options nodig:
```
-p "jouw sdk locatie javafx" --add-modules javafx.controls,javafx.fxml
```
