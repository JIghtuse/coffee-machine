package machine

const val waterMlPerCup = 200
const val milkMlPerCup = 50
const val beansGPerCup = 15

fun calculateNumberOfCupsForIngredients(waterMl: Int, milkMl: Int, beansG: Int): Int {
    val numberOfCupsForGivenWater = waterMl / waterMlPerCup
    val numberOfCupsForGivenMilk = milkMl / milkMlPerCup
    val numberOfCupsForGivenBeans = beansG / beansGPerCup

    return arrayListOf(numberOfCupsForGivenWater, numberOfCupsForGivenMilk, numberOfCupsForGivenBeans).min()!!
}

fun reportAbilityToMakeCoffee(numberOfCups: Int, numberOfCupsWhichCanBeMade: Int) {
    when {
        numberOfCups == numberOfCupsWhichCanBeMade ->
            println("Yes, I can make that amount of coffee")
        numberOfCups < numberOfCupsWhichCanBeMade -> {
            val numberOfCupsOverAskedAmount = numberOfCupsWhichCanBeMade - numberOfCups
            println("Yes, I can make that amount of coffee (and even $numberOfCupsOverAskedAmount more than that)")
        }
        numberOfCups > numberOfCupsWhichCanBeMade ->
            println("No, I can make only $numberOfCupsWhichCanBeMade cups of coffee")
    }
}

fun readInt(): Int {
    return readLine()!!.toInt()
}

fun main() {
    print("Write how many ml of water the coffee machine has: ")
    val waterMl = readInt()

    print("Write how many ml of milk the coffee machine has: ")
    val milkMl = readInt()

    print("Write how many grams of coffee beans the coffee machine has: ")
    val beansG = readInt()

    print("Write how many cups of coffee you will need: ")
    val numberOfCups = readLine()!!.toInt()

    val numberOfCupsWhichCanBeMade = calculateNumberOfCupsForIngredients(waterMl, milkMl, beansG)
    reportAbilityToMakeCoffee(numberOfCups, numberOfCupsWhichCanBeMade)
}
