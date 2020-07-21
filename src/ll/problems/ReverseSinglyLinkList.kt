package ll.problems

import common.SingleNode
import ll.SinglyLinkedListDs
import java.util.Stack
import common.SingleNode as NewHead


fun reverseLinkList(currentNode: SingleNode?): NewHead? {
    if (currentNode?.next == null) {
        return currentNode
    }
    val newHead: NewHead? = reverseLinkList(currentNode.next)
    currentNode.next?.next = currentNode
    currentNode.next = null
    return newHead
}

fun reverseListUsingStack(head: SingleNode?): NewHead? {

    var currentNode = head
    val stack = Stack<SingleNode>()
    while (currentNode != null) {
        stack.push(currentNode)
        currentNode = currentNode.next
    }
    val newHead = stack.pop()
    currentNode = newHead
    while (stack.isEmpty().not()) {
        val pop = stack.pop()
        pop.next = null
        currentNode?.next = pop
        currentNode = currentNode?.next
    }
    return newHead
}


fun main() {
    val slist = SinglyLinkedListDs()

    slist.insert(1)
    slist.insert(2)
    slist.insert(3)
    slist.insert(4)
    slist.insert(100)
    slist.insert(11)
    slist.insert(51)
    slist.insert(1)
    slist.insert(5)

    println("Original linked list")
    slist.printLinkedList()
    slist.head = reverseLinkList(slist.head)
    println("\nReversed using recursion")
    slist.printLinkedList()

    slist.head = reverseListUsingStack(slist.head)
    println("\nReversed using stack")
    slist.printLinkedList()
}