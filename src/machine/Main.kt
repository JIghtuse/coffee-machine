package machine

class Beverage(
        val waterMl: Int,
        val milkMl: Int,
        val beansG: Int,
        val cost: Int
)

val espresso = Beverage(250, 0, 16, 4)
val latte = Beverage(350, 75, 20, 7)
val cappuccino = Beverage(200, 100, 12, 6)

class CoffeeMachine(
        private var waterMl: Int,
        private var milkMl: Int,
        private var beansG: Int,
        private var disposableCups: Int,
        private var money: Int) {

    fun buyCoffee() {
        println()
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")

        val input = readLine()!!

        if (input == "back") return

        when (input.toInt()) {
            1 -> buy(espresso)
            2 -> buy(latte)
            3 -> buy(cappuccino)
        }
    }

    fun fill() {
        print("Write how many ml of water do you want to add: ")
        val addWaterMl = readInt()

        print("Write how many ml of milk do you want to add: ")
        val addMilkMl = readInt()

        print("Write how many grams of coffee beans do you want to add: ")
        val addBeansG = readInt()

        print("Write how many disposable cups of coffee do you want to add: ")
        val addDisposableCups = readInt()

        waterMl += addWaterMl
        milkMl += addMilkMl
        beansG += addBeansG
        disposableCups += addDisposableCups
    }


    fun takeMoney() {
        println()
        println("I gave you $$money")
        money = 0
    }

    fun reportState() {
        println()
        println("The coffee machine has:")
        println("$waterMl of water")
        println("$milkMl of milk")
        println("$beansG of coffee beans")
        println("$disposableCups of disposable cups")
        println("$$money of money")
    }

    private fun buy(beverage: Beverage) {
        val enoughWater = waterMl >= beverage.waterMl
        val enoughMilk = milkMl >= beverage.milkMl
        val enoughBeans = beansG >= beverage.beansG
        val enoughIngredients = enoughWater && enoughMilk && enoughBeans

        val hasACup = disposableCups > 0

        if (enoughIngredients && hasACup) {
            println("I have enough resources, making you a coffee!")
            waterMl -= beverage.waterMl
            milkMl -= beverage.milkMl
            beansG -= beverage.beansG
            disposableCups -= 1
            money += beverage.cost
        } else {
            val whatIsMissing = mutableListOf<String>()
            if (!enoughWater) whatIsMissing.add("water")
            if (!enoughBeans) whatIsMissing.add("beans")
            if (!enoughMilk) whatIsMissing.add("milk")
            if (!hasACup) whatIsMissing.add("disposable cups")
            println("Sorry, not enough ${whatIsMissing.joinToString()}!")
        }
    }
}

fun readInt(): Int {
    return readLine()!!.toInt()
}

fun runMachineLoop() {
    val machine = CoffeeMachine(400, 540, 120, 9, 550)

    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (val action = readLine()!!) {
            "buy" -> machine.buyCoffee()
            "fill" -> machine.fill()
            "take" -> machine.takeMoney()
            "remaining" -> machine.reportState()
            "exit" -> return
            else -> println("Unknown action '$action'")
        }
        println()
    }
}

fun main() {
    runMachineLoop()
}
