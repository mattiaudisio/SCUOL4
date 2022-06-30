import os
import shutil

print("Directory attuale")
print(os.getcwd()+"\n")

print("questo file, 1° modo")
print(__file__+"\n")

print("questo file, 2° modo")
full_path = os.path.realpath(__file__)
print(full_path+"\n")

print("Directory e nome")
path, filename = os.path.split(full_path)
print(path + ' ---> ' + filename+"\n")

listaFIles = os.listdir(r'C:\tmp\sorgente')

for f in listaFIles:
    source = r'C:\Tmp\sorgente\{0}'.format(f)
    target = r'C:\Tmp\destinazione\{0}'.format(f)
    shutil.copyfile(source, target)
    os.remove(source)