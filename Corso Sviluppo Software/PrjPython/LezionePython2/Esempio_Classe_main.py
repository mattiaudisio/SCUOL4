# From Esempio_Classe_Auto import Automobile
import Esempio_Classe_Auto as auto

automobile1 = auto.Automobile("Fiat", "Panda 1450")
automobile1.accendiMotore()

i = 0
while i < 6:
    automobile1.cambia(True)
    i = i + 1
i = 0
while i < 5:
    automobile1.cambia(False)
    i = i + 1