class C1
  def m()
    return 'parent'
  end
end

class C2 < C1
  def m()
    return super() + ' child'
  end
end

#파이썬에서 super는 부모 클래스를 나타내지만,
#루비에서 super는 super가 소속되어 있는 메소드와
#동일한 이름을 가진 메소드를 가르킴

o = C2.new()
p o.m()
