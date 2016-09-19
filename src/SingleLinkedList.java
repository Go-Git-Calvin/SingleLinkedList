public class SingleLinkedList<E> {

    // Nested Class

    /** A Node is the building block for the SingleLinkedList */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link */
        private Node<E> next = null;


        /**
         * Construct a node with the given data value and link
         * @param data - The data value
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         * @param data - The data value
         */
        public Node(E data) {
            this(data, null);
        }
    }


    // Data fields
    /** A reference to the head of the list */
    private Node<E> head = null;
    /** The size of the list */
    private int size = 0;


    // Helper Methods
    /** Insert an item as the first item of the list.
     *	@param item The item to be inserted
     */
    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    /**
     * Add a node after a given node
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    /**
     * Remove the first node from the list
     * @returns The removed node's data or null if the list is empty
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     * @param node The node before the one to be removed
     * @returns The data from the removed node, or null
     *          if there is no node to remove
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Find the node at a specified index
     * @param index The index of the node sought
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Public Methods
    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Set the data value at index
     * @param index The index of the item to change
     * @param newValue The new value
     * @returns The data value priviously at index
     * @throws IndexOutOfBoundsException if the index is out of
     *  range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E value = node.data;
        node.data = newValue;
        return value;
    }

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indicies)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }
    /**
     * Remove the item at the specified position in the list. Shifts
     * any squsequent items to the left (subtracts one from their
     * indicies). Returns the tiem that was removed.
     * @param index The index of the item to be removed
     * @returns The item that was at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> removedNode = null;
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> node = getNode(index - 1);
            return removeAfter(node);
        }
    }

    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
    int size() {
        return size;
    }

    /**
     * Obtain a string representation of the list
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Remove the first occurence of element item.
     * @param item The item to be removed
     * @return true if item is found and removed; otherwise, return false.
     */
    public boolean remove(E item) {
        if (head == null) {
            return false;
        }
        Node<E> current = head;
        if (item.equals(current.data)) {
            removeFirst();
            return true;
        }
        while (current.next != null) {
            if (item.equals(current.next.data)) {
                removeAfter(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }
}