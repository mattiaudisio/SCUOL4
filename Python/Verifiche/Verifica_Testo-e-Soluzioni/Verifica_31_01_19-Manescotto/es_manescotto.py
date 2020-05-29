import xml.etree.ElementTree as ET
import json

def creaxml():
	flag=0
	nome=ET.SubElement(persona,"nome")
	nome.text=data["nome"]
	lTelefoni=[]
	lTelefoni=data["telefono"]
	for i in range(len(lTelefoni)):
		telefono=ET.SubElement(persona,"telefono")
		telefono.set("tipo",lTelefoni[i]["tipo"])
		telefono.text=lTelefoni[i]["numero"]
		if(lTelefoni[i]["tipo"]=="cellulare"):
			#lCSV=[]
			flag=1
			lCSV.append(data["nome"])
			num=lTelefoni[i]["numero"]
			num=num[4:]
			num=num.replace(" ","")
			lCSV.append(num)

	mail=data["email"]
	lEmail=[]
	for x in mail.keys():
		lEmail.append(x)
		
	if ((len(mail))>0):
		email=ET.SubElement(persona, "email")
		for i in range(len(mail)):
			tipoMail=ET.SubElement(email,lEmail[i])
			tipoMail.text=mail[lEmail[i]]
			if((lEmail[i])=="lavoro" and flag==1):
				flag=2
				lCSV.append(tipoMail.text)	
	return flag


def creaFile():
	f=open("rubrica.CSV","w")
	f.write("nome,numcell,mail\n")
	f.close()
	f=open("rubrica.CSV","a")
	f.write(str(lCSV[0]))
	f.write(",")
	f.write(str(lCSV[1]))
	f.write(",")
	f.write(str(lCSV[2]))
	f.close()


def indent(elem, level=0):
    i = "\n" + level*"  "
    if len(elem):
        if not elem.text or not elem.text.strip():
            elem.text = i + "  "
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
        for elem in elem:
            indent(elem, level+1)
        if not elem.tail or not elem.tail.strip():
            elem.tail = i
    else:
        if level and (not elem.tail or not elem.tail.strip()):
            elem.tail = i


data = json.load(open("persona.JSON"))

persona=ET.Element("persona")
tree=ET.ElementTree(persona)
root=tree.getroot()
lCSV=[]

flag=0	#flag per controllare se la persona ha il cellulare e una mail di lavoro
flag=creaxml()
			
if(flag==2):
	creaFile()

indent(root)
tree.write("biblioteca.xml",encoding="utf-8")
