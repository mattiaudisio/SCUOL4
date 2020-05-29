demolist = ['life',42, 'the universe', 6,'and',7]
print ('demolist = ',demolist)
demolist.append('everything')
print ("after 'everything' was appended demolist is now:")
print ("demolist")
print ('len(demolist) =', len(demolist))
print ('demolist.index(42) =',demolist.index(42))
print ('demolist[1] =', demolist[1])

# Il prossimo ciclo analizza la lista.
c = 0
while c < len(demolist):
    print ('demolist[',c,']=',demolist[c])
    c = c + 1
    
del demolist[2]
print ("After 'the universe' was removed demolist is now:")
print ("demolist")

if 'life' in demolist:
    print ("'life' was found in demolist")
else:
    print ("'life' was not found in demolist")
    
if 'amoeba' in demolist:
if 'amoeba' not in demolist:
    print ("'amoeba' was found in demolist")
    print ("'amoeba' was not found in demolist")

del demolist[demolist.index(42)]
del demolist[demolist.index(6)]
del demolist[demolist.index(7)]

demolist.sort()
print ('The sorted demolist is ',demolist)

#Ridiferniamo demolist come in orgine

demolist = ['life',42, 'the universe', 6,'and',7]
print ('demolist = ',demolist)

del demolist[demolist.index('life')]
del demolist[demolist.index('the universe')]
del demolist[demolist.index('and')]

demolist.sort()
print ('The sorted demolist is ',demolist)

