package com.digimation.gujjubus.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.PassDAO;

public class UserPassConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		PassDetailBean passDetailBean = (PassDetailBean) session
				.getAttribute("passDetailBean");
		PassBean passBean = (PassBean) session.getAttribute("PassBean");
		OrganizationBean organizationBean = (OrganizationBean) session
				.getAttribute("orgBean");
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		try {
			ByteArrayOutputStream out = QRCode
					.from(userBean.getFirstName()
							+"-" + passBean.getSource()+"-"
							+ passBean.getDestination()+"-15/12/2015 to 14/2/16").to(ImageType.GIF)
					.stream();
			FileOutputStream fout = new FileOutputStream(
					new File("F:\\java\\eclipse workspace\\BUSINDICATOR\\WebContent\\upload\\QRCode\\"
			+userBean.getFirstName()+".gif"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();
System.out.println(userBean.getFirstName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (new PassDAO().addPass(passBean, passDetailBean, organizationBean)) {
			response.sendRedirect("UserPassPrint.jsp");
		}

	}

}
