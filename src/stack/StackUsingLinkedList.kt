package stack

import common.SingleNode

class StackUsingLinkedList(var top: SingleNode? = null) {

    fun push(element: Int) {
        val tempNode = SingleNode(element)
        tempNode.next = top
        top = tempNode
    }

    fun pop(): Int {
        val data = peek()
        top = top?.next
        return data
    }

    fun peek(): Int {
        top?.let {
            return it.data
        }
        throw  StackEmptyException()
    }
}


fun main() {
    val stack = StackUsingLinkedList()
    stack.push(2)
    stack.push(4)
    stack.push(6)
    stack.push(12)
    stack.push(15)

    println("Popped element : " + stack.pop())
    println("Peek element : " + stack.peek())
    println("Popped element : " + stack.pop())
    println("Popped element : " + stack.pop())
}

/****
 *
 * Popped element : 15
 * Peek element : 12
 * Popped element : 12
 * Popped element : 6
 *
 * */