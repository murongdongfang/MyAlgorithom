package xxh.solution;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2021/2/3
 *@discription:
 * 对Solution51进行优化，不用维护一个res类成员变量，只通过递归返回值
 */
public class Solution51Optimize {
//  private int res = 0;

  public static void main(String[] args) {
    int[] nums = {7, 5, 6, 4};
    new Solution51().reversePairs(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]+", ");
    }
  }
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length <= 0){
      return 0;
    }
    int[] copyArr = Arrays.copyOfRange(nums, 0, nums.length);
    return sort(nums, copyArr, 0, nums.length - 1);
  }
  public int sort(int[] arr, int[] copyArr, int l, int r){
    if (l >= r){
      return 0;
    }
    int res = 0;
    int mid = (l + r) >>> 1;
    res += sort(arr, copyArr, l, mid);
    res += sort(arr, copyArr, mid + 1, r);
    if (arr[mid] > arr[mid + 1]){
      res += merge(arr, copyArr, l, mid, r);
    }
    return res;
  }

  /**
   * 将有序数组中的两个有序部分arr[l,mid]和arr[mid+1,r]和并成一个有序部分
   */
  private int merge(int[] arr, int[] copyArr, int l, int mid, int r) {
    System.arraycopy(arr, l, copyArr, l, r - l + 1);
    int i = l, j = mid + 1, res = 0;
    for (int k = l; k <= r; k++) {
      //arr[l,mid]部分先归完，只需要依次把arr[mid+1,r]插入归并后的数组即可
      if (i > mid){
        arr[k] = copyArr[j];
        j++;
      }else if (j > r){
        arr[k] = copyArr[i];
        i++;
      }else if (copyArr[i] > copyArr[j]){
        arr[k] = copyArr[j];
        j++;
        /**
         *        i                  j
         * arr[l...mid] 有序arr[mid+1...r]
         * 若arr[j] < arr[i]则arr[i,mid]范围内的所有元素都和元素arr[j]形成逆序对
         */
        res += (mid - i + 1);
      }else{
        // 比较copyArr[i]和copyArr[j]，将较小者归并到新数组中
        arr[k] = copyArr[i];
        i++;
      }
    }
    return res;
  }
}
