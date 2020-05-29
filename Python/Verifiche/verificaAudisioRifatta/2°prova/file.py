import xml.etree.ElementTree as ET
import json

rubrica=json.load(open("file.json"))
persona=ET.Element("persona")
tree=ET.ElementTree(persona)
root=tree.getroot()

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

nome=ET.SubElement(persona,"nome")
nome.text=rubrica['nome']
for i in range(0,len(rubrica['telefono'])):
	telefonino=ET.SubElement(persona,"telefono")
	telefonino.set("tipo",rubrica['telefono'][i])
	telefonino.text=rubrica['telefono'][i][tipo]
Email=ETmSubElement("email")
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
files.write("nome,numero del cellulare,email\n\n")
files.write(rubrica["nome"]+","+cellulareCSV+","+mailCSV)
files.close()
