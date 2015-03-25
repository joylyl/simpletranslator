package com.translator.frame;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.translator.translate.Transalte;
import com.translator.util.JsonUtil;

/**
 * 主窗体
 * @author Concise
 *
 */
public class MainFrame extends JFrame {
	
	//记录源语言和目标语言
	String languages[] = new String[2];
	
	
	public MainFrame() {
		this.setTitle("Simple Translator");
		this.setLayout(null);
		this.setSize(300,400);
		this.setVisible(true); 	
		this.setResizable(false);
		
		//源语言选择下拉列表
		JComboBox sourcelanguages = new JComboBox();
		sourcelanguages.addItem("自动");
		sourcelanguages.addItem("中文");
		sourcelanguages.addItem("日语");
		sourcelanguages.addItem("西班牙语");
		sourcelanguages.addItem("泰语");
		sourcelanguages.addItem("俄罗斯语");
		sourcelanguages.addItem("粤语");
		sourcelanguages.addItem("白话文");
		sourcelanguages.addItem("德语");
		sourcelanguages.addItem("荷兰语");
		sourcelanguages.setSize(130, 30);
		sourcelanguages.setLocation(10, 5);
		
		//目标语言选择下拉列表
		JComboBox targetlanguages = new JComboBox();
		targetlanguages.addItem("中文");
		targetlanguages.addItem("日语");
		targetlanguages.addItem("西班牙语");
		targetlanguages.addItem("泰语");
		targetlanguages.addItem("俄罗斯语");
		targetlanguages.addItem("粤语");
		targetlanguages.addItem("白话文");
		targetlanguages.addItem("德语");
		targetlanguages.addItem("荷兰语");
		targetlanguages.setSize(130, 30);
		targetlanguages.setLocation(150, 5);
		
		//原语言
		final JTextArea sourceArea = new JTextArea();
		sourceArea.setText("Hello");
		sourceArea.setSize(270,150);
		sourceArea.setLocation(10,40);
		sourceArea.setFocusable(true);
		
		//目标语言
		final JTextArea targetArea = new JTextArea();
		targetArea.setText("你好");
		targetArea.setSize(270,150);
		targetArea.setLocation(10,200);
		
		this.add(sourcelanguages);
		this.add(targetlanguages);
		this.add(targetArea);
		this.add(sourceArea);

		sourceArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10){
					//得到转换后的语言代码
					String results[] = getFromAndTo(languages[0]==null ? "自动" : languages[0], languages[1]==null ? "中文" : languages[1]);
					//赋值到目标文本域
					String resString = JsonUtil.transalteJson(new Transalte().tran(results[0], results[1], "GCt5DGu6pLcKosYiiHjGbXFn", sourceArea.getText()));
					targetArea.setText(resString);
				}
			}
		});
		
		//获取选中的源语言
		sourcelanguages.addItemListener(new ItemListener() {	
			public void itemStateChanged(ItemEvent e) {
				languages[0]=e.getItem().toString();
			}
		});
		
		//获取选中的目标语言
		targetlanguages.addItemListener(new ItemListener() {	
			public void itemStateChanged(ItemEvent e) {
				languages[1]=e.getItem().toString();
			}
		});
		
	}
		
	public String[] getFromAndTo(String sourceText , String targetText){
		//存入from 和 to 的对应值
		String result[] = new String[2];
		if(sourceText.equals("自动")) result[0] = "auto";
		else if(sourceText.equals("中文")) result[0] = "zh";
		else if(sourceText.equals("日语")) result[0] = "jp";
		else if(sourceText.equals("西班牙语")) result[0] = "spa";
		else if(sourceText.equals("泰语")) result[0] = "th";
		else if(sourceText.equals("俄罗斯语")) result[0] = "ru";
		else if(sourceText.equals("粤语")) result[0] = "yue";
		else if(sourceText.equals("白话文")) result[0] = "zh";
		else if(sourceText.equals("德语")) result[0] = "de";
		if(sourceText.equals("荷兰语")) result[0] = "nl";
		
		else if(targetText.equals("中文")) result[1] = "zh";
		else if(targetText.equals("日语")) result[1] = "jp";
		else if(targetText.equals("西班牙语")) result[1] = "spa";
		else if(targetText.equals("泰语")) result[1] = "th";
		else if(targetText.equals("俄罗斯语")) result[1] = "ru";
		else if(targetText.equals("粤语")) result[1] = "yue";
		else if(targetText.equals("白话文")) result[1] = "zh";
		else if(targetText.equals("德语")) result[1] = "de";
		if(targetText.equals("荷兰语")) result[1] = "nl";
		return result;
	}
	
	public static void main(String[] args) {
		try
	    {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
			//UIManager.put("RootPane.setupButtonVisible", false);
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e){}
		
		new MainFrame();
	}
}

