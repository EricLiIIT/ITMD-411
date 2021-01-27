import java.util.ArrayList;

  public class List{
    public static int myList (ArrayList <Integer> arr){
      Integer maximum = 0;
      for (int i=0; i<arr.size(); i++)
        if (arr.get(i) > maximum)
          maximum=arr.get(i);
          return maximum;
    }
    public static void main(String[] args) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      arr.add(1);
      arr.add(12);
      arr.add(7);
      arr.add(32);
      arr.add(5);
      arr.add(9);

      System.out.println(myList(arr));
    }
  }
