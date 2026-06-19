import java.beans.*;

public class StudentBean {

private String name; private int age;

private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

public String getName() { return name;
}

public void setName(String newName) { String oldName = this.name;
this.name = newName;
pcs.firePropertyChange("name", oldName, newName);
}

public int getAge() { return age;
}

public void setAge(int newAge) throws PropertyVetoException { int oldAge = this.age;

vcs.fireVetoableChange("age", oldAge, newAge); this.age = newAge;
pcs.firePropertyChange("age", oldAge, newAge);
}

public void addPropertyChangeListener(PropertyChangeListener l) {
pcs.addPropertyChangeListener(l);
}

public  void  addVetoableChangeListener(VetoableChangeListener l) {
vcs.addVetoableChangeListener(l);
}
public static void main(String[] args) { StudentBean s = new StudentBean(); s.addPropertyChangeListener(evt -> {
System.out.println("Property Changed: " +evt.getPropertyName() + " from " + evt.getOldValue() + " to " + evt.getNewValue());});
 

 


s.addVetoableChangeListener(evt -> { if ((int) evt.getNewValue() < 18) {
throw new PropertyVetoException("Age must be >= 18", evt);
}
});

try { s.setName("Harsh");
 s.setAge(20);
s.setAge(15);

} catch (PropertyVetoException e) { System.out.println("Change Vetoed: " + e.getMessage());
}
}
}
