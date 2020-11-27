import Pyro4
import random

#uri = input("insert the PYRO4 server URI (help : PYRONAME:server) ").strip()
name = input("Size of array : ").strip()
# use name server object lookup uri shortcut
server = Pyro4.Proxy("PYRONAME:server")

a = []
for i in range(int(name)):
    a.append(random.randint(0,100))
print("Chuoi ban dau: ")
for i in a:
    print("{} ".format(i), end ='')

b = server.Sapxep(a)
print("\nChuoi sau khi sap xep: ")
for i in b:
    print("{} ".format(i), end ='')



