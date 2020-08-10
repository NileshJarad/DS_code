package strigns

/****
 * Given string reverse it.
 *
 * example
 * input :- Hello world
 * output :- olleH dlrow
 */


fun main() {
    val stringToReverse = "Hello world"
    val strings = stringToReverse.split(" ")

    strings.forEach {
        reverseStringWords(it)
        print(" ")
    }

}

fun reverseStringWords(str: String) {
    val len = str.length
    if (len == 0) {
        return
    }
    val char = str[0]
    reverseString(str.substring(1, len))
    print("$char")
}