import turtle

t = turtle.Pen()
ts = t.getscreen()
t.color('Blue')


def muovi():
    t.forward(20)


def giraAntiorario():
    t.left(90)


def giraOrario():
    t.right(90)

ts.onkey(muovi, "space")
ts.onkey(giraAntiorario, "Left")
ts.onkey(giraOrario, "Right")
ts.listen()

t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.right(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(200)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(200)
t.right(90)
t.forward(100)
t.right(90)
t.forward(100)
t.right(90)
t.up()
t.forward(300)
t.down()
t.color('Red')

r = 10

n = 9

for i in range(90):
    t.circle(r + i, 45)

t.left(90)
t.up()
t.forward(500)
t.down()
t.color('Green')

for i in range(8):
    t.forward(100)
    t.right(135)

turtle.done()
