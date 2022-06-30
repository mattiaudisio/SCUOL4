package prj_Party;

public class Localita {

    public String GetLocalita(int localitaID){
        if (localitaID == 1){
            return "Alba";
        }else if (localitaID == 2){
            return "Torino";
        }else{
            return "Cuneo";
        }
    }

}
