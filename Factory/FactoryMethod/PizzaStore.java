public abstract class PizzaStore {

  public Pizza orderPizza(String type) {
    Pizza pizza;

    // Now createPizza is back to being a call to a method in the PizzaStore rather than on a factory object
    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  // Now we have moved our factory object to this method. Our "factory method" is now abstract in PizzaStore
  abstract Pizza createPizza(String type);
}