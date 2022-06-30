package prj_Party;

public class Contratto {

    public String GetTipoContratto(int repartoID){
        if (repartoID == 1){
              return "apprendistato";
        }else if (repartoID == 2){
            return "inserimento";
        }else{
            return "intermittente";
        }
    }

}
