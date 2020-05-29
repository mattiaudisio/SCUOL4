//dato un vettore di interi positivi, sostitutisci tutti gli elementi pari, con l'elemento dispari successivo

.data
    vet:        .long 1,3,8,15,21,37,42,44,29,22
    agg:        .long 1
    vet_len=    .-vet    

.text
    .global main

main:
    movl $0,%edi    
loop:
    xorl    %edx,%edx
    //divido per 2
    movl    vet(,%edi,4),%eax
    movl    $2,%ebx        
    divl    %ebx
    //confronto se è pari
    cmpl    $0,%edx
    jne     aumento

aumento:
    //sommo ai numeri pari il numero 1
    movl    agg,%eax
    addl    %eax,%ebx
    jne     loop         

end:

    movl    $4,%eax
    movl    $1,%ebx
    movl    $vet,%ecx
    int     $0x80

	movl $1,%eax
	movl $0,%ebx
	int $0x80
