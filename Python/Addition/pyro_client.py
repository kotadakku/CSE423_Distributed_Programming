import Pyro4

server = Pyro4.Proxy("PYRONAME:server")

print("Result : ",server.Addition(9,10))