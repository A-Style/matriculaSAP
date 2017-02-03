
import vista.splash;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //new splash().setVisible(true);
        if( new Control().comprobar() )
        {
            new splash().setVisible(true);
        }        
        else
        {
            System.exit(0);
        }
    }

}
