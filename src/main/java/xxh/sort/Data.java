package xxh.sort;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class Data implements Comparable<Data> {
  private String nation;
  private int score;

  public Data(String nation, int score) {
    this.nation = nation;
    this.score = score;
  }

  // 防止使用+字符串拼接的两种方法 第一种使用StringBuilder，StringBuffer，第二种使用String.format();
  @Override
  public String toString() {
    return String.format("Data(name=%s,score=%d)", this.nation, this.score);
  }

  @Override
  public int compareTo(Data o) {
    return this.score - o.score;
  }
}
