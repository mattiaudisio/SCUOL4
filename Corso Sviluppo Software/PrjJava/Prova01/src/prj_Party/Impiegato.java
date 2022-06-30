package prj_Party;

//import java.util.Date;

public class Impiegato {

    //String in Java è una classe che al suo interno ha dei metodi

    private int repartoID,localitaID,tipoContrattoID;
    private String nome,cognome,mail,telefono;
    private boolean partTime;
    //private Date dataAssunzione;
    private float dataAssunzione;

    public void ReadReparto(){
      Reparto objReparto = new Reparto();
      objReparto.GetReparto(repartoID);
    }

    public void ReadLocalita(){
      Localita objLocalita = new Localita();
      objLocalita.GetLocalita(localitaID);
    }

    public void ReadTipoContratto(){
      Contratto objContratto = new Contratto();
      objContratto.GetTipoContratto(tipoContrattoID);    
    }

}
