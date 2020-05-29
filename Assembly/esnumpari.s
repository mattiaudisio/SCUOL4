// codice ideato per funzionare con solo 3 numeri
.data
    num1:      .long 0
    num2:      .long 0
    num3:      .long 0
    cont:      .long 0

.text
    .global main                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  

main:
     movl   $3,%eax
     movl   $0,%ebx
     movl   $num1,%ecx
     movl   $4,%edx
     int    $0x80
      
     movl   $3,%eax
     movl   $0,%ebx
     movl   $num2,%ecx
     movl   $4,%edx
     int    $0x80

     movl   $3,%eax
     movl   $0,%ebx
     movl   $num3,%ecx
     movl   $4,%edx
     int    $0x80

     movl   num1,%eax 
     divl   2  
     cmpl   $0,%eax
     jge    incrementa   

     movl   num2,%eax 
     divl   2  
     cmpl   $0,%eax
     jge    incrementa

     movl   num3,%eax 
     divl   2  
     cmpl   $0,%eax
     jge    incrementa

incrementa:
     incl    cont      
end:
	movl $4,%eax
	movl $1,%ebx
	movl $cont,%ecx
	movl $3,%edx
	int $0x80
	
	movl $1,%eax
	movl $0,%ebx
	int $0x80	  
