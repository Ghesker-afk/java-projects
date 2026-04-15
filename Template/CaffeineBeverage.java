/* Annotations:

- The boilWater() and pourInCup() methods are shared by both subclasses (Coffee and Tea), so they are defined in the superclass

- the prepareRecipe() method differs in each subclass, so it is defined as abstract

- Each subclass implements its own recipe; each subclass override the prepareRecipe() method and implements its own recipe

We have recognized that the two recipes are essentially the same, although some of the steps require different implementations. So we have generalized the recipe and placed it in the base class

Caffeine Beverage knows and controls the steps of the recipe, and performs steps 1 and 3 itself, but relies on Tea or Coffee to do steps 2 and 4

*/

public abstract class CaffeineBeverage {

  // Now, the same prepareRecipe() method will be used to make both Tea and Coffee. prepareRecipe() is declared final because we don't want our subclasses to be able to override this method and change the recipe

  public final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  // Because Coffee and Tea handle these methods in different ways, they're going to have to be declared as abstract. Let the subclasses worry about that stuff
  public abstract void brew();
  public abstract void addCondiments();

  public void boilWater() {
    System.out.println("Boiling water");
  }

  public void pourInCup() {
    System.out.println("Pouring into cup");
  }
}