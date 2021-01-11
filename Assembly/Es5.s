//Mattia Audisio

.data
      vet:  .long   10,18,24,2,28,1
      max:  .long   0    

.text
     .global main       
main:
    movl    $0,%edi
loop:
    movl    vet(,%edi,6),%eax
    cmpl    %eax,max
    jge     incremento


incremento:
    incl %edi
    cmpl cont

end:
    movl $4,%eax
	movl $1,%ebx
	movl $max,%ecx
	movl $3,%edx
	int $0x80
	
	movl $1,%eax
	movl $0,%ebx
	int $0x80	    
