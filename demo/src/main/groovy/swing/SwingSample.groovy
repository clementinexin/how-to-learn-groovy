package swing

import javax.swing.*
import java.awt.*
import java.awt.event.ActionListener
import java.awt.event.FocusListener
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

/**
 * Created by daijiajia on 2016/12/18.
 */
class SwingSample {

    def main() {
        frame = new JFrame(size: [200, 200], layout: new FlowLayout(), defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)
        button = new JButton("click")
        positionLabel = new JLabel("")
        msgLabel = new JLabel("")

        //这里将声明的组件添加到容器中
        frame.contentPane.add button
        frame.contentPane.add positionLabel
        frame.contentPane.add msgLabel

        //使用as可以对实现进行简化，这里直接将实现之后的具体操作通过as指代给具体的事件监听
        button.addActionListener(
                {
                    JOptionPane.showMessageDialog(frame, 'You clicked!')
                } as ActionListener)
        displayMousePosition = { positionLabel.setText("$it.x, $it.y") }
        frame.addMouseListener(displayMousePosition as MouseListener)
        frame.addMouseMotionListener(displayMousePosition as MouseMotionListener)

        //对于接口中的多个方法，在groovy中没有去强制实现所有的方法，我们只需要实现自己需要的就可以了，下面就是实现了对应需要的两个方法
        handlerFocus = [
                focusGained: { msgLabel.setText("good to see you!") },
                focusLost  : { msgLabel.setText("Come back soon!") }
        ]
        button.addFocusListener(handlerFocus as FocusListener)

        //实现动态的接口实现,可以使用asType
        events = ["WindowListener", "ComponentListener"]
        handler = { msgLabel.setText("$it") } //这里的it表示的是传入的参数
        for (event in events) {
            handlerImpl = handler.asType(Class.forName("java.awt.event.${event}"))
            frame."add${event}"(handlerImpl)
        }

        //简要分析
        //handlerImpl = handler.asType(Class.forName("java.awt.event.${event}"))
        // 这里相当于如下代码
        //handlerImpl = { msgLabel.setText("$it") } as WindowListener,当然，这里是实现WindowListener还是ComponentListener还要看传入的参数决定，因为是动态的
        //frame."add${event}"(handlerImpl)则相当于frame.addWindowListener(handlerImpl), 当然这里的addWindowListener也是动态的
        frame.show()
    }
}
