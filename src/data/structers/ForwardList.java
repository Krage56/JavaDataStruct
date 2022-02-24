package data.structers;

public class ForwardList <T>{
    private class Node {
        public Node (T value, Node next){
            this._value = value;
            this._next = next;
        }
        public void insertNext (T value){
            this._next = new Node (value, this._next);
        }
        public void insertNext (Node node){
            Node tmp = this._next;
            this._next = node;
            node._next = tmp;
        }
        public void removeNext(){
            if(this._next != null){
                Node removeNode = this._next;
                Node newNext = removeNode._next;
                this._next = newNext;
                removeNode = null;
            }
        }
        public Node _next;
        public T _value;
    }
    public ForwardList (){
        this._head = null;
        this._size = 0;
    }
    public ForwardList(ForwardList<T> copyList){
        this._size = copyList._size;
        if(this._size == 0){
            this._head = null;
            return;
        }
        this._head = new Node (copyList._head._value, null);

        Node currentNode = this._head;
        Node currentCopyNode = copyList._head;

        while (currentCopyNode._next != null){
            currentNode._next = new Node(currentCopyNode._next._value,
                    null);
            currentCopyNode = currentCopyNode._next;
            currentNode = currentNode._next;
        }

    }
    public void addToHead(T value){
        this._head = new Node(value, this._head);
        ++(this._size);
    }
    protected void insertAfterNode (Node node, T value){
        node.insertNext(value);
        this._size += 1;
    }
    protected Node getNode(int pos)throws
            IndexOutOfBoundsException{
        if (pos < 0 || pos >= this._size){
            throw new IndexOutOfBoundsException("Index of required position is out of range");
        }
        Node bufNode = this._head;
        for (int i = 0; i < pos; ++i) {
            bufNode = bufNode._next;
        }
        return bufNode;
    }
    public void add (T value, int ind)throws
            IndexOutOfBoundsException{
        if (ind < 0 || ind >= this._size){
            throw new IndexOutOfBoundsException("Index of required position is out of range");
        }
        if(ind == 0){
            addToHead(value);
        }
        else{
            Node bufNode = this._head;
            for (int i = 0; i < ind - 1; ++i){
                bufNode = bufNode._next;
            }
            bufNode.insertNext(value);
            ++(this._size);
        }
    }
    public T get(int ind){
        return getNode(ind)._value;
    }
    public void removeFront(){
        if (this._size > 0){
            _head = this._head._next;
            --(this._size);
        }
    }
    public void remove(int ind){
        if(ind == 0){
            removeFront();
        }
        else{
            Node bufNode = getNode(ind - 1);
            bufNode.removeNext();
            --(this._size);
        }
    }
    public void clear(){
        int n = this._size;
        for (int i = 0; i < n; ++i){
            this.removeFront();
        }
    }
    public final int getSize(){return this._size;}
    private Node _head;
    private int _size;
}
