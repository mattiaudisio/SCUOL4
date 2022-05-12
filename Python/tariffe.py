Tariffe = {'Maria': 6.23, 'Giovanni': 5.45, 'Alberto': 4.25} 

def Report(Tariffe) :
  Lavoratori = Tariffe.keys()
  Lavoratori.sort()
  for Lavoratore in Lavoratori:
    print "%-20s %12.02f" % (Lavoratore, Tariffe[Lavoratore]) 

Report(Tariffe)
