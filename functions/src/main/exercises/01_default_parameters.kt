fun sayHello(name: String = "World"): String {
    return "Hello $name!"
}

fun sayHelloTwice(first: String, second: String = first.toUpperCase()): String {
    return "Hello $first! $second?!"
}
