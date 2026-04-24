A **constructor** does look and feel a lot like a method, but it's not a method. It's got the code that runs when you say **new**. In other words, the code that runs when you instantiate an object.

A **constructor** has the code that runs when you instantiate an object. In other words, the code that runs when you say **new** on a class type. Every class you write has a constructor, even if you don't write it yourself.

You can write a constructor for your class, but if you don't, the compiler writes one for you! Its name is the same as the class - that's mandatory -, and it doesn't have a return type (between the access modifier and the name).

Java lets you declare a method with the same as your class. That doesn't make it a constructor, though. The thing that separates a method from a constructor is the **return type**. Methods must have a return type, but constructors can not have a return type!

```
public Duck() { } // Constructor

public void Duck() { } // Method
```

The key feature of a constructor is that it runs **before the object can be assigned to a reference**. That means you get a chance to step in and do things to get the object ready for use. In other words, before anyone can use the remote control for an object, the object has a chance to help construct itself.

The best place to put initialization code is in the constructor. And all you need to do is make a constructor with arguments. You can make a new object and set its instance variables values in one statement.

Always provide a **no-arg constructor** if you can, to make it easy for programmers to make a working object. Supply default values.

The compiler gets involved with constructor-making only if you don't say anything at all about constructors. If you write a constructor that takes arguments and you still want a no-arg constructor, you'll have to build the no-arg constructor yourself. As soon as you provide a constructor, ANY kind of constructor, the compiles backs off and says, "OK fair enough, looks like you're in charge of constructors now."

**Overloaded constructors** means you have more than one constructor in your class. To compile, each constructor must have a different argument list. It's the variable type (int, boolean, Dog, etc) and order that matters; you can have two constructors that have identical types, as long as the order is different. A constructor that takes a String followed by an int is not the same as one that takes an int followed by a String.

```
public class Mushroom {
    // Five different constructors means five different ways to make a new mushroom.

    public Mushroom(int size) { }

    public Mushroom() { }

    public Mushroom(boolean isMagic) { }

    public Mushroom(boolean isMagic, int size) { }

    public Mushroom(int size, boolean isMagic) { }
}
```

---

When an object is created (because somebody said **new**; there is no other way to create an object other than someone, somewhere saying new on the class type), the object gets space for all the instance variables from all the way up the inheritance tree.

All the constructors in an object's inheritance tree must run when you make a new object. That means every superclass has a constructor (because every class has a constructor), and each constructor up the hierarchy runs at the time an object of a subclass is created.

Even abstract classes have constructors. Although you can never say new on an abstract class, an abstract class is still a superclass, so its constructor runs when someone makes an instance of a concrete subclass.

The only way to call a superclass constructor is by calling **super()**. That's right - super() calls the superclass constructor. A call to super() in your constructor puts the superclass constructor on the top of the Stack. The compiler puts in a call to super() if you don't.

```
// If you don't provide a constructor, the compiler puts one in that looks like:
public ClassName() {
    super();
}
```

If you do provide a constructor but you do not put in the call to super(), the compiler will put a call to super() in each of your overloaded constructors. The compiler-inserted call to super() is always a no-arg call (super()). If the superclass has overloaded constructors, only the no-arg constructor is called.

The superclass parts of an object have to be fully formed (completely built) before the subclass parts can be constructed. Remember, the subclass object might depend on things it inherits from the superclass, so it's important that those inherited things be finished. The superclass constructor must finish before its subclass constructor.

Each subclass constructor immediately invokes its own superclass constructor, until the Object constructor is on the top of the Stack. Then Object's constructor completes, and we bounce back down the Stack to Animal's constructor. Only after Animal's constructor completes do we finally come back down to finish the rest of the Hippo constructor. For that reason: the call to **super()** must be the first statement in each constructor!

Use **this()** to call a constructor from another overloaded constructor in the same class. The call to this() can be used only in a constructor, and must be the first statement in a constructor. A constructor can have a call to super() OR this(), but never both!

An object's life depends entirely on the life of references referring to it. If the reference is considered "alive", the object is still alive on the Heap. If the reference dies, the object will die.

A **local variable** lives only within the method that declared the variable. A local variable is alive as long as its Stack frame is on the Stack. In other words, until the method completes. A local variable is in scope only within the method in which the variable was declared. When its own method calls another, the variable is alive, but not in scope until its method resumes. You can use a variable only when it is in scope!

```
public void read() {
    int s = 42;
    // "s" can be used only within this method. When this method ends, "s" disappears completely.
}

// Variable "s" can be used only within the read() method. In other words, the variable is in scope only within its own method. No other code in the class (or any other class) can see "s".
```

An **instance variable** lives as long as the object does. If the object is still alive, so are its instance variables.

```
public class Life {
    int size;

    public void setSize(int s) {
        size = s;
        // "s" disappears at the end of this method, but "size" can be used anywhere in the class
    }
}

// Variable "s" (this time a method parameter) is in scope only within the setSize() method. But instance variable "size" is scoped to the life of the object as opposed to the life of the method.
```

The rules are the same for primitives and references. A reference variable can be used only when it's in scope, which means you can't use an object's remote control unless you've got a reference variable that is in scope.

Once an object is eligible for garbage collection (GC), you don't have to worry about reclaiming the memory that object was using. If your program gets low on memory, GC will destroy some or all of the eligible objects, to keep you from running out of RAM. An object becomes eligible for GC when **its last live reference disappears**.

When you set a reference to **null**, you are deprogramming the remote control. In other words, you have got a remote control, but no TV at the other end. A null reference has bits representing "null". In Java, you can't press the buttons (i.e., use the dot operator) on a null reference; if you use the dot operator an a null reference, you will get a **NullPointerException** at runtime.

---

- **State** are values kept in instance variables.
- **Behavior** are algorithms inside methods.
- Instance variables lives on the Heap, within the objects they belong to, and they live as long as the object do.
- Local variables lives inside Stack frames with all the other local variables. When the method is blown off the Stack, all the local variables inside it are removed as well.