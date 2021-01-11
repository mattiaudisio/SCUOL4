//Mattia Audisio

.data
    vet:    .long   14,27,32,55,89,2,17,29,48,1
    v_ln    .-vet

.text
    .global main
main:
    //leggo la stringa
    movl    $3,%eax
    movl    $0,%ebx
    movl    $vet,%ecx
    movl    $v_ln,%edx
    int     0x80
    
    movl    $v_ln,%edi
loop:
    //metto $vet[%edi] in ECX
    movl    $vet,%ecx
    movl    %edi,%ecx

    //stampo $vet[%edi]
    movl    $4,%eax
    movl    $1,%ebx
    movl    $1,%edx
    int     $0x80

    //decremento EDI finche non arrivo a 0, poi esco dal ciclo
    decl    %edi
    cmpl    $-1,%edi
    jne     loop

    movl    $1,%eax
    movl    $0,%ebx
    int     $0x80
