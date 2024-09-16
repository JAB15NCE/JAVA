
import java.io.*; //For Scanner
import java.util.*;

public class fancyhello
{
public static void main(String[] args) {
 A[] elements = {new B(), new D(), new A(), new C()};
 for (int i = 0; i < elements.length; i++) {
 elements[i].method2();
 System.out.println(elements[i]);
 elements[i].method1();
 System.out.println();
 }
}
}
