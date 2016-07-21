def f1()
  return 'f1'
end
puts(f1())

def f2
  return 'f2'
end
puts(f2)

def f3
  return 'f3'
end
puts(f3)

def f4(a1)
  return a1
end

puts(f4('f4'))

#매개변수 () 대신 한칸 띄고 쓰기 가능
def f5 a1
  return a1
end
puts(f5 'a1')

puts f5 'f5'


#'return'의 생략 --> 마지막줄 값이 return으로 생각
def f6
  return 'f6'
end
puts f6

def f7
  'f7'
end
puts f7
