//Mattia Audisio

.data
    vet:        .long  7,62,97,15,75,41,99,30,45,42
    vet_l =     .-vet
    nvet:       .long  0
.text
    .global main
main:
    //leggo il vettore            
    movl    $4,%eax
    movl    $0,%ebx
    movl    $vet,%ecx
    movl    $nvet,%edx
    int     $0x80

    movl    $vet_l,%edi    

loop:
    //incremento nvet
    addl    $1,%edx   
    movl    vet,%eax
    addl    %edi,%eax

    //confronto quarantadue con il valore presente in EAX
    cmpl    42,%eax      
    je      decrementa         

decrementa:
    decl    %eax
    cmpl    $-1,%eax
    jne loop

end:
    movl    $4,%eax
    movl    $0,%ebx
    movl    $vet,%ecx
    int     $0x80

    movl    $1,%eax
    movl    $0,%ebx
    int     $0x80
