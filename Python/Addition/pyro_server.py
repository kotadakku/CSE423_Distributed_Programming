import Pyro4

class Server(object):
    @Pyro4.expose
    def Addition(self, a, b):
        return a+b


def startServer():
    server = Server()
    daemon = Pyro4.Daemon()
    ns = Pyro4.locateNS()
    uri = daemon.register(server)
    ns.register("server", uri)
    print("Ready. Object uri =", uri)
    daemon.requestLoop()


if __name__ == '__main__':
    startServer()

