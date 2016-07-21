puts("id를 입력해주세요")
in_str = gets.chomp()
real_egoing = "egoing"
real_k8805 = "k8805"

if real_egoing == in_str or real_k8805 == in_str
  puts("hello, "+ in_str + "!")
else
  puts("who are you?")
end
