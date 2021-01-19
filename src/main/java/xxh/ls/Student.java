package xxh.ls;

import java.util.Objects;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class Student{
  private String name;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  /**
   *
   * @param o 必须要是object类型的，否则就不是覆盖，而是重载
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Student student = (Student) o;
    return Objects.equals(name, student.name);
  }
}
