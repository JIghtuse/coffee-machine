package machine

fun reportIngredientAmounts(numberOfCups: Int) {
    val water = 200 * numberOfCups
    val milk = 50 * numberOfCups
    val beans = 15 * numberOfCups

    println("For $numberOfCups of coffee you will need:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
}

fun main() {
    print("Write how many cups of coffee you will need: ")

    val numberOfCups = readLine()!!.toInt()

    reportIngredientAmounts(numberOfCups)
}
