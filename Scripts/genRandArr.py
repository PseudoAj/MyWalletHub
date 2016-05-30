#Import stuff
from random import randint
arr=""
for i in xrange(10):
    arr=arr+","+str(randint(-100,100))
print arr
