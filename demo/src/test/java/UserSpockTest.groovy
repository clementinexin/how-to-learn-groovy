import spock.lang.Specification

/**
 * ClassName: UserSpockTest <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 11:00 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
class UserSpockTest extends Specification {
    def user;
    void setup() {
        user = new User()
        user.firstname = "Li"
        user.lastname = "si"
    }


    void cleanup() {

    }

    def "GetFirstname"() {
        when:
        assert user.getFirstname() == "Li"
        then:
        thrown(MissingMethodException)
    }

    def "GetLastname"() {

    }

    def "SetLastname"() {

    }
}
