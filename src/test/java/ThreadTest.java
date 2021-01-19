/**
 *@author xxh
 *@since 2020/12/15
 *@discription: Algorithm
 */
public class ThreadTest {
  public static int turn = 0;
  public static boolean flag0 = false;
  public static boolean flag1 = false;
  public static void main(String[] args) {
    new Thread(()->{
      flag1 = true;
      turn = 0;
      while (flag0 && turn == 0){

      }
      System.out.println("1111111111");
      flag1 = false;
    },"1111").start();
      new Thread(()->{
        while (true){
          flag0 = true;
          turn = 1;
          while (flag1 && turn == 1){

          }
          System.out.println("00000000");
          flag0 = false;
        }
      },"0000").start();


  }
}

