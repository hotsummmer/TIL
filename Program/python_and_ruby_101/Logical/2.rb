puts("id를 입력해주세요")
input_id = gets.chomp()
puts("비밀번호를 입력해주세요")
input_pw = gets.chomp()
real_id = "egoing"
real_pw = "11"

if real_id == input_id
  if real_pw == input_pw
    puts("hello, egoing!")
  else
    puts("Wrong Password:(")
  end
else
  puts("Wrong Id")
end
