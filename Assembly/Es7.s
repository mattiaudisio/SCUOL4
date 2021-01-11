.data
    //Alloco lo spazio per la stringa 
    str:            .space  128

    //Lunghezza della stringa
    str_len =       .-str

    ncaratteri: .long 0

.text        
    .global main
main:        
    // Chiamata a sys_read - funzione 3 dell interrupt 0x80        
    movl     $3,%eax        
    // Primo argomento della funzione 0 -> stdin        
    movl     $0,%ebx        

    // Passo l indirizzo della stringa e la relativa lunghezza        
    movl            $str,%ecx        
    movl            $str_len,%edx        
    int             $0x80        
    
    movl            %eax,ncaratteri

    // Stampo la stringa letta        
    movl            $4,%eax        
    movl            $1,%ebx        
    movl            $str,%ecx        
    movl            ncaratteri,%edx        
    int             $0x80
        
    movl            $1,%eax        
    movl            $0,%ebx        
    int             $0x80        

    leave        
    ret
