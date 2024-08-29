// 데이터와 연산
public class App2 {
    public static void main(String[] args)  {
        System.out.println(6); // Number
        System.out.println("Six"); // String 

        System.out.println("6"); // String 

        System.out.println(6+6); 
        System.out.println(6+"6"); 

        System.out.println(6*6); 

        System.out.println("11".length()); // 문자열의 길이 
    }
}


// 숫자와 연산
public class App2 {
    public static void main(String[] args)  {
        System.out.println(6 + 2); 
        System.out.println(6 - 2); 
        System.out.println(6 * 2);
        System.out.println(6 / 2);

        System.out.println(Math.PI); // -> 3.141592653589793

        System.out.println(Math.floor(Math.PI)); // -> 3.0
        System.out.println(Math.ceil(Math.PI)); // -> 4.0
    }
}


// 문자열의 표현
public class App2 {
    public static void main(String[] args) {
        System.out.println("Hellow World"); // String 문자열 
        System.out.println('H'); // Character 문자 

        System.out.println("문자열" + " 더하기"); // 문자열 더하기 
        
        System.out.println("""
            줄
            바꿈
            1
        """); // 줄 바꿈1
        System.out.println("줄 \n바꿈 \n2"); // 줄 바꿈2

        System.out.println("이게 모죠? \n그건 바로 \"escape\""); // escape
    }
}


// 변수의 정의
public class App2 {
  public static void main(String[] args) {
      var a = 0; // 타입 추론 
      System.out.println(a); 

      int aa = 1; // 명시적 타입 선언 
      System.out.println(aa);

      double b = 1.3;
      System.out.println(b);

      String c = "Hello";
      System.out.println(c);

      final int CONSTANT_VALUE = 10; // 상수 
      System.out.println(CONSTANT_VALUE);
  }
}


// 변수의 효용
public class App2 {
    public static void main(String[] args) {
        String HELLO = "안녕";
        System.out.println("Hello? " + HELLO);

        HELLO = "잘가";
        System.out.println("Hello? "+HELLO+"");
    }
}

// 데이터 타입 변환
public class App2 {
    public static void main(String[] args) {
        int a = (int) 1.1; 
        System.out.println(a);

        String b = Integer.toString(1);
        System.out.println(b);
        System.out.println(b.getClass());
    }
}