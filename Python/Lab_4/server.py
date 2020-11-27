import socket
from _thread import *

port=60002
s = socket.socket()
host = socket.gethostname()
s.bind((host, port))
s.listen(15)
print('Server listening ....')


def Sapxep(x):
    for i in range(len(x) - 1):
        for j in range(i, len(x)):
            if int(x[j]) % 2 == 0:
                c = x[i]
                x[i] = x[j]
                x[j] = c
                break
    return x

def threaded_client(connection):
    while True:
        data = conn.recv(2048)
        if not data:
            break
        x = data.decode()
        a = x.split()
        b = Sapxep(a)
        str_send = " ".join(b)
        conn.send(str_send.encode())
    connection.close()


while True:
    conn, addr = s.accept()
    print('Connected to: ' + addr[0] + ':' + str(addr[1]))
    start_new_thread(threaded_client, (conn,))
    print('Got connection from', addr)

s.close()



