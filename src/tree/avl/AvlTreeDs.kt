package tree.avl

import common.DoubleNode
import tree.bst.BinarySearchTreeDs

class AvlTreeDs : BinarySearchTreeDs() {

    fun insertInAvl(data: Int) {
        root = insertAvlHelper(rootNode = root, data = data)
    }

    private fun insertAvlHelper(rootNode: DoubleNode?, data: Int): DoubleNode? {
        rootNode?.let {
            when {
                data < it.data -> {
                    it.left = insertAvlHelper(it.left, data)
                }
                data > it.data -> {
                    it.right = insertAvlHelper(it.right, data)
                }
            }


            // Do AVL specific operations
            val balance = checkBalance(it.left, it.right)
            when {
                balance > 1 -> { // we got left case

                    // now find find its left-left or left-right

                    if (checkBalance(it.left?.left, it.left?.right) > 0) {
                        println("Right rotation ${it.data}")
                        // LL Condition so do  right rotation
                        return rightRotation(it)
                    }else{
                       it.left = leftRotation(it.left)
                        return rightRotation(it)
                    }

                }

                balance < -1 -> {
                    if (checkBalance(it.right?.left, it.right?.right) > 0) {
                        println("left rotation ${it.data}")
                        return leftRotation(it)
                    }else{
                        println("right rotation and then left ${it.data}")
                        it.right = rightRotation(it.right)
                        return rightRotation(it)
                    }
                }
            }


            return it
        } ?: kotlin.run {
            return DoubleNode(
                data = data
            )
        }

    }

    private fun rightRotation(currentNode: DoubleNode?): DoubleNode? {
        val newRoot = currentNode?.left
        currentNode?.left = currentNode?.left?.right
        newRoot?.right = currentNode
        return newRoot
    }

    private fun leftRotation(currentNode: DoubleNode?): DoubleNode? {
        val newRoot = currentNode?.right
        currentNode?.right = currentNode?.right?.left
        newRoot?.left = currentNode
        return newRoot
    }

    /***
     * Balance factor of AVL is
     *
     *  balance Factor = Height of left sub-tree - Height of right sub-tree
     *
     *  if  balance Factor > 1 tree is left heavy
     *  if  balance Factor < -1 tree is right heavy
     *
     */
    private fun checkBalance(left: DoubleNode?, right: DoubleNode?): Int {
        return if (left == null && right == null) {
            0
        } else if (left == null) {
            -1*(calculateHeight(right) + 1) // empty tree height is -1 we need make is
        } else if (right == null) {
            calculateHeight(left) + 1
        } else {
            calculateHeight(left) - calculateHeight(right)
        }
    }

}


fun main() {
    val avl = AvlTreeDs()

    avl.insertInAvl(50)
    avl.insertInAvl(40)
    avl.insertInAvl(30)
    avl.insertInAvl(20)
    avl.insertInAvl(10)

    print("\tLevel-Order traversal : ")
    avl.levelOrderTraversal(avl.root)
}