package data.structers;


public class DArray<T> {
    public DArray (int cap){
        if (cap == 0){
            this._capacity = 10;
        }
        else{
            this._capacity = cap;
        }
        this._size = 0;
        this.setMemory();
    }
    public DArray (){
        this._capacity = 10;
        this._size = 0;
        this.setMemory();
    }
    public DArray (DArray<T> copiedArr){
        this._capacity = copiedArr._capacity;
        this._size = copiedArr._size;
        this._data = copiedArr._data.clone();
    }
    public final int getSize(){
        return this._size;
    }
    public final int getCap(){
        return this._capacity;
    }
    public void add(T value, int ind)throws
            ArrayIndexOutOfBoundsException{
        if(ind == this._size)
            this.addToEnd(value);
        else if(ind > this._size){
            throw new ArrayIndexOutOfBoundsException("Index of required position is out of range\n");
        }
        else{
            if (this._capacity < this._size + 1){
                this._capacity = Math.round(_coef * this._capacity);
                Object[] tmp_data = new Object[this._capacity];
                tmp_data[ind] = value;
                System.arraycopy(this._data, 0, tmp_data, 0, ind);
                if (this._size - ind  >= 0)
                    System.arraycopy(this._data, ind, tmp_data, ind + 1, this._size - ind);

                this._data = tmp_data;
                ++(this._size);
            }
            else{
                if (this._size - ind >= 0) System.arraycopy(_data, ind, _data, ind + 1, this._size - ind);
                this._data[ind] = value;
                ++(this._size);
            }
        }
    }

    public void addToEnd(T value){
        if(this._capacity < this._size + 1){
            reserve(Math.round(_capacity * _coef));
        }
        this._data[this._size] = value;
        ++(this._size);
    }
    public void reserve(int n){
        if(n < _size)
            _size = n;
        Object[] tmpData = new Object[n];
        System.arraycopy(this._data, 0, tmpData, 0, this._size);
        this._data = tmpData;
        this._capacity = n;
    }
    public T get(int ind){
        if(ind >= this._size){
            throw new ArrayIndexOutOfBoundsException("Index of required position is out of range\n");
        }
        return (T)(this._data[ind]);
    }
    public void resize(int n){
        if(n > this._size){
            if(n > this._capacity){
                reserve(Math.round(n * _coef));
            }
            for (int i = this._size; i < n; ++i){
                ((T[])this._data)[i] = (T)(new Object());
            }
        }
        this._size = n;
    }
    public void removeFromEnd(){
        if(this._size > 0){
            --(this._size);
        }
    }
    public void remove(int ind){
        if (this._size - 1 - ind >= 0)
            System.arraycopy(this._data, ind + 1,
                    this._data, ind, this._size - 1 - ind);
        --_size;
    }
    protected void setMemory(){
        this._data = new Object[_capacity];
    }
    public void clear(){
        this._size = 0;
    }

    private Object[] _data;
    private int _size;
    private int _capacity;
    private static final float _coef = 1.5F;
}
