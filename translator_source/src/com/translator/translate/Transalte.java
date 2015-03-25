package com.translator.translate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 翻译功能
 * @author Concise
 *
 */
public class Transalte {

	/**
	 * 执行翻译
	 * @param from 源语言语种
	 * @param to 目标语言语种
	 * @param client_id 开发者的Key
	 * @param content 待翻译内容
	 * @return Json
	 */
	public String tran(String from , String to , String client_id , String content){

		StringBuffer result = new StringBuffer();
		try {
			//得到翻译的URL
			String tranUrl = "http://openapi.baidu.com/public/2.0/bmt/translate?from="+from+"&to="+to+"&client_id="+client_id+"&q="+content;
			URL url = new URL(tranUrl);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
			String line ;
			while ((line=buffer.readLine())!=null) {
				result.append(line);
			}
			buffer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result.toString();
	}
}
