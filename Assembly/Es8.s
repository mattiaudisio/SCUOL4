//Conta le occorrenze del numero "X" in un vettore di 20 elementi interi
                                                                                                                                                                        
.data
    vet:    .long 14,12,22,18,14,12,17,20,32,40,51,12,22,14,20,17,12,2,32,40
    num:    .long 12
    occ:    .long 0
    str1_len= .-vet
    
.text
    .global main

main:
    //metto indirizzo 0 in edx
    movl    $0,%edi

    //vettore
    movl    $4,%eax
    movl    $1,%ebx
    movl    $vet,%ecx
    movl    $str1_len,%edx
    int     $0x80

    //inserisco il vettore in eax
    movl    vet(,%edi,4),%eax   
        
    cmpl    %ecx,%eax
    jge     occorrenze            

occorrenze:
    incl    occ

end:
    movl    $3,%eax
    movl    $0,%ebx
    movl    $occ,%ecx
    movl    $30,%edx
    int     $0x80

    movl    $1,%eax
    movl    $0,%ebx
    int     $0x80         
