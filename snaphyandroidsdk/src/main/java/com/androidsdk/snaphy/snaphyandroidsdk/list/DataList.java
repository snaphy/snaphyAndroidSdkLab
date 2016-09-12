package com.androidsdk.snaphy.snaphyandroidsdk.list;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by snaphy on 12/9/16.
 */
public class DataList<T> extends ArrayList<T> {

    //Implementing the interface for events..
    public interface Listeners<T> {
        //On Initialization of the COnstructors..
        public void onInitialize(DataList<T> dataList);
        // When any Change appears in the list..
        public void onChange(DataList<T> dataList);
        // On Clearing the list..
        public void onClear();
        //On removing of an element from datalist..
        public void onRemove(T element);
    }

    public DataList(int capacity){
        super(capacity);
        //TODO fire onInitialize event..
    }

    public DataList(){
        super();
        //TODO fire onInitialize event..
    }

    public DataList(Collection<? extends T> collection){
        super(collection);
        //TODO fire onInitialize event..
    }


    @Override
    public void add(int index, T element){
        super.add(index, element);
        //TODO fire onChange event
    }

    @Override
    public boolean add(T element){
        boolean returnValue = super.add(element);
        //TODO fire onChange event
        return returnValue;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection){
        boolean returnValue = super.addAll(collection);
        //TODO fire onChange event..
        return returnValue;
    }

    public boolean addAll(int index, Collection<? extends T> collection){
        boolean returnValue = super.addAll(index, collection);
        //TODO fires onChange event..
        return returnValue;
    }

    /**
     * Removes all elements from this {@code ArrayList}, leaving it empty.
     *
     * @see #isEmpty
     * @see #size
     */
    @Override public void clear() {
        super.clear();
        //TODO fire onChange event
        //TODO fire onClear event.
    }

    /**
     * Removes the object at the specified location from this list.
     *
     * @param index
     *            the index of the object to remove.
     * @return the removed object.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || location >= size()}
     */
    @Override public T remove(int index) {
        T returnValue = super.remove(index);
        //TODO fire the onChange event
        //TODO fire the onRemove event
        return returnValue;
    }

    @Override public boolean remove(Object object) {
        boolean returnValue = super.remove(object);
        //TODO fire the onChange event
        //TODO fire the onRemove event
        return returnValue;

    }


    /**
     * Replaces the element at the specified location in this {@code ArrayList}
     * with the specified object.
     *
     * @param index
     *            the index at which to put the specified object.
     * @param object
     *            the object to add.
     * @return the previous element at the index.
     * @throws IndexOutOfBoundsException
     *             when {@code location < 0 || location >= size()}
     */
    @Override public T set(int index, T object){
        T returnValue = super.set(index, object);
        //TODO fire onChange event
        return returnValue;
    }


}
