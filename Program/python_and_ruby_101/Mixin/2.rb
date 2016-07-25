module Multiply
  def multiply()
    return @v1 * @v2
  end
end
module Divide
  def divide()
    return @v1 * @v2
  end
end
class Cal
  include Multiply, Divide
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
end

c = Cal.new(100,10)
p c.add()
p c.multiply()
p c.divide()

# c2 = CalDivide.new(10,10)
# c2 = c1.add()
# c2 = c1.multiply()
