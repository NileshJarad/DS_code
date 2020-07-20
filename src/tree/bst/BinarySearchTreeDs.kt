package tree.bst

import common.DoubleNode
import tree.bt.BinaryTreeDs

class BinarySearchTreeDs : BinaryTreeDs() {

    fun insert(data: Int) {
        root = insertBstHelper(root, data)
    }

    private fun insertBstHelper(rootNode: DoubleNode?, data: Int): DoubleNode {
        rootNode?.let {
            when {
                data < it.data -> {
                    it.left = insertBstHelper(it.left, data)
                }
                data > it.data -> {
                    it.right = insertBstHelper(it.right, data)
                }
            }
            return it
        } ?: kotlin.run {
            return DoubleNode(
                data = data
            )
        }
    }

}

fun main() {
    val bst = BinarySearchTreeDs()
    bst.insert(8)
    bst.insert(3)
    bst.insert(10)
    bst.insert(14)
    bst.insert(1)
    bst.insert(6)
    bst.insert(4)
    bst.insert(7)
    bst.insert(13)

    print("\nIn-Order traversal : ")
    bst.inOrderTraversal(bst.root)
}