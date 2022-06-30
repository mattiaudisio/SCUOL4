import PyPDF2

listAnimals = ['canne', 'gatto', 'tigre', 'lince', 'rinoceronte']

animal = int(input("Inserisci il numero dell'indice che vuoi stampare "))
print(listAnimals[animal] + "\n")

listAnimals.append('cinghiale mannaro vegano')

for animal in listAnimals:
    print(animal)

animale1 = str(input("\nInserisci il nome di un animale: "))
animale2 = str(input("Inserisci il nome di un animale: "))
animale3 = str(input("Inserisci il nome di un animale: "))

listAnimals.append(animale1)
listAnimals.append(animale2)
listAnimals.append(animale3)
print("\nAnimali Aggiunti")

for animal in listAnimals:
    print(animal)
