class Cal(object) :
    #생성자
    def __init__(self,v1,v2):
        #첫번째 매개변수 반드시 지정해야하고
        #이름은 상관없지만 뭐든 지정해야 instance로 알아들음
        self.v1 = v1
        self.v2 = v2
    def add(self):
        return self.v1 + self.v2
    def subtract(self):
        return self.v1 - self.v2

c1 = Cal(10,10)
print(c1.add())
print(c1.subtract())

c2 = Cal(30,20)
print(c2.add())
print(c2.subtract())
