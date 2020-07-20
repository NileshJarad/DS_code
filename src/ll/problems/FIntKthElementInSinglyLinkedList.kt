package ll.problems

import common.SingleNode
import ll.SinglyLinkedListDs

fun findKthLastElementInLinkList(head: SingleNode?, k: Int): Int {
    head?.let {
        val index = findKthLastElementInLinkList(head.next, k) + 1
        if (index == k) {
            print("\n${k}th last element is ${head.data}")
        }
        return index
    } ?: run {
        return 0
    }
}


fun findKthLastElementInLinkListUsingIteration(head: SingleNode?, k: Int) {
    var tempNode = head
    var indexToPrint = k
    while (indexToPrint > 0) {
        tempNode = tempNode?.next
        indexToPrint--
    }

    var tempSecondNode = head
    while (tempNode != null) {
        tempNode = tempNode.next
        tempSecondNode = tempSecondNode?.next
    }
    print("\n${k}th last element using iteration : ${tempSecondNode?.data}")
}

fun main() {
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
    findKthLastElementInLinkList(slist.head, 2)
    findKthLastElementInLinkListUsingIteration(slist.head, 2)
}