class Cal(object) :
    #생성자
    def __init__(self,v1,v2):
        #첫번째 매개변수 반드시 지정해야하고
        #이름은 상관없지만 뭐든 지정해야 instance로 알아들음
        if isinstance(v1, int):
            self.v1 = v
        if isinstance(v2, int):
            self.v2 = v
    def add(self):
        return self.v1 + self.v2
    def subtract(self):
        return self.v1 - self.v2
    def setV1(self,v):
        if isinstance(v, int):
            self.v1 = v
    def getV1(self) :
        return self.v1

c1 = Cal(10,10)
print(c1.add())
c1.v1 =20
c1.v2 =30
print(c1.add())
print(c1.subtract())
