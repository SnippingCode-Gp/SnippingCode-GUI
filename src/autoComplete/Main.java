package autoComplete;

public class Main {

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        AutoCompletion.createAndShowGUI(new String[] { "Hassan",
            "Haitham", "Hasson", "Mohamed Hassan Sabry", "Mahmoud" });
      }
    });
  }

}
