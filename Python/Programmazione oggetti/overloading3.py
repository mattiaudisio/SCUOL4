class Student:  
    def hello(self, name=None):
        if name is not None:
            print('Ciao ' + name)
        else:
            print('ciao ')

# Creating a class instance
std = Student()

# Call the method and Call the method and pass a parameter
name=input("\nInserisci il nome di uno studente: ")
std.hello()
std.hello(name)  
