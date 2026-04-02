# Introduction to Facade

With the **Facade Pattern** you can take a complex subsystem and make it easier to use by implementing a Facade class that provides one, more reasonable interface.

The Facade still leaves the subsystem accessible to be used directly. If you need the advanced functionality of the subsystem classes, they are available for your use.

---

To use the Facade Pattern, we create a class that simplifies and unifies a set of more complex classes that belong to some subsystem. Unlike a lot of patterns, Facade is fairly straightforward. It allows us to avoid tight coupling between clients and subsystems.

---

# The Facade Pattern Defined

**The Facade Pattern** provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

The definition tells us loud and clear that the purpose of the facade is to make the subsystem easier for use through a simplified interface.

---

# Design Principle: The Principle of Least Knowledge

**Principle of Least Knowledge** - talk only to your immediate friends. It means when you are designing a system, for any object, be careful of the number of classes it interacts with and also how it comes to interact with those classes.

This principle prevents us from creating designs that have a large number of classes coupled together so that changes in one part of the system cascade to other parts. When you build a lot of dependencies between many classes, you are building a fragile system that will be costly to maintain and complex for others to understand.

**Guidelines** for applying this principle: take any object, and now from any method in that object, the principle tells us that we should only invoke methods that belong to:

- The object itself
- Objects passed in as parameter to the method
- Any object the method creates or instantiates
- Any components of the object