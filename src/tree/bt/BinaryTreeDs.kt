package tree.bt

import common.DoubleNode
import java.util.*

open class BinaryTreeDs(var root: DoubleNode? = null) {

    fun preOrderTraversal(rootNode: DoubleNode?) {
        rootNode?.let {
            print("${it.data} ")
            preOrderTraversal(it.left)
            preOrderTraversal(it.right)
        }

    }

    fun inOrderTraversal(rootNode: DoubleNode?) {
        rootNode?.let {
            inOrderTraversal(it.left)
            print("${it.data} ")
            inOrderTraversal(it.right)
        }

    }


    fun postOrderTraversal(rootNode: DoubleNode?) {
        rootNode?.let {
            postOrderTraversal(it.left)
            postOrderTraversal(it.right)
            print("${it.data} ")
        }
    }

    fun levelOrderTraversal(rootNode: DoubleNode?) {
        val queue: Queue<DoubleNode> = LinkedList<DoubleNode>()
        queue.add(rootNode)
        while (queue.isNotEmpty()) {
            val presentNode = queue.remove()
            print("${presentNode.data} ")
            presentNode.left?.let {
                queue.add(it)
            }
            presentNode.right?.let {
                queue.add(it)
            }
        }
    }

    fun calculateHeight(rootNode: DoubleNode?): Int {
        rootNode?.let {
            return 1 + Math.max(calculateHeight(it.left), calculateHeight(it.right))
        } ?: kotlin.run {
            return -1
        }
    }
}

fun main() {
    val bt = BinaryTreeDs()
    bt.root = DoubleNode(
        data = 1,
        left = DoubleNode(
            data = 2,
            left = DoubleNode(
                data = 4
            ),
            right = DoubleNode(
                data = 5
            )
        ),
        right = DoubleNode(
            data = 3
        )
    )


    println("=============================")
    println("Depth First traversal ")
    println("=============================")
    print("\tIn-Order traversal : ")
    bt.inOrderTraversal(bt.root)

    print("\n\tPre-Order traversal : ")
    bt.preOrderTraversal(bt.root)

    print("\n\tPost-Order traversal : ")
    bt.postOrderTraversal(bt.root)

    println("\n=============================")
    println("Breadth First traversal")
    println("=============================")
    print("\tLevel-Order traversal : ")
    bt.levelOrderTraversal(bt.root)


    print("\n\n Height of tree = ${bt.calculateHeight(bt.root)}")
}

