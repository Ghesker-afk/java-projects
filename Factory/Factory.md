# Introduction to Factory

When you use **new**, you are certainly instantiating a concrete class, so that is definitely an implementation, not an interface. If your code is written to an interface, then it will work with any new classes implementing that interface through polymorphism. However, when you have code that makes use of lots of concrete classes, you may have to change it as new concrete classes are added.

**Factories** handle the details of object creation. Any time we need an object, then we will ask to the factory to make one; it has encapsulated our object creation.

**Design Principle Followed**: Identify the aspects that vary and separate them from what stays the same. Our code must be closed for modification, but open for extension (this is **another** principle), so that we can extend it with new concrete types without modifying an already existing code.

By encapsulating the object creating in one class, we now have only one place to make modifications when the implementation changes. We are also just about to remove the concrete instantiations from our client code.

---