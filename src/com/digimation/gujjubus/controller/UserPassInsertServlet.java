package com.digimation.gujjubus.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.Destination;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.digimation.gujjubus.bean.OrganizationBean;
import com.digimation.gujjubus.bean.PassBean;
import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.OrganizationDAO;
import com.digimation.gujjubus.dao.PassDAO;
import com.digimation.gujjubus.dao.ScheduleDetailDAO;
import com.digimation.gujjubus.dao.StationDAO;
import com.digimation.gujjubus.util.ValidateUtils;

public class UserPassInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sourceId,destinationId, passTypeId,start,
	 validity,termValidity,organizationName,organizationAddress,
orgId,fileName;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PassBean passBean=new PassBean();
		boolean isError=false;
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		String fieldName=null;
		String fieldValue=null;
		File file=null;
		ServletContext context = getServletContext();
		try {
			items=upload.parseRequest(request);
		
		for(int i=0;i<items.size();i++)
		{	
			FileItem item=items.get(i);
			if(item.isFormField())
			{
				fieldName=item.getFieldName();
				fieldValue=item.getString();
				
					if(fieldName.equals("selsource"))
					{
						sourceId=fieldValue;
					}
					
					else if(fieldName.endsWith("seldestination"))
					{
						destinationId=fieldValue;
					}
					else if(fieldName.equals("rdopassType"))
					{
						passTypeId=fieldValue;
					}
					else if(fieldName.equals("rdoval"))
					{
							validity=fieldValue;
					}
					else if(fieldName.equals("rdostart"))
					{
							start=fieldValue;
					}
					else if(fieldName.equals("seltermvalidity"))
					{
						termValidity=fieldValue;
					}
					else if(fieldName.equals("selorg"))
					{
						orgId=fieldValue;
					}
					else if(fieldName.equals("txtorg"))
					{
						organizationName=fieldValue;
					}
					else if(fieldName.equals("txtaddress"))
					{
							organizationAddress=fieldValue;
					}
					

			}
			else
			{
				fieldName=item.getFieldName();
				fileName=item.getName();
				System.out.println("file name"+fieldName);
				String path="F:\\java\\eclipse workspace\\BUSINDICATOR\\WebContent\\upload\\pass";
				file=new File(path+File.separator+fileName);
				if(fileName.isEmpty())
				{
					isError=true;
					request.setAttribute("msgfile","please select passport size photo");
				}
				else
				{
					if (context.getMimeType(fileName).equals("image/gif")
							|| context.getMimeType(fileName)
									.equals("image/jpeg")
							|| context.getMimeType(fileName)
									.equals("image/png"))
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					else
							request.setAttribute("msgfile","Please upload files that end in types .png,.jpeg only.");

				}
			}
		}
			
	
	if(start==null)
		{
			isError=true;
			request.setAttribute("msgday", "select day of pass");
		}
	else
		passBean.setStart(Integer.parseInt(start));
		if(validity==null)
		{
			isError=true;
			request.setAttribute("msgval", "select validity");
		}
		else
			passBean.setValidity(Integer.parseInt(validity));
	
		if(termValidity.equals("0"))
		{
			isError=true;
			request.setAttribute("msgtermval", "select term validity");
		}
		else
			passBean.setTermValidity(Integer.parseInt(termValidity));
		if(orgId.equals("0"))
		{
		if(ValidateUtils.isEmpty(organizationName))
		{
			isError=true;
			request.setAttribute("msgorgname", "*");
		}
		else if(ValidateUtils.validateText(organizationName))
		{
			isError=true;
			request.setAttribute("msorgname", "please enter valid org name");
		
		}		
		else
			passBean.setOrgName(organizationName);
		if(ValidateUtils.isEmpty(organizationAddress))
		{
			isError=true;
			request.setAttribute("msgorgadd", "*");
		}	
		else
			passBean.setOrgAdd(organizationAddress);
	/*	else if(ValidateUtils.validateText(organizationAddress))
		{
			isError=true;
			request.setAttribute("msgorgadd", "please enter valid org address");
		}*/
		}
		else 
			passBean.setOrgId(Integer.parseInt(orgId));
		if(Integer.parseInt(destinationId)==0)
		{
			request.setAttribute("msgdes", "please select destination");
			isError=true;
		}
		else
			passBean.setDestinationId(Integer.parseInt(destinationId));
		if(Integer.parseInt(sourceId)==0)
		{
			request.setAttribute("msgsource", "please select source");
			isError=true;
		}
		else
			passBean.setSourceId(Integer.parseInt(sourceId));
		if(passTypeId==null)
		{
			request.setAttribute("msgpasstype", "please select pass type");
			isError=true;
		}	
		else
			passBean.setPassTypeId(Integer.parseInt(passTypeId));
		if(isError)
		{
			
			request.setAttribute("passBean", passBean);
			request.getRequestDispatcher("UserPassInsert.jsp").forward(request, response);
		}
		else
		{
			
			OrganizationBean organizationBean=null;		
			
			PassDetailBean passDetailBean=new PassDetailBean();
			passDetailBean.setValidity(Integer.parseInt(validity));
			System.out.println(start+" start");
			if(start.equals("1"))
				passDetailBean.setStartDate("curdate()");
			
			else 
				passDetailBean.setStartDate("date_add(curdate(),interval 1 day)");
			if(!orgId.equals("0")){
				passBean.setOrgId(Integer.parseInt(orgId));
				organizationBean=new OrganizationDAO().getOrganizationListByPK(Integer.parseInt(orgId));
			}
					
			else
			{
				 organizationBean=new OrganizationBean();
				organizationBean.setOrganizationAddress(organizationAddress);
				organizationBean.setOrganizationName(organizationName);
			
			}
			passDetailBean.setTotalAmount(Integer.parseInt(validity)*200);
			passBean.setTermValidity(Integer.parseInt(termValidity));
			passBean.setPassTypeId(Integer.parseInt(passTypeId));
			HttpSession session=request.getSession();
			UserBean userBean= (UserBean)session.getAttribute("userBean");
			passBean.setUserId(userBean.getUserId());
			passBean.setDestinationId(Integer.parseInt(destinationId));
			passBean.setSourceId(Integer.parseInt(sourceId));
			passBean.setSource(new StationDAO().getStationListByPK(Integer.parseInt(sourceId)).getStationName());
			passBean.setDestination(new StationDAO().getStationListByPK(Integer.parseInt(destinationId)).getStationName());
			passBean.setPhoto(fileName);
			session.setAttribute("passDetailBean",passDetailBean);	
			session.setAttribute("PassBean",passBean);
			session.setAttribute("orgBean", organizationBean);
			response.sendRedirect("UserPassConfirm.jsp");
			
		}
		} catch (FileUploadException e) {
			e.printStackTrace();	
		}


	}

}
