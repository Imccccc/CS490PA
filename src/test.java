import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test {

  public static void main(String[] args){
    System.out.println(Thread.currentThread().getName());
//    for(int i=0; i<10; i++){
//      new Thread("" + i){
//        public void run(){
//          System.out.println("Thread: " + getName() + " running");
//        }
//      }.start();
//    }
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    Collections.sort(names, (a, b) -> b.compareTo(a));
    System.out.println(names);
  }
}
