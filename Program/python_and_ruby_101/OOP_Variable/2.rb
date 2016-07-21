class C
  def initialize(v)
    @value = v
  end
  def getValue()
    return @value
  end
  def setValue(v)
    @value = v
  end
end

c1 = C.new(10)

#루비에서는 Clss 변수에 직접 접근x
#p c1.value (x)
#c1.value = 20 (x)
p c1.getValue()
p c1.setValue(20)
p c1.getValue()
