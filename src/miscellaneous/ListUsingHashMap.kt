package miscellaneous

/**
 *
 * Implement
 *
 * **/
class ListUsingHashMap {
    private val hashMap = HashMap<Int, Int>()
    private var listSize = 0
    fun add(item: Int) {
        hashMap[listSize] = item
        listSize++
    }

    fun getValue(index: Int): Int? {
        if(index >= listSize){
            throw ArrayIndexOutOfBoundsException()
        }
        return hashMap[index]
    }

    fun remove(index : Int){
        if(index >= listSize){
            throw ArrayIndexOutOfBoundsException()
        }
        if(index == listSize -1){
            hashMap.remove(index)
        }else{
            for(i in index until listSize){
                hashMap[i] = hashMap[i+1] ?: 0
            }
            hashMap.remove(listSize)
        }
        listSize--
    }

}

fun main(){
    val list = ListUsingHashMap()

    list.add(1)
    list.add(4)
    list.add(6)
    list.add(8)

    list.remove(3)

    print("Item at index 2 is ${list.getValue(2)}")
}