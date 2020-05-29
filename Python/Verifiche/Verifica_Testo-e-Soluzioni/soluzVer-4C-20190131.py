import xml.etree.ElementTree as ET
import json

data = json.load(open("rubrica.json"))

print('N° elementi:', len(data))
print(repr(data))

strcsv='nome,numcell,mail\n'
scrivicsv=-1

for item in data:
	print(item," ---> ",data[item])
	if item=='nome':
		strcsv=strcsv+data[item]+','
	if item=='telefono':
		for i in range(0,len(data[item])):
			#print(data[item][i])
			if data[item][i]['tipo']=='cellulare':
				scrivicsv=scrivicsv+1
				strnum=data[item][i]['numero']
				if strnum[:1]=='+':
					strnum=strnum[3:]
				listanum=strnum.split(" ")
				strcsv=strcsv+''.join(listanum)+','
				#print('Tel cell', data[item][i]['numero'])
	if item=='email':
		if 'lavoro' in data[item]:
			scrivicsv=scrivicsv+1
			strcsv=strcsv+data[item]['lavoro']
			print('E-mail lavoro:', data[item]['lavoro'])
if scrivicsv:
	testo=open("outrubrica.csv","w")
	testo.write(strcsv)
	testo.close()
	
root = ET.Element("persona")


tree = ET.ElementTree(root)
tree.write("rubricaout.xml")

