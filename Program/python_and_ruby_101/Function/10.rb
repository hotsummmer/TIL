arr = [1,3,45,34,29,11]

arr.delete_if() do |item|
   #puts item
   item > 11
end
#여러줄일 땐 do~end
#한줄일 땐 {}
puts arr
