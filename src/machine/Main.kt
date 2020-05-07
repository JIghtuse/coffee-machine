package machine

const val waterMlPerEspressoCup = 250
const val milkMlPerEspressoCup = 0
const val beansGPerEspressoCup = 16
const val espressoCupCost = 4

const val waterMlPerLatteCup = 350
const val milkMlPerLatteCup = 75
const val beansGPerLatteCup = 20
const val latteCupCost = 7

const val waterMlPerCappuccinoCup = 200
const val milkMlPerCappuccinoCup = 100
const val beansGPerCappuccinoCup = 12
const val cappuccinoCupPrice = 6

fun readInt(): Int {
    return readLine()!!.toInt()
}

fun reportState(waterMl: Int, milkMl: Int, beansG: Int, disposableCups: Int, money: Int) {
    println()
    println("The coffee machine has:")
    println("$waterMl of water")
    println("$milkMl of milk")
    println("$beansG of coffee beans")
    println("$disposableCups of disposable cups")
    println("$money of money")
    println()
}

fun buyCoffee(currentWaterMl: Int, currentMilkMl: Int, currentBeansG: Int, currentDisposableCups: Int, currentMoney: Int) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")

    when (val coffeeType = readInt()) {
        1 -> reportState(
                currentWaterMl - waterMlPerEspressoCup,
                currentMilkMl - milkMlPerEspressoCup,
                currentBeansG - beansGPerEspressoCup,
                currentDisposableCups - 1,
                currentMoney + espressoCupCost)
        2 -> reportState(
                currentWaterMl - waterMlPerLatteCup,
                currentMilkMl - milkMlPerLatteCup,
                currentBeansG - beansGPerLatteCup,
                currentDisposableCups - 1,
                currentMoney + latteCupCost)
        3 -> reportState(
                currentWaterMl - waterMlPerCappuccinoCup,
                currentMilkMl - milkMlPerCappuccinoCup,
                currentBeansG - beansGPerCappuccinoCup,
                currentDisposableCups - 1,
                currentMoney + cappuccinoCupPrice)
        4 -> println("Unknown coffee type $coffeeType")
    }
}

fun fillMachine(currentWaterMl: Int, currentMilkMl: Int, currentBeansG: Int, currentDisposableCups: Int, currentMoney: Int) {
    print("Write how many ml of water do you want to add: ")
    val waterMl = readInt()

    print("Write how many ml of milk do you want to add: ")
    val milkMl = readInt()

    print("Write how many grams of coffee beans do you want to add: ")
    val beansG = readInt()

    print("Write how many disposable cups of coffee do you want to add: ")
    val disposableCups = readInt()

    reportState(
            currentWaterMl + waterMl,
            currentMilkMl + milkMl,
            currentBeansG + beansG,
            currentDisposableCups + disposableCups,
            currentMoney)
}

fun takeMoneyFromMachine(currentWaterMl: Int, currentMilkMl: Int, currentBeansG: Int, currentDisposableCups: Int, currentMoney: Int) {
    println("I gave you $currentMoney")
    reportState(currentWaterMl, currentMilkMl, currentBeansG, currentDisposableCups, 0)
}

fun main() {
    val currentWaterMl = 400
    val currentMilkMl = 540
    val currentCoffeeBeansG = 120
    val currentDisposableCups = 9
    val currentMoney = 550

    reportState(currentWaterMl, currentMilkMl, currentCoffeeBeansG, currentDisposableCups, currentMoney)

    print("Write action (buy, fill, take): ")
    when (val action = readLine()!!) {
        "buy" -> buyCoffee(currentWaterMl, currentMilkMl, currentCoffeeBeansG, currentDisposableCups, currentMoney)
        "fill" -> fillMachine(currentWaterMl, currentMilkMl, currentCoffeeBeansG, currentDisposableCups, currentMoney)
        "take" -> takeMoneyFromMachine(currentWaterMl, currentMilkMl, currentCoffeeBeansG, currentDisposableCups, currentMoney)
        else -> println("Unknown action '$action'")
    }
}
