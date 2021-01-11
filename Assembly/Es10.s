.data
    str:    .space 30
    
    s_len = .-str
    
    nline:  .string "\n"

.text

    .global main
main:

    movl    %3,%eax
    movl    $0,%ebx
    movl    $str,%ecx
    movl    $s_len,%edx
    int     $0x80
    
    movl    $s_len,%edi
    
loop:

    movl    $str,%ecx
    addl    %edi,%ecx
    
    movl    $4,%eax
    movl    $1,%ebx
    movl    $1,%edx
    int     $0x80

    decl    %edi
    cmpl    $-1,%edi
    jne     loop
    
    movl    $1,%eax
    movl    $0,%ebx
    int     $0x80
