# Introduction to Factory

When you use **new**, you are certainly instantiating a concrete class, so that is definitely an implementation, not an interface. If your code is written to an interface, then it will work with any new classes implementing that interface through polymorphism. However, when you have code that makes use of lots of concrete classes, you may have to change it as new concrete classes are added.

**Factories** handle the details of object creation. Any time we need an object, then we will ask to the factory to make one; it has encapsulated our object creation.

**Design Principle Followed**: Identify the aspects that vary and separate them from what stays the same. Our code must be closed for modification, but open for extension (this is **another** principle), so that we can extend it with new concrete types without modifying an already existing code.

By encapsulating the object creating in one class, we now have only one place to make modifications when the implementation changes. We are also just about to remove the concrete instantiations from our client code.

---

A **factory method** handles object creation and encapsulates it in a **subclass**. This decouples the client code in the superclass from the object creation code in the subclass.

**abstract Product factoryMethod(String type)**

- A factory method is abstract so the subclasses are counted on to handle object creation.
- A factory method returns a Product that is typically used within methods defined in the superclass.
- A factory method isolates the client from knowing what kind of concrete Product is actually created.
- A factory method may be parameterized (or not) to select among several variations of a product.

---

# The Factory Method Pattern Defined

**The Factory Method Pattern** defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

- All products must implement the same interface so that the classes which use the products can refer to the interface, not the concrete class.

- The **Creator** is a class that contains the implementations for all of the methods to manipulate products, except for the factory method.

- The abstract **factoryMethod()** is what all Creator subclasses must implement.

- The **ConcreteCreator** implements the factoryMethod(), which is the method that actually produces products. It is the responsible for creating one or more concrete products. It is the only class that has the knowledge of how to create these products.