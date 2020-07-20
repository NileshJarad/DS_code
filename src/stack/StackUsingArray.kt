package stack

class StackUsingArray {
    companion object {
        private const val MAX = 100
    }

    var stack = IntArray(MAX)

    var top = -1

    fun push(element: Int) {
        return if (top < MAX - 1) {
            stack[++top] = element
        } else {
            throw StackFullException()
        }
    }

    fun pop(): Int {
        return if (top >= 0) {
            stack[top--]
        } else {
            throw StackEmptyException()
        }
    }

    fun peek(): Int {
        return if (top >= 0) {
            stack[top]
        } else {
            throw StackEmptyException()
        }
    }
}


fun main() {
    val stack = StackUsingArray()
    stack.push(2)
    stack.push(4)
    stack.push(6)
    stack.push(12)
    stack.push(15)

    println("Popped element : " + stack.pop());
    println("Peek element : " + stack.peek());
    println("Popped element : " + stack.pop());
    println("Popped element : " + stack.pop());
}