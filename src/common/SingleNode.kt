package common

/**
 * contains data and single pointer for the next node
 */
data class SingleNode(
    var data: Int,
    var next: SingleNode? = null
)