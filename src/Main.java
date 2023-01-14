import java.util.Random;
import java.util.Scanner;

public class Main {

  static void displayArray(int[] array){

    System.out.print("Created array: [");
    for(int i = 0; i < array.length; i++){
      System.out.print(array[i]);
      if(i != array.length-1){
        System.out.print(", ");
      }
    }
    System.out.print("] \n");

  }

  static int[] sort(int[] array){
    int[] arrayCopy = array;
    int numOfElements = array.length;

    for(int i = 0; i < numOfElements-1; i++){
      for (int j = 0; j < numOfElements - i - 1; j++)
        if (arrayCopy[j] > arrayCopy[j + 1]) {
          int temp_element = arrayCopy[j];
          arrayCopy[j] = arrayCopy[j + 1];
          arrayCopy[j + 1] = temp_element;
        }
    }

    return arrayCopy;
  }

  static int[] reverse(int[] array){
    int numOfElements = array.length;
    int[] reversedArray = new int[numOfElements];

    for(int i = numOfElements-1; i >= 0; i--){
      int reversedArrayId = numOfElements-(i+1);
      reversedArray[reversedArrayId] = array[i];
    }

    return reversedArray;
  }

  static boolean equalsReverse(int[] array1, int[] array2){
    if(array1.length != array2.length){
      return false;
    }

    int numOfElements = array1.length;

    for(int arrayIdFromEnd = numOfElements-1; arrayIdFromEnd >= 0; arrayIdFromEnd--){
      int arrayIdFromStart = numOfElements-(arrayIdFromEnd+1);
      if(array1[arrayIdFromStart] != array2[arrayIdFromEnd]){
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println("Wprowadz liczbe calkowita:");
    Scanner scanner = new Scanner(System.in);
    int numberOfElements = scanner.nextInt();

    int[] elements = new int[numberOfElements];

    for(int i=0; i<numberOfElements; i++){
      Random random = new Random();
      int randomValue = random.nextInt(101);
      elements[i] = randomValue;
    }
    displayArray(elements);

    int[] sorted = sort(elements);
    displayArray(sorted);

    int[] reversed = reverse(elements);
    displayArray(reversed);

//    int[] newArray = {101,12,13,19,22};
    System.out.println(equalsReverse(reversed, sorted));
  }
}