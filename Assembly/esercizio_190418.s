.data
    st:       .long 0 
    st2:      .long 0 
    stmax:    .long 0 

    s_len=    .-st
    s_len2=    .-st2
    s_len3=    .-st3

.text
        .global main
main:
    movl    $3,%eax
    movl    $0,%ebx
    movl    $st,%ecx
    movl    $3,%edx
    int     $0x80   

    movl    $3,%eax
    movl    $0,%ebx
    movl    $st2,%ecx
    movl    $3,%edx
    int     $0x80   

    movl    st,%eax
    movl    $st2,%ebx
    cmpl    $eax,%ebx
    jge     step
    cmpl    $eax,%stmax
    jmp     step2
    int     $0x80 

step:
    movl   %st2,stmax

step2:  
    //inserisci il terzo numero
    movl    $3,%eax
    movl    $0,%ebx
    movl    $st,%ecx
    movl    $3,%edx
    int     $0x80   

    //confronto con il max
    movl    st,%eax
    cmpl    %eax,stmax
    jge     end
    movl    %eax,stmax

end:
    movl    $4,%eax
    movl    $1,%eax
    movl    $stmax,%eax
    movl    $3,%eax
    int     $0x80 

    movl    $1,%eax
    movl    $0,%eax
    int     $0x80         
