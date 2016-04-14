/**
 * ClassName: UserTest <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 10:52 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
class UserTest extends GroovyTestCase {
    def user;
    void setUp() {
        super.setUp()
        user = new User()
        user.firstname = "Li"
        user.lastname = "si"
    }

    void tearDown() {

    }

    void testGetFirstname() {
        assert user.getFirstname() == "Li"
    }

    void testSetFirstname() {

    }

    void testGetLastname() {

    }

    void testSetLastname() {

    }
}
