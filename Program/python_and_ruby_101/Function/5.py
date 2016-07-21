input_id = input("id를 입력해주세요 \n")

def login(_id):
    members = ['egoing','k8805']
    for member in members :
        if(member == _id) :
            return True
    return False

if login(input_id) :
    print('hello '+input_id)
else :
    print('who are you?')
