#Mattia Audisio 4C
import random

def NellIntervallo(Lista, LimiteInferiore, LimiteSuperiore):
  Conteggio = 0
  for Numero in Lista:
    if LimiteInferiore < Numero < LimiteSuperiore:
      Conteggio = Conteggio + 1
  return Conteggio 

def ListaCasuale(Lungh):
  s = [0] * Lungh
  for i in range(Lungh):
    s[i] = random.random()
  return s 

Lista=ListaCasuale(10000)
NumIntervalli = 8
Conteggio = [0] * NumIntervalli
for i in Lista:
  Indice = int(i * NumIntervalli)
  Conteggio[Indice] = Conteggio[Indice] + 1 

#NumIntervalli=12
#Lista=ListaCasuale(10000)
#Conteggio=[0]*NumIntervalli
#AmpiezzaIntervallo=1.0/NumIntervalli
#for i in range(NumIntervalli):
#  LimiteInferiore=i*AmpiezzaIntervallo
#  LimiteSuperiore=LimiteInferiore+AmpiezzaIntervallo
#  Conteggio[i]=NellIntervallo(Lista,LimiteInferiore,LimiteSuperiore)
print(Conteggio)
