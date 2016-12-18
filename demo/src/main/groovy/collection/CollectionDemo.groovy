package collection

/**
 * ClassName: CollectionDemo <br/>
 * Description: TODO <br/>
 * Date: 2016-04-14 13:40 <br/>
 * <br/>
 *
 * @author jdai@
 *
 * 修改记录
 * @version v1.0.1 2016-04-14 jdai@ created. <br/>
 */
class CollectionDemo {

    public static void main(String[] args) {
        def list = [5, 6, 7, 8]
        assert list.get(2) == 7
        assert list[2] == 7
        assert list instanceof java.util.List

        def emptyList = []
        assert emptyList.size() == 0
        emptyList.add(5)
        assert emptyList.size() == 1
    }
}
