//dato un vettore di n elementi individuare il maggiore
.data
        vettore     .long  4,12,45,67,1,89,
        mag         .long  2 

.text
    .global main

main:
    movl $0,%edi
loop:
    
    movl    vettore(,%edi,4),%eax 
    cmpl    mag,%eax
    jge     maggiore




maggiore:
    
    movl    
    cmpl    6,%edi
    jge     loop
    jge     end        
       
end:
    movl    $4,%eax
    movl    $1,%eax
    movl    $mag,%eax
    movl    $3,%eax
    int     $0x80 
