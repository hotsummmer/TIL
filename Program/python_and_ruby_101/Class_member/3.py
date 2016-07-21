#파이썬은 클래스 함수에서 클래스 변수 접근할 땐,
# ==> 클래스이름.변수이름으로 호출
class Cs :
    count = 0
    def __init__(self):
        Cs.count += 1
    @classmethod
    def getCount(cls) :
        #return Cs.count
        return cls.count

i1 = Cs()
i2 = Cs()
i3 = Cs()
i4 = Cs()
print(Cs.getCount())
