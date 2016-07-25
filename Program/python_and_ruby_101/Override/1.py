class C1:
    def m(self) :
        return 'parent'

class C2(C1) :
    def m(self) :
        return super().m() +' child'
        #return 'child'
    #메소드가 존재하지 않는 클래스엔 pass 남김
        pass

o = C2()
print(o.m())
