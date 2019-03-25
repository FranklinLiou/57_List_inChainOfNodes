/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node[] list;
    private Node headReference;
    private int filledElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
      list = new Node[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      String stringList = "elements [";
      for (int element = 0; element < filledElements; element++) {
        stringList = stringList + list[element] + ",";
      }
      stringList += "]";
      return stringList;
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node newHead = new Node(val, headReference);
        System.out.println(newHead);
        headReference = newHead;
        filledElements ++;
        return true;
     }

     /*
      Append @value to a specified index.

      @return true "in keeping with conventions"
     */
     public boolean add( int index, Object value) {
       Node addedNode = new Node(value, list[index]);
       list[index - 1].setReferenceToNextNode(addedNode);
       for (int hole = filledElements; hole > index; hole--) {
         list[hole] = list [hole - 1];
       }
       return true;
     }
}
