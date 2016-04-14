package closure

import spock.lang.Specification

/**
 * ClassName: SimpleTest <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 11:22 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
class SimpleTest extends Specification {
    def "Greet"() {
        given:
        def greet = {"Hello $it!"}
        expect:
        assert greet("Tom") == "Hello Tom!"

    }

    def "Closure take not any param"() {
        given:
        def bye = {-> "bye"}
        expect:
        assert bye() == "bye"
    }

    def "Closure take several param"() {
        given:
        def niceGreet = {firstName,lastName -> "Hello ,$firstName $lastName"}
        expect:
        assert niceGreet("Tom","Jerry") == "Hello ,Tom Jerry"
    }
}
