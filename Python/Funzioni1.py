a = 23
b = -23

def my_abs(num):
	if num<0:
		num=-num
	return num

if my_abs(a) == my_abs(b):
	print("The absolute values of",a,"and",b,"are equal")
else:
	print("The absolute values of",a,"and",b,"are different")
