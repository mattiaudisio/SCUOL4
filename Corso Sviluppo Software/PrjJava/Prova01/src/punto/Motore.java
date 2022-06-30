package punto;

/**
 *
 * @author AUDISIOM
 */
public class Motore {
    
    public void AccendiMotore(){
        m_AccendiMotore();
    }
 
    public void SpegniMotore(){
         m_SpegniMotore();
    }
 
    private void m_AccendiMotore(){
        System.out.print("Motore acceso\n");
    }

    private void m_SpegniMotore(){
        System.out.print("Motore spento\n");
    }
}
