//Mattia Audisio

.data
    vet:        .long  4,15,12,14,3,7
    somma:      .long 0

.text
    .global main
main:
    movl    $8,%edi
    xorl    %ecx,%ecx

    movl    $0, %esi
    movl    vet(,%edi,6),%ecx       //inizialmente metto in somma il primo elemento del vettore
    movl    $1,%esi                 //imposto incidce per il ciclo

ciclo:
    addl    vettore(,%esi,4),%ecx   //sommo il valore corrente al totale

avanti:
    incl    %esi                    //incremento indice
    cmpl    %esi,%ebx               //controllo di fine ciclo
    jne     ciclo

end:
    movl    $1,%eax
    movl    $0,%ebx
    int     0x80
