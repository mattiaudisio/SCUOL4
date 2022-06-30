package costruttori;

/**
 *
 * @author AUDISIOM
 */
public class Alunno {
    //Questo è il costruttore di default della classe Alunno
    public Alunno(){
        m_Inizializza();
    }
    
    private void m_Inizializza(){
        System.out.println("Richiamato da costruttore");
    }
}