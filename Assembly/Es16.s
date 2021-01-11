//data una stringa, determinare se è palindroma
//ad esempio: itopinonavevanonipoti

.data
    str:        .string  "anna"
    lung_vet=   .-vet

.text
    .global main
main:
    xorl    %edi,%edi
    movl    $3,%esi   

loop:
    movl    str(%edi),%eax
    movl    str(%esi),%eax
    cmpl    %eax,%ebx
    incl    %edi
    decl    %esi
    je      loop
    jmp     end

end:
    movl    $1,%eax
    movl    $0,%ebx
    int     0x80
