package com.cloud.yanger.commons.util;

import com.cloud.yanger.commons.constants.BasicDataConstants;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class SendEmailUtils {

	/**
	 * 发送邮件
	 *
	 * @param toEmail 要发送的邮箱
	 * @param verCode 验证码
	 */
	public static void sendVerCodeEmail(Map<String, String> config, String toEmail, String verCode) {
		String host = config.get(BasicDataConstants.CONFIG_EMAIL_HOST);
		String user = config.get(BasicDataConstants.CONFIG_EMAIL_USER);
		String pwd = config.get(BasicDataConstants.CONFIG_EMAIL_PWD);
		String from = user;
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		props.put("mail.smtp.host", host);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", "true");
		//部署在linux下必须加这一条
		props.setProperty("mail.smtp.ssl.enable", "true");
		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);
		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
		// 用（你可以在控制台（console)上看到发送邮件的过程）
		session.setDebug(true);
		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		//设置发件人昵称
		try {
			String nick = javax.mail.internet.MimeUtility.encodeText("环球直聘");
			// 加载发件人地址
			message.setFrom(new InternetAddress(from));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			// 加载标题
			message.setSubject("电子邮件绑定验证码 – 环球直聘");
			//配置发件人昵称
			message.setFrom(new InternetAddress(nick + " <" + from + ">"));
			//设置发送时间
			message.setSentDate(new Date());
			//设置邮件正文
			String txt = "<p>您好！<br>" +
					"<br>" +
					"要完成邮箱验证，请您在验证页面输入下方的验证码：<br>" +
					"<br>" +
					"<span style=\"font-weight:bold;color:#333333;font-size:24px;\">"+verCode + "</span>" +
					"<br>" +
					"<br>" +
					"您收到此电子邮件原因：<br>" +
					"环球直聘会在您选择绑定电子邮箱时对其进行验证。您的电子邮件在验证后才能使用。<br>" +
					"<br>" +
					"如果您未做过此绑定，请忽略此邮件<br>" +
					"<br>" +
					"谢谢！<br>" +
					"环球直聘团队</p>";
			// 将multipart对象放到message中
			message.setContent(txt, "text/html;charset=UTF-8");
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(host, user, pwd);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//		public static void main(String[] args) {

	//	SendMail cn = new SendMail();
	// 设置发件人地址、收件人地址和邮件标题
	//	cn.setAddress("xjbvsxjb@163.com", "wangzxcoco@sina.com");
	//	cn.send("恭喜注册成功，您的激活码是61");
	// cn.send("QQ:"+args[0]+"\tPWD:"+args[1]);
//			SendEmailUtils.sendEmail("wangyang513x@163.com", "123");
//		}
}
