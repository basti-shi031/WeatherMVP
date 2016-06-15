# MVP架构

## model
这里model不是平时所说的基本数据结构，例如
```java
class Person{
  private long id;
  private String name;
  //,,,
}
```
当然，为了符合面向对象的过程，数据结构的model也需要。
MVP中的Model是一个接口，其中有获取该model的方法。
ModelImpl实现Model的接口，实现获取model的方法。

## view
view层也是一个接口，需要提供对View的方法，一般来说有
显示/隐藏LoadingView、加载失败，view赋值等方法。
view层中的方法在Activity中实现。

## presenter
prensenter层中提供业务逻辑方法，例如登录界面中，需要有验证账号密码方法、
登录方法。
随后在PresentImpl的实现类中，通过modelImpl获取数据，并将数据传递给View。
