package com.liaoyb.web.api;

import com.github.bingoohuang.patchca.color.ColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;


/**
 * 验证码
 * @author liao
 *
 */
@Controller
@RequestMapping("/CodeController")
public class CodeController  {
	private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
    private static Random random = new Random();
	static {
//      cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
      cs.setColorFactory(new ColorFactory() {
          @Override
          public Color getColor(int x) {
              int[] c = new int[3];
              int i = random.nextInt(c.length);
              for (int fi = 0; fi < c.length; fi++) {
                  if (fi == i) {
                      c[fi] = random.nextInt(71);
                  } else {
                      c[fi] = random.nextInt(256);
                  }
              }
              return new Color(c[0], c[1], c[2]);
          }
      });
      RandomWordFactory wf = new RandomWordFactory();
//      wf.setCharacters("23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
      wf.setCharacters("23456789");
      wf.setMaxLength(4);
      wf.setMinLength(4);
      cs.setWordFactory(wf);
  }
	

	

	
	@RequestMapping("/code")
	public void code(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		setResponseHeaders(response);
        String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
        //设置验证码到域中
        WebUtils.setVerifyCodeSession(request,token);
        System.out.println("当前的SessionID=" + session.getId() + "，验证码=" + token);
	}
	
	
	  //设置验证码的响应头
    protected void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }

}
