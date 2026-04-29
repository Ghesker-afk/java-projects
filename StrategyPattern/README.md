Alguém já resolveu os problemas que você está enfrentando. Você vai aprender **por que** (e **como**) pode aproveitar a 
sabedoria e as lições aprendidas por outros desenvolvedores que já percorreram o mesmo caminho de problemas de design — 
e conseguiram chegar até o fim.

Antes de terminarmos, vamos:

- Explorar o uso e os benefícios dos **Design Patterns**
- Analisar alguns princípios fundamentais de **Programação Orientada a Objetos (OO)**
- Percorrer um exemplo de como um padrão funciona na prática

A melhor forma de usar padrões é **carregar sua mente com eles** e, depois, começar a reconhecer situações nos seus
próprios designs e em aplicações existentes onde eles podem ser aplicados. Em vez de reutilização de código, com padrões 
você obtém **reutilização de experiência**.

---

Então, já sabemos que usar **herança** não funcionou muito bem, já que o comportamento dos patos continua variando entre 
as subclasses — e nem todas deveriam possuir esses comportamentos. A ideia das interfaces `Flyable` e `Quackable` parecia 
promissora à primeira vista — apenas os patos que realmente voam seriam `Flyable`, e assim por diante. O problema é que 
**interfaces em Java não possuem implementação**, ou seja, não há reutilização de código. E isso significa que, sempre 
que for necessário modificar um comportamento, você será obrigado a:

- Localizar todas as subclasses onde esse comportamento está definido
- Alterar cada uma delas manualmente
- E, provavelmente, introduzir novos bugs no processo

Felizmente, existe um **princípio de design** pensado exatamente para esse tipo de situação.

## Princípio de Design

**Identifique os aspectos da sua aplicação que variam e separe-os daquilo que permanece igual.**

Em outras palavras, se existe alguma parte do seu código que muda com frequência — por exemplo, a cada novo requisito — 
então você já sabe que encontrou um comportamento que precisa ser **extraído e separado** de tudo aquilo que não muda. 
Outra forma de pensar nesse princípio é:

> Pegue as partes que variam e **encapsule-as**, de modo que você possa alterá-las ou estendê-las posteriormente **sem 
  afetar o restante do sistema**.

Por mais simples que esse conceito pareça, ele forma a base de **praticamente todos os Design Patterns**. Todos os padrões 
fornecem uma maneira de permitir que **uma parte do sistema varie independentemente das outras**.

Pegue o que varia e **encapsule**, para que isso não afete o restante do seu código.

**Resultado:**

- Menos efeitos colaterais indesejados ao modificar o código
- Mais flexibilidade no sistema  

---

## Por onde começamos?

Pelo que podemos observar, tirando os problemas com `fly()` e `quack()`, a classe `Duck` está funcionando bem. Não há 
outras partes que aparentam variar ou mudar com frequência. Portanto, com exceção de algumas pequenas alterações, vamos 
**manter a classe `Duck` praticamente como está**.

Agora, para separar as **“partes que mudam daquelas que permanecem iguais”**, vamos criar **dois conjuntos de classes** 
(totalmente separados de `Duck`):

- Um conjunto para **voo (`fly`)**
- Outro para **grasnar (`quack`)**

Cada conjunto de classes será responsável por conter **todas as implementações possíveis** de seu respectivo comportamento.

Por exemplo, no conjunto de `quack`, poderíamos ter:

- Uma classe que implementa o **grasnar tradicional**
- Outra que implementa um **som de guincho (squeak)**
- E outra que representa **silêncio**

Sabemos que `fly()` e `quack()` são justamente as partes da classe `Duck` que variam entre os diferentes tipos de patos.
Então, para separar esses comportamentos da classe principal, vamos:

- **Remover esses métodos da classe `Duck`**
- **Criar um novo conjunto de classes** para representar cada tipo de comportamento

> 💬 **Nota:** aqui estamos começando a aplicar, na prática, o princípio de *encapsular o que varia*.  
> Em vez de deixar o comportamento preso dentro da hierarquia de herança, vamos isolá-lo em componentes independentes.

---

## Como vamos projetar os comportamentos de voo e grasnar?

Como devemos estruturar o conjunto de classes que implementam os comportamentos de `fly` e `quack`? Queremos manter tudo 
**flexível** — afinal, foi justamente a falta de flexibilidade que nos trouxe problemas anteriormente. Sabemos também que
queremos **atribuir comportamentos às instâncias de `Duck`**. Por exemplo:

- Podemos instanciar um `MallardDuck`
- E inicializá-lo com um tipo específico de comportamento de voo

E já que estamos pensando nisso, por que não garantir que possamos **alterar esse comportamento dinamicamente**? Ou seja, 
devemos incluir métodos *setter* nas classes `Duck` para permitir, por exemplo, mudar o comportamento de voo de um 
`MallardDuck` **em tempo de execução (runtime)**.

Diante desses objetivos, vamos olhar para nosso segundo princípio de design:

## Princípio de Design

**Programe para uma interface, não para uma implementação.**

Vamos usar uma interface para representar cada comportamento — por exemplo:

- `FlyBehavior`
- `QuackBehavior`

E cada implementação concreta desses comportamentos irá implementar uma dessas interfaces. Desta vez, **não serão as classes 
`Duck` que implementarão esses comportamentos**. Em vez disso, criaremos um conjunto de classes cuja única responsabilidade 
é representar um comportamento específico (como, por exemplo, “grasnar” ou “emitir um som de borracha”).

Ou seja:

- A **classe de comportamento** implementa a interface
- A **classe `Duck` apenas usa esse comportamento**

Isso é bem diferente do que fazíamos antes, onde:

- O comportamento vinha de uma implementação concreta na superclasse `Duck`, ou
- Era sobrescrito nas subclasses

Em ambos os casos, estávamos **presos a uma implementação específica**. Não havia espaço para trocar o comportamento 
facilmente — a não ser escrevendo mais código.

Com esse novo design:

- As subclasses de `Duck` passam a usar comportamentos representados por interfaces (`FlyBehavior` e `QuackBehavior`)
- A implementação concreta do comportamento fica **desacoplada da classe `Duck`**

Isso significa que o comportamento pode ser **trocado, estendido ou modificado** sem impactar diretamente as classes de 
pato.

---