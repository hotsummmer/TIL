import auth

input_id = input("id를 입력해주세요 \n")

if auth.login(input_id) :
    print('hello '+input_id)
else :
    print('who are you?')
