/**
 * ClassName: Subscriber <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 15:21 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
public class Subscriber {

    def "receive"(String msg) {
        println("Subscriber received msg : " + msg)
        return msg;
    }
}
