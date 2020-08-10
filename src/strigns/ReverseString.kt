package strigns

/****
 * Given string reverse it.
 *
 * example
 * input :- Hello world
 * output :- dlrow olleH
 */

fun main() {
    val stringToRevers = "Hello world"
    reverseString(stringToRevers)
}


/***
 * Reverse string using recursion
 */

fun reverseString(str: String) {
    val len = str.length
    if (len == 0) {
        return
    }
    val char = str[0]
    reverseString(str.substring(1, len))
    print("$char")
}