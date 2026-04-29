# Tipos básicos e variáveis

## Tudo começa com variáveis

Existe uma coisa da qual todo código depende: **variáveis**. Neste capítulo, vamos olhar por debaixo dos panos e mostrar
como as variáveis em Kotlin realmente funcionam. Você vai descobrir os **tipos básicos do Kotlin**, como `Int`, `Float` 
e `Boolean`, e aprender como o compilador consegue **inferir automaticamente o tipo de uma variável** a partir do valor 
que ela recebe. Também verá como usar **String templates** para construir Strings mais complexas com pouquíssimo código,
e aprenderá a criar **arrays** para armazenar múltiplos valores.

## Uma variável é como um copo

Quando você pensa em uma variável em Kotlin, pense em um **copo**. Copos existem em diferentes formatos e tamanhos — 
copos grandes, pequenos, aqueles copos gigantes de pipoca no cinema — mas todos têm algo em comum: **um copo serve para 
armazenar algo**. Declarar uma variável é como fazer um pedido no Starbucks: quando você faz seu pedido, você informa ao 
atendente:

- Qual tipo de bebida deseja
- Qual nome deve ser chamado quando estiver pronta
- E até se quer usar um copo reutilizável ou descartável

Da mesma forma, ao declarar uma variável com um código como:

```kotlin
var x = 5
```

Você está dizendo ao compilador Kotlin:

- Qual valor a variável deve ter
- Qual nome ela deve receber
- E se ela pode ser reutilizada para armazenar outros valores

Para criar uma variável, o compilador precisa saber três coisas:
- **Qual é o nome da variável**, pois isso permite que possamos usá-la no código.
- **Se a variável pode ser reutilizada**; se inicialmente definirmos o valor como 2, podemos depois mudar para 3? Ou o 
valor deve permanecer 2 para sempre?
- **Qual é o tipo da variável**; é um número inteiro `(Int)`? Uma `String`? Ou algo mais complexo?

## O que acontece quando você declara uma variável

O compilador se preocupa bastante com o **tipo de uma variável**, pois isso ajuda a evitar operações estranhas ou 
perigosas que poderiam causar bugs. Por exemplo, ele não permitirá que você atribua a `String` `"Fish"` a uma variável 
inteira, porque sabe que **não faz sentido realizar operações matemáticas com uma String**. Para que essa **segurança de 
tipos (type-safety)** funcione corretamente, o compilador precisa conhecer o tipo da variável. E a boa notícia é que 
ele consegue **inferir esse tipo automaticamente** a partir do valor que é atribuído a ela.

Sintetizando:
Para criar uma variável, o compilador precisa saber:
- **O nome da variável**
- **O tipo da variável**
- **Se ela pode ser reutilizada**

## O valor é transformado em um objeto...

Quando você declara uma variável, o valor que está sendo atribuído a ela é usado para **criar um novo objeto**. Neste 
exemplo, você está atribuindo o número `5` a uma nova variável chamada `x`. O compilador sabe que `5` é um número
inteiro, então o código cria um novo objeto do tipo `Int` com valor `5`:

```kotlin
var x = 5
```

O compilador então usa o **tipo do objeto** para definir o **tipo da variável**. No exemplo anterior, o tipo do objeto 
é `Int`, então o tipo da variável também será `Int`. E esse tipo **permanece fixo para sempre** — você não poderá 
atribuir um valor de outro tipo a essa variável depois. Em seguida, o objeto é atribuído à variável.

Quando um objeto é atribuído a uma variável, o objeto em si **não é armazenado diretamente** dentro da variável. Em vez 
disso, o que é armazenado é uma **referência para o objeto**. Ou seja, a variável funciona como um “apontador” que indica 
onde aquele objeto está na memória. Como a variável guarda essa referência, ela passa a ter **acesso ao objeto**.

---

## `val` vs. `var` 

Se você declarar uma variável usando `val`, a **referência para o objeto permanece fixa** dentro da variável e **não 
pode ser alterada**. Por outro lado, se você usar a palavra-chave `var`, será possível **atribuir um novo valor à 
variável**. Por exemplo, considere o seguinte código:

```kotlin
x = 6
```

Ao fazer isso, um novo objeto Int com valor 6 é criado, e uma referência para esse novo objeto é armazenada em x. Isso 
substitui a referência anterior que apontava para o valor antigo.

Agora que você viu o que acontece ao declarar uma variável, vamos analisar alguns dos tipos básicos do Kotlin, como:

- `Inteiros (Int)`
- `Números de ponto flutuante (Float, Double)`
- `Booleanos (Boolean)`
- `Caracteres (Char)`
- `Strings (String)`

---

## Como declarar explicitamente o tipo de uma variável

Até agora, você viu como criar uma variável atribuindo um valor a ela e deixando que o compilador **infira 
automaticamente o tipo** com base nesse valor. Mas existem situações em que você precisa **declarar explicitamente 
o tipo da variável**. Por exemplo:

- Você pode querer usar `Byte` ou `Short` em vez de `Int`, por serem mais eficientes em certos contextos
- Ou pode querer declarar uma variável no início do código e **atribuir um valor a ela mais tarde**

Em vez de deixar o compilador inferir o tipo, você pode especificá-lo manualmente colocando:

- **Dois pontos (`:`)** após o nome da variável
- Seguidos do **tipo desejado**

Por exemplo:

```kotlin
var smallNum: Short
var tinyNum: Byte
```

## Declarando o tipo e atribuindo um valor

Nos exemplos anteriores, criamos variáveis **sem atribuir valores iniciais**. Mas você também pode **declarar 
explicitamente o tipo** e **atribuir um valor ao mesmo tempo**. Por exemplo, veja como criar uma variável `Short` 
chamada `z` e atribuir o valor `6`:

```kotlin
var z: Short = 6
```

Esse código cria uma variável chamada `z` do tipo `Short`. Como o valor 6 é pequeno o suficiente para caber em um Short,
o compilador cria um objeto Short com valor 6, e uma referência a esse objeto é armazenada na variável. Ao atribuir um
valor a uma variável, você precisa garantir que esse valor seja compatível com o tipo da variável.

A atribuição de um valor inicial a uma variável é chamada de **inicialização**. Você **DEVE** inicializar uma variável antes 
de usá-la, caso contrário o compilador gerará um erro. Por exemplo, o código abaixo não compila, pois x não foi inicializada:

```kotlin
var x: Int
println(x) // Erro de compilação
```

---

## Armazenando múltiplos valores em um array

Existe mais um tipo de objeto que queremos apresentar: o **array**. Suponha que você queira armazenar os nomes de 
cinquenta sabores de sorvete, ou os códigos de barras de todos os livros de uma biblioteca. Fazer isso usando variáveis 
individuais rapidamente se tornaria algo **complicado e pouco prático**. Em vez disso, você pode usar um **array**. 
Arrays são ótimos quando você precisa de um **conjunto simples e rápido de elementos**.

Eles são:

- Fáceis de criar
- E permitem **acesso rápido a cada item**

---

## String templates: uma forma rápida e simples de usar variáveis dentro de Strings

**String templates** fornecem uma maneira rápida e fácil de **inserir valores dentro de uma String**. Para incluir o 
valor de uma variável em uma String, você utiliza o símbolo `$` antes do nome da variável. Por exemplo, para incluir o 
valor de uma variável `Int` chamada `x`:

```kotlin
var x = 42
var value = "Value of x is $x"
```

Você também pode usar String templates para acessar **propriedades de objetos ou chamar funções**. Nesse caso, **é 
necessário envolver a expressão entre chaves `{}`**.

```kotlin 
var myArray = arrayOf(1, 2, 3)
var arraySize = "myArray has ${myArray.size} items"
var firstItem = "The first item is ${myArray[0]}"
```

Você pode até usar String templates **para avaliar expressões mais complexas dentro da String.** Por exemplo, usando
uma expressão **if**:

```kotlin 
var result = "myArray is ${if (myArray.size > 10) "large" else "small"}"
```
