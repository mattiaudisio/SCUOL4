package prj_Party;

public class Alunno {
    private String nome;        //Ora come ora la stringa ha valore NULL
    private int repartoID;
    
    public void Inizializza(){
        nome = "";
        repartoID = 1;
    }
    
    public void setNome(String pNome){
        nome = pNome;        
    }

    public String getNome(){
        return nome;
    }    
    
    public void setRepartoID(int pReparto){
        repartoID = pReparto;        
    }

    public int getRepartoID(){
        return repartoID;
    }

    /*public void AlzaLaMano(){
        System.out.println("Alzo la mano");
    }*/
    
}
