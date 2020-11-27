import socket
import time
import random

s = socket.socket()
port=60002
host = socket.gethostname()
s.connect((host, port))

while True:
    time.sleep(2)
    data_send = []
    for i in range(random.randint(5, 10)):
        data_send.append(str(random.randint(0, 100)))
    data_send = " ".join(data_send)

    print('sending data ...', data_send)
    s.send(data_send.encode())
    print('receiving data ...')
    data = s.recv(2048)
    if not data:
        break
    print(data.decode())


s.close()
print ('connection closed')