import xxh.stack.ArrayStack;

import java.util.Stack;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription: Algorithm
 */
public class StackTest {
  public static void main(String[] args) {
    ArrayStack<Integer> arrayStack = new ArrayStack<>();
    for (int i = 0; i < 30; i++) {
      arrayStack.push(i);
      System.out.println(arrayStack);
    }
    for (int i = 0; i < 30; i++) {
      arrayStack.pop();
      System.out.println(arrayStack);
    }
  }

  // 栈的应用，字符串匹配
  public boolean isValid(String s){
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '['){
        stack.push(ch);
      }else {
        Character topChar = stack.pop();
        if (topChar == '(' && ch != ')'){
          return false;
        }
        if (topChar == '{' && ch != '}'){
          return false;
        }
        if (topChar == '[' && ch != ']'){
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
