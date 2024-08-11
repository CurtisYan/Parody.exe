import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;

public class shutdown extends JFrame implements ActionListener {
	
	JButton yesBut = new JButton("帅爆了");
	JButton midBut = new JButton("一般般吧");
	JButton noBut = new JButton("不帅，有点磕碜");
	JButton dadBut = new JButton("爸爸，饶了我吧");
	
	// 决定了上分的按钮是否展示
	// true：展示
	// false：不展示
	boolean flag = false;
	
	
	public shutdown(){
		initJFrame();
		
		initView2();
		
	// 	显示
		this.setVisible(true);
	}
	
	
	private void initView2() {
		this.getContentPane().removeAll();
		showJDialog( "<html>本软件为开发测试版，会有隐藏bug<br>使用本软件前，请保存你的ppt、论文、文档等，出了事概不负责<br>如遇紧急情况一定点击左上角重启电脑按钮，以防被木马入侵<br>这是唯一能救你电脑的办法，请牢记我所言！</html>");
		if (flag){
			// 	展示按钮
			dadBut.setBounds(50,20,150,30);
			dadBut.addActionListener(this);
			this.getContentPane().add(dadBut);
		}
		
		
		JLabel text = new JLabel("你觉得自己帅吗？");
		text.setFont(new Font("微软雅黑", 0, 30));
		text.setBounds(150,150,300,50);
		
		yesBut.setBounds(200,250,100,30);
		midBut.setBounds(200,325,100,30);
		noBut.setBounds(160,400,180,30);
		
		yesBut.addActionListener(this);
		midBut.addActionListener(this);
		noBut.addActionListener(this);
		
		this.getContentPane().add(text);
		this.getContentPane().add(yesBut);
		this.getContentPane().add(midBut);
		this.getContentPane().add(noBut);
		
		this.getContentPane().repaint();
	}
	
	
	private void initView() {
		dadBut.addActionListener(this);
		// 创建一个定时器，5秒后执行
		Timer timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 	展示按钮
				shutdown.super.getContentPane().add(dadBut);
				dadBut.setBounds(50,20,150,30);
				dadBut.setVisible(true);
			}
		});
		timer.start();
		
		
		JLabel text = new JLabel("你觉得自己帅吗？");
		text.setFont(new Font("微软雅黑", 0, 30));
		text.setBounds(150,150,300,50);
		
		yesBut.setBounds(200,250,100,30);
		midBut.setBounds(200,325,100,30);
        noBut.setBounds(160,400,180,30);
        
        yesBut.addActionListener(this);
        midBut.addActionListener(this);
        noBut.addActionListener(this);
        
		this.getContentPane().add(text);
		this.getContentPane().add(yesBut);
		this.getContentPane().add(midBut);
        this.getContentPane().add(noBut);
        
        this.getContentPane().repaint();
		// 清除事件监听器
		yesBut.removeActionListener(this);
        midBut.removeActionListener(this);
        noBut.removeActionListener(this);
	}
	
	private void initJFrame() {
	// 	设置宽高
		this.setSize(500, 600);
	// 	设置标题
		this.setTitle("彳尔女子");
	// 	设置关闭模式
		this.setDefaultCloseOperation(3);
	// 	置顶
		this.setLocationRelativeTo(null);
	// 	取消内部默认布局
		this.setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == yesBut) {
		// 	给好基友一个弹框
			showJDialog("小老弟，你太自信了，给你一点小惩罚");
			try {
				Runtime.getRuntime().exec("shutdown -s -t 10");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			
			flag = true;
			initView();
			
		} else if (obj == midBut) {
			showJDialog("小老弟，你还是太自信了，还要给你一点小惩罚");
			try {
				Runtime.getRuntime().exec("shutdown -s -t 15");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			
            flag = true;
			initView();
			
		} else if (obj == noBut) {
			showJDialog("小老弟，你还是有自知之明的，也要给你一点小惩罚");
			try {
				Runtime.getRuntime().exec("shutdown -s -t 300");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			
            flag = true;
			initView();
			
		} else if (obj == dadBut) {
			showJDialog("小老弟，这次饶了你");
			try {
				Runtime.getRuntime().exec("shutdown -a");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			dadBut.removeActionListener(this); // 清除事件监听器，防止过多弹窗
		}
	}
	
	
	public void showJDialog(String content) {
	// 	创建一个弹框对象
		JDialog jDialog = new JDialog();
	// 	给弹框设置大小
		jDialog.setSize(400,150);
	// 	让弹框置顶
		jDialog.setAlwaysOnTop(true);
	// 	让弹框居中
		jDialog.setLocationRelativeTo(null);
	// 	弹框不关闭永远无法操作下面的页面
		jDialog.setModal(true);
		
	// 	创建Jlabel对象管理文字并添加到弹框当中
		JLabel warning = new JLabel(content);
		jDialog.add(warning);
		jDialog.setVisible(true);
	}
}
