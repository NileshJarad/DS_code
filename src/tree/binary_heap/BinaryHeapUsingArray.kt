package tree.binary_heap

class BinaryHeapUsingArray(size: Int) {
    private var sizeOfTree = 0

    //We are adding 1 here to eliminate problem of array start at index 0
    var array: IntArray = IntArray(size + 1)

    fun sizerOfArray() = array.size

    fun sizeOfTree() = sizeOfTree

    fun insertInHeap(element: Int) {
        println("Inserting element $element")
        array[++sizeOfTree] = element
        heapifyBottomToTop(sizeOfTree)
    }


    /**
     * Used when element is added in heap
     */
    private fun heapifyBottomToTop(index: Int) {
        val parent = index / 2

        if (index <= 1) {
            return
        }
        if (array[parent] > array[index]) {
            val temp = array[index]
            array[index] = array[parent]
            array[parent] = temp
        }
        heapifyBottomToTop(parent)
    }

    private fun heapifyTopToBottom(index: Int) {
        val leftChild = index * 2
        val rightChild = index * 2 + 1

        var smallestChild = 0

        if (sizeOfTree < leftChild) {
            // left child is not present so heap is empty and obviously right child is not present as we insert in level order
            return
        } else {
            smallestChild = if (array[leftChild] < array[rightChild]) {
                leftChild
            } else {
                rightChild
            }

            if (array[index] > array[smallestChild]) {
                val temp = array[smallestChild]
                array[smallestChild] = array[index]
                array[index] = temp
            }
            heapifyTopToBottom(smallestChild)
        }
    }

    fun peek(): Int {
        if (sizeOfTree >= 1) {
            return array[1]
        } else {
            throw HeapEmptyException()
        }
    }

    fun extractHeapOfHeap(): Int {
        val extractedValue = array[1]
        array[1] = array[sizeOfTree]
        sizeOfTree--
        heapifyTopToBottom(1)
        return extractedValue
    }

    fun levelOrder() {
        for (i in 1..sizeOfTree) {
            print("${array[i]} ")
        }
        println()
    }
}

fun main() {

    val heap = BinaryHeapUsingArray(100)
    heap.insertInHeap(30)
    heap.insertInHeap(3)
    heap.insertInHeap(50)
    heap.insertInHeap(2)
    heap.insertInHeap(1)

    print("Printing heap :")
    heap.levelOrder()

    println("Peek heap root : ${heap.peek()}")
    println("Extract heap root : ${heap.extractHeapOfHeap()}")

    print("Printing heap :")
    heap.levelOrder()


}