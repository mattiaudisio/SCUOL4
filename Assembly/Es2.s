// Chiedi in input 2 stringhe[ str 1(input 1), str 2(input 2)]
// creare una terza strings che contiene le altre 2  

.data
    
    str1:       .space 30
    str2:       .space 30
    str3:       .space 60
                                                                     
    str1_len:    .long 0
    str2_len:    .long 0
    str3_len:    .long 0

.text
    .global main

main:
    //inserisco la prima stringa
    movl    $3,%eax
    movl    $0,%ebx
    movl    $str1,%ecx
    movl    $30,%edx
    int     $0x80
    
    //mi salvo la dimensione della prima stringa
    decl    %eax                #escludo dalla prima stringa il \n
    movl    %eax,str1_len

    movl    str1,%eax
    movl    %eax, str3          #salvo la prima stringa in str3

    //inserisco la seconda stringa
    movl    $3,%eax
    movl    $0,%ebx
    movl    $str2,%ecx
    movl    $30,%edx
    int     $0x80

    //mi salvo la dimensione della seconda stringa senza decremento [ così mantengo il \n ]
    movl %eax, str2_len
    
    //accodo la seconda stringa a str3
    movl    str1_len, %ecx
    movl    str2, %eax
    movl    %eax, str3(%ecx)    #posso scrivere così perchè mi devo spostare di un solo carattere

    addl    str2_len, %ecx      #sommo la dimensione di str2 a str1_len che era salvato in %ecx            
    movl    %ecx, %edx          #in %edx tengo la dimensione della stringa

    //stampo la stringa
    movl   $4,%eax
    movl   $1,%ebx
    movl   $str3,%ecx
    #non salvo nulla in %edx perchè ho già salvato la dimensione della stringa in precedenza 
    int    $0x80

    movl   $1,%eax 
    movl   $0,%ebx
    int    $0x80

