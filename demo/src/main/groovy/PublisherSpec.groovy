

import spock.lang.Specification

/**
 * ClassName: PublisherSpec <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 15:12 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */

/**
 1 * subscriber.receive("hello")      // exactly one call
 0 * subscriber.receive("hello")      // zero calls
 (1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
 (1.._) * subscriber.receive("hello") // at least one call
 (_..3) * subscriber.receive("hello") // at most three calls
 _ * subscriber.receive("hello")      // any number of calls, including zero
 1 * subscriber.receive("hello")     // an argument that is equal to the String "hello"
 1 * subscriber.receive(!"hello")    // an argument that is unequal to the String "hello"
 1 * subscriber.receive()            // the empty argument list (would never match in our example)
 1 * subscriber.receive(_)           // any single argument (including null)
 1 * subscriber.receive(*_)          // any argument list (including the empty argument list)
 1 * subscriber.receive(!null)       // any non-null argument
 1 * subscriber.receive(_ as String) // any non-null argument that is-a String
 1 * subscriber.receive({ it.size() > 3 }) // an argument that satisfies the given predicate
 // (here: message length is greater than 3)
 1 * subscriber._(*_)     // any method on subscriber, with any argument list
 1 * subscriber._         // shortcut for and preferred over the above
 1 * _._                  // any method call on any mock object
 1 * _                    // shortcut for and preferred over the above
 */
class PublisherSpec extends Specification{

    Publisher pusisher = new Publisher()
    Subscriber subscriber1 = Mock()
    Subscriber subscriber2 = Mock()

    def "setup"() {
        pusisher.subscribers = [subscriber1,subscriber2]
    }

    def "when publish a msg all subscribers should received" () {
        when:
        pusisher.send("Hello")

        then:
        1 * subscriber1.receive("Hello")
        1 * subscriber2.receive("Hello")
    }

    def "subscriber >> "() {
        when:
        subscriber1.receive(_) >> "OK"
        then:
        subscriber1.receive("not OK") == "OK"
    }

    def "subscriber >>> "() {
        when:
        subscriber1.receive(_) >>> ["OK","ERR","OK"] >> {throw new InternalError()}
        then:
        subscriber1.receive("some thing") == "OK"
        subscriber1.receive("no thing") == "ERR"
        subscriber1.receive("any thing") == "OK"
//        subscriber1.receive("some thing") and thrown(new InternalError())

    }
}
