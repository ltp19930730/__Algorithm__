
import java.util.*;

public class WindowsSum{

  public List<Integer> SumOfWindows(List<Integer> list, int k){
    List<Integer> ans = new ArrayList<>();
    if (list == null || list.size() == 0){
      return ans;
    }
    for (int i = 0; i < list.size() - k + 1; i++){
      int result = 0;
      for (int j = i; j < i + k; j++){
        result += list.get(j);
      }
      ans.add(i,result);
    }
    return ans;
  }

  public static void main(String[] args){
    WindowsSum a = new WindowsSum();
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    List<Integer> result = a.SumOfWindows(list, 3);
    System.out.println(result.toString());
  }
}
