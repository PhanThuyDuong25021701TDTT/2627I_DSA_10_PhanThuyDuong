package practise;

public class LinkedList {
    private Node first;
    public LinkedList(){
        this.first= null;
    }
    //thêm vào dau danh sách
    public void addFirst (String data){
        Node newNode = new Node (data);
        newNode.next= first;
        first = newNode;
    }
    // tìm kếm nút đầu tiên
    public Node findFirst(String data){
        Node current = first;
        while(current!= null){
            if((data==null&&current.data==null)){
                return current;
            }
            current= current.next;
        }
        return null;
    }
    public void append(String data){
        Node newNode = new Node(data);
        if ( first== null){
            first = newNode;
            return;
        }
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void deleteFirst(String data){
        if(first==null) return;
        if((data==null && first.data==null));
    }
}
