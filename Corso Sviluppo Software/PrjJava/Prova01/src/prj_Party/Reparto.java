package prj_Party;

public class Reparto {
        
    public String GetReparto(int repartoID){
        if (repartoID == 1){
            return "Amministrazione";            
        }else if (repartoID == 2){
            return "Produzione"; 
        }else{ 
            return "Distribuzione";             
        }
    } 
                
}