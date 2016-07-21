class Cal
  def initialize(v1,v2)
    #생성자 : 인스턴스 만들어질 때 반드시 실행되어야 하는 내용
    p v1, v2
    @v1 = v1
    @v2 = v2
  end
  def add()
    return @v1+@v2
  end
  def subtract()
    return @v1-@v2
  end
  def getValue()
    return @value
  end
  def setV1(v)
    if v.is_a?(Integer)
      @v1 = v
    end
  end
  def getV1()
    return @v1
  end
end

c1 = Cal.new(10,10)
p(c1.add())
p(c1.subtract())
c1.setV1('하이')
c1.add()
c2 = Cal.new(30,20)
p(c2.add())
p(c2.subtract())
