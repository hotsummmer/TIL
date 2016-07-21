class Cs
  def Cs.class_method
    p 'Class method called'
  end
  def instance_method
    p 'Instance method'
  end
end


i = Cs.new()

Cs.class_method()
#Cs.instance_method()
i.instance_method()
#i.class_method()
