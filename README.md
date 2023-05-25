* Сделать приложение для работы с данными из файла

- добавление
- обновление
- получение
- удаление

- вывести имена всех пользователей системы

## Структура java-проекта

* `de.ait`
  * `app` - здесь размещается точка входа в приложение (`main`)
  * `models` - модели предметной области
  * `repositories` - классы, которые отвечают за получение данных `findAll` (работу с хранилищем - файлом)
  * `service` - бизнес-логика вашего проекта `getNames` - получение имен

* Общая логика работы - 
  1. открываем файл, читаем оттуда все строки, преобразуем их в список User - `repositories`
  2. получаем этот список и забираем у него имена - `services`
  3. получаем имена и печатаем их в консоль - `app`

## Почему нужно использовать интерфейсы?

* Иногда один компонент системы может зависеть от другого компонента.

* В данном случае, класс А зависит от класса В

```
class B {
  public void bMethod() {
    // ...
  }
}

class A {
  private B b;
  
  public A(B b) {
    this.b = b;
  }
  
  public void method() {
    b.bMethod();
  }
}
```

* Но бывает так, что мы хотим использовать разные варианты метода `bMethod` - 
  * например, вы можете хотеть считать данные из файла или из интернета
* Чтобы в будущем не сильно ломать код, мы можем сделать интерфейс и несколько его реализаций

```
interface C {
 public void cMethod();
}

class B implements C {
  public void cMethod() {
    // читаем из файла
  }
}

class D implements C {
  public void cMethod() {
    // читаем из интернета
  }
}

class A {
  private С с;
  
  public A(С с) {
    this.с = с;
  }
  
  public void method() {
    с.сMethod();
  }
}

B b = new B();
D d = new D();

A a = new A(b);
A a = new A(d);
```