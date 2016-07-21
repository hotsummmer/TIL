input_id=input("id를 입력해주세요 \n")

# real_emmgoing = 11
# real_k8805 = "ab"
members = ['egoing','k8805']

# if real_egoing == in_str :
#   print("hello, egoing!")
# elif real_k8805 == in_str :
#   print("hello, k8805!")
# else :
#   print("who are you?")

for member in members :
    if(input_id == member) :
        print("Hello! "+ member)
        import sys
        sys.exit()
    # else :
    #     print("Who are you?")
    #     break
print("who are you?")
