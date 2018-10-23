import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Consumer
import kotlin.concurrent.thread

class CounterImpl : Counter {

    override fun count(seed: Int, consumer: Consumer<Int>) {

        val atomic = AtomicBoolean(true)

        class SimpleRunnable: Runnable {
            override fun run() {
                Thread.sleep(5000)
                atomic.set(false)
            }
        }

        Executors.newSingleThreadExecutor().submit(SimpleRunnable())

        generateSequence(seed) { it + 1 }
                .takeWhile { atomic.get() }
                .forEach { consumer.accept(it) }

    }

    fun count2(seed: Int, consumer: Consumer<Int>) {

        val stop = AtomicBoolean(false)

        thread {
            Thread.sleep(5000)
            stop.set(true)
        }

        generateSequence(seed) { it + 1 }
                .takeWhile { !stop.get() }
                .forEach { consumer.accept(it) }

    }


}

