class Automobile:
    def __init__(self, nome, modello):
        self.setNome(nome)
        self.setModello(modello)
        self.setMotore(False)
        self.objCambio = Cambio()

    def accendiMotore(self):
        self.setMotore(True)

    def spegniMotore(self):
        self.setMotore(False)

    def monitor(self):
        if self.motore:
            print("La macchina è accesa")
        else:
            print("La macchina è spenta")

    def cambia(self, cambia):
        self.objCambio.cambia(cambia, self.getMotore())

    def setNome(self, nome):
        self.nome = nome

    def getNome(self):
        return self.nome

    def setMotore(self, motore):
        self.motore = motore

    def getMotore(self):
        return self.motore

    def setModello(self, modello):
        self.modello = modello

    def getModello(self):
        return self.modello


class Cambio:
    def __init__(self):
        self.cambio = 0  # É IN FOLLE !!1!

    def cambia(self, cambia, motore):
        if not motore:
            print("Pirla la macchina è spenta, guarda che non puoi cambiare marcia")
        else:
            if cambia:
                if 0 <= self.cambio < 5:
                    self.cambio = self.cambio + 1
                    self.stampaMarcia()
                elif self.cambio == 5:
                    self.stampaErrori()
            else:
                if self.cambio > 1:
                    self.cambio = self.cambio - 1
                    self.stampaMarcia()
                else:
                    self.stampaErrori()

    def stampaMarcia(self):
        print("Sei in {0}°".format(self.cambio))

    def stampaErrori(self):
        if self.cambio == 5:
            print("Oh guarda che sei in quinta")
        else:
            print("É IN FOLLE !!1!")
