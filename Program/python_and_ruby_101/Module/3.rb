#파일 분리 안하고 모듈 만들기
module Egoing #모듈 이름은 반드시 대문자
  module_function()
  def a()
    return 'a'
  end
end

module K88091
  module_function()
  def a()
    return 'B'
  end
end

puts(Egoing.a())
puts(K88091.a())
