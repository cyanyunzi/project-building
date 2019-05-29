package function;

import java.util.function.Function;

/**
 * @author ：林雾
 * @date ：2019/05/28
 * @description :
 */
public class FunctionAPP {
  public static void main(String[] args) {
      Function<String,String> apply = (str)->{
          String result = str + ":apply";
          System.out.println(result);
          return result;
      };

      Function<String,String> andThen = (str)->{
          String result = str + ":andThen";
          System.out.println(result);
          return result;
      };

//      apply.apply("str");
  }
}
