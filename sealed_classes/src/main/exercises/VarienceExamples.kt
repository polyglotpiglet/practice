//interface Animal
//object Cat : Animal
//
//interface Breeder<out X : Animal> {
//    fun breed(mian: Animal, female: Animal):X
//}
//
//object CatBreeder: Breeder<Cat> {
//    override fun breed(mian: Animal, female: Animal): Cat = Cat
//}
//
//
//fun main(args: Array<String>) {
//
//    val breeder: Breeder<Animal> = CatBreeder
//    val baby: Animal = breeder.breed(Cat, Cat)
//}


//interface Animal
//object Cat : Animal
//object Dog: Animal
//
//interface Breeder<in X : Animal> {
//    fun breed(male: Animal, female: Animal):X
//}
//
//object CatBreeder: Breeder<Cat> {
//    override fun breed(male: Animal, female: Animal): Cat {
//        println("cat")
//        return Cat
//    }
//}
//
//object AnimalBreeder: Breeder<Animal> {
//    override fun breed(male: Animal, female: Animal): Animal {
//        return Dog
//    }
//}


fun main(args: Array<String>) {

}
//    val breeder: CatBreeder<Cat> = AnimalBreeder
//
//    val breeder: Breeder<Animal> = CatBreeder
//    val baby: Animal = breeder.breed(Cat, Cat)
//}