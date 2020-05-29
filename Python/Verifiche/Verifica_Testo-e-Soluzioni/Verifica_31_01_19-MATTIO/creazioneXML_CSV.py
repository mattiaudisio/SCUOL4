import xml.etree.ElementTree as ET
import json
contatti = json.load(open("rubrica.json"))

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
            
def getTagMail():
	mail=contatti["email"]
	tag=[]
	for i in mail.keys():
		tag.append(i)
	return tag

def creaXML():
	persona=ET.Element("persona")
	tree=ET.ElementTree(persona)
	root=tree.getroot()
	nome=ET.SubElement(persona,"nome")
	nome.text=contatti["nome"]
	for i in range(0,len(contatti["telefono"])):
		telefono=ET.SubElement(persona,"telefono")
		telefono.set("tipo",contatti["telefono"][i]["tipo"])
		telefono.text=contatti["telefono"][i]["numero"]
		
	tagMail=getTagMail()
	email=ET.SubElement(persona,"email")
	for b in range(0,len(tagMail)):
		Tagemail=ET.SubElement(email,tagMail[b])
		Tagemail.text=contatti["email"][tagMail[b]]
	indent(root)
	tree.write("rubrica.xml")
	print("\nCreazione del file XML effettuata con successo!")

def creaCSV():
	flag=1
	i = 0
	tagMail=getTagMail()
	f = open("rubrica.csv","w")
	f.write("nome,numcell,mail\n")
	while flag!=0:
		if contatti["telefono"][i]["tipo"] == "cellulare" or len(contatti["telefono"]):
			flag=0
		i+=1
		
	if ("lavoro" in tagMail) and flag==0: 
		string=contatti["telefono"][1]["numero"]
		string=string[4:] # +39 011 9989677
		list = string.split()
		string=""
		for i in range(0,len(list)):
			string+=list[i]
		f.write(contatti["nome"]+","+string+","+contatti["email"][tagMail[1]])
	f.close()
	print("\nCreazione del file CSV effettuata con successo!\n")
			
creaXML()
creaCSV()
