package smsVerCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * ���裺
 *  1.����
 *  2.������
 *  3.���ַ�
 *  4.��������
 */
public final  class ImageUtil {
	 // ��֤���ַ���
	private static final char[] chars={
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};
	 // �ַ�����
	private static final int SIZE=4;
	//����������
	private static final int LINES=4;
	 // ���
	private static final int WIDTH = 80;
	 // �߶�
	private static final int HEIGHT = 40;
	// �����С
	private static final int FONT_SIZE = 30;
	
    /**
     * ���������֤�뼰ͼƬ
     * Object[0]��֤���ַ���String
     * Object[1]��֤��ͼƬ   BufferedImage
     */
	public static Object[] createImage(){
		StringBuffer sb=new StringBuffer();
		//1�������հ�ͼƬ
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); 
		//2����ȡͼƬ����
		Graphics graphics=image.getGraphics();
		//3�����û�����ɫ
		graphics.setColor(Color.LIGHT_GRAY);
		//4�����ƾ��α���
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		//������ַ�
		Random ran=new Random();
		for (int i = 0; i < SIZE; i++) {
			  // ȡ����ַ�����
			int n=ran.nextInt(chars.length-i);
			//��������ַ���ɫ
			graphics.setColor(getRandomColor());
			//���������С
			graphics.setFont(new Font(
					null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			//���ַ�
			graphics.drawString(chars[n]+"", i*10*WIDTH/HEIGHT	, HEIGHT/2-i);
			//��¼�ַ�
			sb.append(chars[n]);
		}
		//��������
		for (int i = 0; i < LINES; i++) {
			//���������ɫ
			graphics.setColor(getRandomColor());
			//�������
			graphics.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		//7��������֤���ͼƬ
		return new Object[]{sb.toString(),image};
		
	}
	public static Color getRandomColor(){
		Random ran=new Random();
		  Color color = new Color(ran.nextInt(256), 
	                ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
	public static void main(String[] args) throws IOException {
		Object[] objs=createImage();
		BufferedImage image=(BufferedImage) objs[1];
		//ͼƬ��ʽ�����Զ��壬java��pngͼƬ��ʾ����������·�����Զ���
		OutputStream os=new FileOutputStream("D:/xx.png");
		 //ע��ͼƬ��ʽ�봴����ʽƥ��
	    ImageIO.write(image, "png", os);
	    os.close();
	}
}
