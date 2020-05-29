import xml.etree.ElementTree as ET
import json

tagMail=[]

persona=ET.Element("persona")
tree=ET.ElementTree(persona)
root=tree.getroot()
rubrica=json.load(open("file.json"))


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

#CREO FILE XML
nome=ET.SubElement(persona,"nome")
nome.text=rubrica["nome"]
for i in range(0,len(rubrica["telefono"])):
	telefonino=ET.SubElement(persona,rubrica["telefono"][i]["tipo"])
	telefonino.text=rubrica["telefono"][i]["numero"]
	if rubrica["telefono"][i]["tipo"]=="cellulare":
		cellulareCSV=rubrica["telefono"][i]["numero"]
		a,b,c,d,e=cellulareCSV.split()
		b=b+c+d+e
mail=ET.SubElement(persona,"email")
for i in range(0,len(rubrica["email"])):
	Email=rubrica["email"]
	for i in Email.keys():
		tagMail.append(i)
for i in range (0,len(rubrica["email"])):
	email=ET.SubElement(mail,tagMail[i])
	email.text=rubrica["email"][tagMail[i]]
	if tagMail[i]=="lavoro":
		mailCSV=rubrica["email"][tagMail[i]]
indent(root)
tree.write("rubrica.xml")

#CREO IL FILE CSV
files=open("file.csv","w")
files.write("nome, numero del cellulare, email\n\n")
files.write(rubrica["nome"]+","+b+","+mailCSV)
files.close()
