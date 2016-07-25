require_relative 'lib'
#모듈에 속한 클래스를 가져올 때에는 클래스 이름앞에 :: 써줘야함
obj = Lib::A.new()
p obj.a()
