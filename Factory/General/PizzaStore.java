public class PizzaStore {
  SimplePizzaFactory factory;

  public PizzaStore(SimplePizzaFactory factory) {
    this.factory = factory;
  }

  public Pizza orderPizza(String type) {
    Pizza pizza;

    // The orderPizza() method uses the factory to create its pizzas by simply passing on the type of the order
    pizza = factory.createPizza(type);

    // Look at the code above
    // Notice that we have replaced the new operator with a create method on the factory object. No more concrete instantiations here!

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}