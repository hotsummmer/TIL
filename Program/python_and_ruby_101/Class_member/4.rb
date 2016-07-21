class Cal
  attr_reader :v1, :v2
  attr_writer :v1
  @__history = []
  def initialize(v1,v2)
    #생성자 : 인스턴스 만들어질 때 반드시 실행되어야 하는 내용
  @v1 = v1
    @v2 = v2
  end
  def add()
    result = @v1+@v2
    @__history.push("add : #{@v1}+#{@v2}=#{result}")
    return result
  end
  def subtract()
    result = @v1-@v2
    @__history.push("subtract : #{@v1}-#{@v2}=#{result}")
    return result
  def setV1(v)
    if v.is_a?(Integer)
      @v1 = v
    end
  end
  def getV1()
    return @v1
  end
  def Cal.history()
    for item in @@__history
      p item
    end
  end
end


class CalMultiply < Cal
  def multiply()
    result = @v1*@v2
    @__history.push("multiply : #{@v1}*#{@v2}=#{result}")
    return result
  end
end

class CalDivide < CalMultiply
  def divide()
    result = @v1/@v2
    @__history.push("divide : #{@v1}/#{@v2}=#{result}")
    return result
  end
end

c1 = CalMultiply.new(10,10)
p c1.add()
p c1.multiply()

c2 = CalDivide.new(20,10)
c2 = c1.add()
c2 = c1.multiply()
