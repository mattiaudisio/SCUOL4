package prj_Party;

public class PrjParty {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Impiegato impiegato = new Impiegato();
        
        //* Creazione oggetti
        Alunno luca = new Alunno();
        Alunno kevin = new Alunno();
        Alunno giuliano = new Alunno();
        
        //* Assegno nome agli oggetti
        luca.setNome("Luca");
        kevin.setNome("Kevin");
        giuliano.setNome("Giuliano");
        
        //* Richiamo i metodi
        AssegnaNome(luca,"Luca");
        AssegnaNome(kevin,"Kevin");
        AssegnaNome(giuliano,"Giuliano");
        
        LeggiNome(luca);
        LeggiNome(kevin);
        LeggiNome(giuliano);
    }
    
    public static void AssegnaNome(Alunno pAlunno,String pNome){
        pAlunno.setNome(pNome);
    }
    
    public static void LeggiNome(Alunno pAlunno){
        System.out.println(pAlunno.getNome());
    }
}
