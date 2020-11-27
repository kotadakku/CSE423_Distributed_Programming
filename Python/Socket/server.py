import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((socket.gethostname(), 1234))
s.listen(5)

while True:
    client, address = s.accept()
    print(f"Connection from {address} has been established.")

    client.send(bytes("Hey there!!!", "utf-8"))
    client.close()