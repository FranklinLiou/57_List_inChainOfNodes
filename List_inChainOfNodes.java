/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      int result = 0;
      for (Node node = headReference; node != null; node = node.getReferenceToNextNode()) {
        result++;
      }
      return result;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      String stringList = "elements [";
      for (Node node = headReference; node != null; node = node.getReferenceToNextNode()) {
        stringList = stringList + node.getCargoReference() + ",";
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
        headReference = newHead;
        return true;
     }


     public Node get( int index) {
       Node node = headReference;
       // Node cargo = headReference;
       for (int loop = 0; loop < index; node = node.getReferenceToNextNode()) {
         loop ++;
       }
       return node;
     }

     public Node set( int index, Object value) {
      Node saveForReturn = get( index);
      get( index - 1).setReferenceToNextNode(new Node(value, get( index + 1)));
      return saveForReturn;
     }

     public Node remove( int index) {
      Node result = get( index);
      get( index - 1).setReferenceToNextNode(get( index + 1));
      return result;
     }

     /*
      Append @value to a specified index.

      @return true "in keeping with conventions"
     */
     public boolean add( int index, Object value) {
       if (index == 0) {
         addAsHead(value);
       }
       else {
         Node addedNode = new Node(value, get( index));
         // Node node = new Node("new");
         get( index - 1).setReferenceToNextNode(addedNode);
         // for (int loop = size(); loop > index; node = get( loop)) {
           
         // }
       }

       return true;
     }
}
