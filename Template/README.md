## Encapsulating Algorithms

In our code, **prepareRecipe()** is our **template method**. Why? Well, first because it is a method, and second, it serves as a template for an algorithm; in this case, an algorithm for making caffeinated beverages.

In the template, each step of the algorithm is represented by a method, and some methods are handled by the class, and some are handled by the subclass. The methods that need to be supplied by a subclass are declared abstract.

**The Template Method** defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps. The template method controls the algorithm; at certain points in the algorithm, it lets the subclass supply the implementation of the steps.

The prepareRecipe() method controls the algorithm, no one can change this, and it counts on subclasses to provide some or all of the implementation.

---

## The Template Method Pattern Defined

**The Template Method Pattern** defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

This pattern is all about creating a template for an algorithm. A template is just a method that defines an algorithm as a set of steps. One or more of these steps is defined to be abstract and implemented by a subclass. This ensures the algorithm's structure stays unchanged, while subclasses provide some part of the implementation.

- The **AbstractClass** contains the template method and abstract versions of the operations used in the template method.

- The **template method** makes use of the **primitiveOperations** to implement an algorithm. It is decoupled from the actual implementation of these operations.

- There may be many **ConcreteClasses**, each implementing the full set of operations required by the template method. The ConcreteClass implements the **abstract operations**, which are called when the templateMethod() needs them.

```
// Here we have our abstract class; it is declared abstract and meant to be subclassed by classes that provide implementations of the operations

abstract class AbstractClass {

    // Here is the template method. It's declared final to prevent subclasses from reworking the sequence of steps in the algorithm

    final void templateMethod() {
        
        // The template method defines the sequence of steps, each represented by a method

        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    // In this example, two of the primitive operations must be implemented by concrete subclasses

    abstract void primitiveOperation1();
    abstract void primitiveOperation2();

    // We also have a concrete operation defined in the abstract class. More about these kinds of methods in a bit.

    // A concrete operation is defined in the abstract class. This one is declared final so that subclasses can't override it. It may be used in the template method directly, or used by subclasses
    
    final void concreteOperation() {
        // implementation here
    }

    // A concrete method, but it does nothing!

    // We can also have concrete methods that do nothing by default; we call these "hooks". Subclasses are free to override these but don't have to. We are going to see how these are useful later

    void hook() {}
}
```

---

# Hooked on Template Method...

A **hook** is a method that is declared in the abstract class, but only given an empty or default implementation. This gives subclasses the ability to "hook into" the algorithm at various points, if they wish; a subclass is also free to ignore the hook.

Use abstract methods when your subclass MUST provide an implementation of the method or step in the algorithm. Use hooks when that part of the algorithm is optional. With hooks, a subclass may choose to implement that hook, but it doesn't have to.

A hook may provide a way for a subclass to implement an optional part of an algorithm, or if it isn't important to the subclass's implementation, it can skip it.

Each concrete subclass defines the entire set of abstract methods and provides a complete implementation of the undefined steps of the template method's algorithm.

---

## The Hollywood Principle - Don't call us, we'll call you.

**The Hollywood Principle** gives us a way to prevent "dependency rot". Dependency rot happens when you have high-level components depending on low-level components depending on high-level components depending on sideways components depending on low-level components, and so on.

With the Hollywood Principle, we allow low-level components to hook themselves into a system, but the high-level components determine when they are needed, and how. In other words, the high-level components give the low-level components a "don't call us, we'll call you" treatment.

- CaffeineBeverage is our high-level component. It has control over the algorithm for the recipe, and calls on the subclasses only when they are needed for an implementation of a method

- Clients of beverage will depends on the CaffeineBeverage abstraction rather than a concrete Tea or Coffee, which reduces dependencies in the overall system

- The subclasses are used simply to provide implementation details. Tea and Coffee never call the abstract class directly without being "called" first

The **Dependency Inversion Principle** teaches us to avoid the use of concrete classes and instead work as much as possible with abstractions. The Hollywood Principle is a technique for building frameworks or components so that lower-level components can be hooked into the computation, but without creating dependencies between the lower-level components and the higher-level layers.


# Template Method and Strategy Patterns

The **Template Method Pattern** define the outline of an algorithm, and let subclasses do some of the work; it can have different implementations of an algorithm's individual steps, but keep control over the algorithm's structure. All of the duplicated code gets put into the superclass, so all the subclasses can share it.

The **Strategy Pattern** define a family of algorithms and make them interchangeable. Since each algorithm is encapsulated, the client can use different algorithms easily. It is more flexible, because it uses object composition; the clients can change their algorithms at runtime smply by using a different strategy object.