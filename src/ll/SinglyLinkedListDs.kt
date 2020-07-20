package ll

import common.SingleNode

class SinglyLinkedListDs(var head: SingleNode? = null) {
    fun insert(data: Int) {
        head?.let {
            var tempNode: SingleNode? = it
            while (tempNode?.next != null) {
                tempNode = tempNode.next
            }
            tempNode?.next = createNode(data)
        } ?: kotlin.run {
            head = createNode(data)
        }
    }

    fun printLinkedList() {
        var tempIterator = head

        while (tempIterator != null) {
            print("${tempIterator.data} -> ")
            tempIterator = tempIterator.next
        }
    }

    private fun createNode(data: Int): SingleNode {
        return SingleNode(
            data = data
        )
    }
}