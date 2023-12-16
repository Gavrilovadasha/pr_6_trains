import kotlin.random.Random

val cities = listOf("Москва","Санкт-Петербург","Барнаул","Омск","Великий Новгород","Сочи","Новосибирск","Казань","Тюмень", "Екатеринбург","Пермь","Ульяновск","Пермь","Оренбург","Калининград")
fun createDirection(): String
{
    var startCity = cities.random()
    var endCity = cities.random()
    while (endCity == startCity) {
        endCity = cities.random()
    }
    return "Направление: $startCity - $endCity"
}

    fun sellTickets():Int
    {
        return Random.nextInt(5, 201)
    }
fun formTrain(passengerCount: Int): List<Int> {
    val train = mutableListOf<Int>()
    var remainingPassengers = passengerCount
    while (remainingPassengers > 0) {
        val capacity = Random.nextInt(5, 25)
        if (remainingPassengers < capacity) {
            train.add(remainingPassengers)
            remainingPassengers = 0
        } else {
            train.add(capacity)
            remainingPassengers -= capacity
        }
    }
    return train
}

fun sendTrain(direction: String, train: List<Int>) {
    println("Поезд $direction, состоящий из ${train.size} вагонов отправлен.")
    train.forEachIndexed { index, capacity ->
        println("Вагон ${index + 1}: $capacity пассажиров")
    }
}
fun main() {
    println("Для того, чтобы продолжить работу нажмите 1, для завершения нажмите 2")
    var continueWork = true
    while (continueWork) {
        print("Хотите закончить работу? (yes - 1 /no - 2): ")
        val choice = readln()
        if (choice?.toLowerCase() == "1") {
            continueWork = false
            break
        }
        val direction = createDirection()
        println(direction)
        val tickets = sellTickets()
        println("Продано билетов на поезд: $tickets")
        val train = formTrain(tickets)
        println("Сформирован поезд из ${train.size} вагонов:")
        sendTrain(direction, train)
    }
}