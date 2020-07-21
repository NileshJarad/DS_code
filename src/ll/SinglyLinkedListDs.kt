package ll

import common.SingleNode
import ll.problems.findKthLastElementInLinkList
import ll.problems.findKthLastElementInLinkListUsingIteration

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

    fun deleteNode(data: Int) {
        head?.let {
            if (it.data == data) {
                head = it.next
            } else {
                var currNode : SingleNode? = it
                var prevNode: SingleNode? = null
                while (currNode != null && currNode.data != data) {
                    prevNode = currNode
                    currNode = currNode.next
                }
                prevNode?.next = currNode?.next
            }
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

fun main(){
    val slist = SinglyLinkedListDs()

    slist.insert(3)
    slist.insert(4)
    slist.insert(1)
    slist.insert(67)
    slist.insert(7)
    slist.insert(147)
    slist.insert(90)
    slist.insert(70)

    slist.printLinkedList()
    slist.deleteNode(70)
    slist.deleteNode(3)
    slist.deleteNode(147)
    println()
    slist.printLinkedList()
}