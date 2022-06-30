package ripasso2021;

public class Ripasso2021 {

    public static void main(String[] args) {
        // TODO code application logic here
        byte b;             // 8 bit
        int i;              // 4 byte 32 bit     
        short s;            // 2 byte 16 bit
        long l;             // 8 byte 64 bit
        
        float f;            // Composto da 4 byte 6/7 dec. significativi
                            // f = 123f f = 123.98f
        double d;           // 8 byte 15 decimali significativi
        char ch;            // 2 byte
        boolean bo;         // 1 bit
        
        String st;          // indeterminata
        String st2 = "abc";
        
        
        i = st2.length();
        // i = st.length(); Mi da errore perchè il valore di st è NULL
        
        System.out.println(i);
        // ---------------------------------------- //
        
        ConfrontoStringhe();
        ConfrontoStringheNew();
    }
    
    public static void ConfrontoStringheNew() {
        String nome = new String("Filippo");
        String nome2 = new String("Filippo");

        if(nome == nome2){
            System.out.println("nome e nome2 stesso address");
        }else{
            System.out.println("nome e nome2 diverso address");
        }  

        if(nome.equals(nome2)){
            System.out.println("nome e nome2 sono uguali");
        }else{
            System.out.println("nome e nome2 sono diversi");
        }
        
        if(nome.equalsIgnoreCase(nome2)){
            System.out.println("nome e nome2 sono uguali");
        }else{
            System.out.println("nome e nome2 sono diversi");
        }  
    }
    
    public static void ConfrontoStringhe(){
        String nome = "Filippo";
        String nome2 = "Filippo";

        if(nome == nome2){
            System.out.println("nome e nome2 stesso address");
        }
        
        nome2 = "filippo";

        if(nome == nome2){
            System.out.println("nome e nome2 stesso address");
        }else{
            System.out.println("nome e nome2 diverso address");
        }

        nome2 = "Filippo";

        if(nome == nome2){
            System.out.println("nome e nome2 stesso address");
        }else{
            System.out.println("nome e nome2 diverso address");
        }
    }
}
