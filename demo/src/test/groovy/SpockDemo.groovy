import spock.lang.Specification

/**
 * ClassName: SpockDemo <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 14:50 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
class SpockDemo extends Specification {

    def "When and then blocks"() {
        given:
        def stack = new Stack()
        when:
        stack.push 1
        then:
        !stack.empty()
        stack.size() == 1
        stack.peek() == 1
    }

    def "Assert Exception"() {
        given:
        def stack = new Stack()
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
    }

    def "Map accept null as key"() {
        given:
        def map = [:]
        when:
        map.put null,"null"
        then:
        notThrown(NullPointerException)
    }

    def "Maximum of two numbers"() {
        expect:
        Math.max(a,b) == c
        where:
        a | b || c
        3 | 8 || 8
        99| 98||99
    }

    @Unroll
    def "Maximum of #a and #b should be #c"() {
        expect:
        Math.max(a,b) == c
        where:
        a | b || c
        3 | 8 || 8
        99| 98||99
    }
}
