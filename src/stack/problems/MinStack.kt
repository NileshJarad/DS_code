package stack.problems

import common.SingleNode
import stack.StackEmptyException
import stack.StackUsingLinkedList

/**
 * Create min stack such that it will return min value in stack
 *
 * Note :-  min() operation should be O(1) always like push and pop
 * **/

class MinStack(var top: MinStackNode? = null) {

    data class MinStackNode(
        val data: Int,
        val minValue: Int = Int.MIN_VALUE,
        var next: MinStackNode? = null
    )


    fun push(element: Int) {
        val tempNode = if (top == null) {
            MinStackNode(data = element, minValue = element)
        } else {
            val minValue = top!!.minValue
            val calculateMinToStore: Int = if (minValue > element) {
                element
            } else {
                minValue
            }
            MinStackNode(data = element, minValue = calculateMinToStore)
        }

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

    fun minValue(): Int {
        top?.let {
            return it.minValue
        }
        throw  StackEmptyException()
    }
}

fun main() {
    val stack = MinStack()
    stack.push(2)
    stack.push(4)
    stack.push(6)
    stack.push(1)
    stack.push(8)

    println("Popped element : " + stack.pop())
    println("Min value : " + stack.minValue())
    println("Popped element : " + stack.pop())
    println("Min value : " + stack.minValue())
}