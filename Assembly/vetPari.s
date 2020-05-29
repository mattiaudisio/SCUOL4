.data
    vet1:   .long 1,2,3,4,5,6,7,8,9,10
.text
    .global main
main:
xorl    %edx,%edx
movl    $0,%edi
movl    $10,%esi
loop:
    cmpl    $0,%esi
    je      fine
    decl    %esi
    movl    vet1(,%edi,4),%eax
    movl    $2,%ebx
    divl    %ebx
    cmpl    $0,%edx
    je      incremento
    incl    %edi
    jmp     loop
incremento:
    movl    vet1(,%edi,4),%eax
    incl    %eax
    movl    %eax,vet1(,%edi,4)
    incl    %edi
    jmp     loop
fine:
    movl    $0,%edi
loop1:
    movl    vet1(,%edi,4),%ecx
    incl    %edi    
    cmpl    $10,%edi
    jne     loop1

    movl    $1,%eax
    movl    $0,%ebx
    int     $0x80
