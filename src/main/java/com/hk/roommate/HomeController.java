package com.hk.roommate;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;   
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.roommate.daos.LoginDao;
import com.hk.roommate.daos.ILoginDao;
import com.hk.roommate.service.LoginService;
import com.hk.roommate.service.RoomupdateService;
import com.hk.roommate.service.IAnsService;
import com.hk.roommate.service.IFileService;
import com.hk.roommate.service.IInterestService;
import com.hk.roommate.service.ILoginService;
import com.hk.roommate.service.IRoomupdateService;
import com.hk.roommate.dtos.*;


/**  
 * Handles requests for the application home page.
 */
@Controller  
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    private static final String String = null;
    
	@Autowired(required=true)
	private ILoginService loginService;
	
	@Autowired(required=true)
	private IRoomupdateService roomupdateService;
	
	@Autowired(required=true)
	private IFileService fileService;
	
	@Autowired(required=true)
	private IInterestService interestService;
	
	@Autowired(required=true)
	private IAnsService ansService;
	


//	1.INDEX
//	1-1)로그인
	@RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request, String id, String pw, Locale locale, Model model) throws UnsupportedEncodingException {
		logger.info("로그인 {}.", locale);

		LoginDto ldto=loginService.getLogin(id, pw);
		String s=null;
		if(ldto==null||ldto.getId()==null) {
			String msg="회원정보를 확인하세요";
			return "redirect:error.do?msg="+URLEncoder.encode(msg,"utf-8");

		}else {
			//session 스코프에 로그인 정보 담기
			request.getSession().setAttribute("ldto", ldto);
			request.getSession().setMaxInactiveInterval(10*60);
  
			if(ldto.getRole().toUpperCase().equals("USER1")) {
				s= "user_main";
			}else if(ldto.getRole().toUpperCase().equals("USER2")) {
				s= "user2_main";
			}else if(ldto.getRole().toUpperCase().equals("MANAGER")) {
				s=  "admin_main";
			}else { 
				s= "admin_main"; 
			}
			return s;
		}  
	}  
	
//	1-2)회원가입 폼으로 이동하기
	@RequestMapping(value = "/registform.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String goregistform(Locale locale) throws UnsupportedEncodingException {
		logger.info("회원가입.", locale);
		return "registform"; 
	}   
	
//	1-3)회원가입시 진행하는 ID 체크
	@RequestMapping(value = "/idchk.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String idchk(String id, Locale locale, Model model) throws UnsupportedEncodingException {
		logger.info("아이디체크.", locale);

		String resultId = loginService.idChk(id);// 중복된 아이디 확인: 결과값이 있으면 사용X

		String isS="y";//사용여부를 나타내는 isS 정의(y는 사용가능, n은 사용못함)
		if(resultId!=null){
			isS="n";
		}
		model.addAttribute("id", id);
		model.addAttribute("isS", isS);
		return "idchk";        
	}   

//	1-4)회원가입
	@RequestMapping(value = "/after_regist.do")
	public String regist(LoginDto dto,@RequestParam("id") String id, Locale locale, Model model) {
		logger.info("회원가입.", locale);

		boolean isS=loginService.insertUser(new LoginDto(dto.getId(),dto.getName(),dto.getPassword(),
				dto.getAddress(),dto.getPhone(),dto.getEmail(),dto.getRole()));  
		if(isS) {
			return "redirect:index.jsp";    			
		}else {
			return "error"; 
		}
	}   

//	2.공통기능 - 메인페이지로 돌아가기
	@RequestMapping(value = "/back.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String gotomain(HttpServletRequest request, String id, Locale locale, Model model) throws UnsupportedEncodingException {
		logger.info("메인.", locale);
		
		LoginDto dto = loginService.getuserinfo(id);
		String s = null;
  
			if(dto.getRole().toUpperCase().equals("USER1")) {
				s= "user_main";
			}else if(dto.getRole().toUpperCase().equals("USER2")) {
				s= "user2_main";
			}else if(dto.getRole().toUpperCase().equals("MANAGER")) {
				s=  "admin_main";
			}else {
				s= "admin_main";  
			} 
			return s;
		}  
	
//  3.USER1기능
//	3-1)페이지이동
	
	
//	3-2) 나의정보 보기
	@RequestMapping(value = "/userinfo.do")
	public String userinfo(@RequestParam("id") String id, Locale locale, Model model) {
		logger.info("나의정보.", locale);
     
		LoginDto dto = loginService.getuserinfo(id);

		model.addAttribute("id", id);
		model.addAttribute("name", dto.getName());
		model.addAttribute("address", dto.getAddress());
		model.addAttribute("phone", dto.getPhone());
		model.addAttribute("email", dto.getEmail());
		model.addAttribute("role", dto.getRole());
	
		return "userinfo";	
	}  
	

	
//	3-3)나의정보 수정
	@RequestMapping(value = "/updateform.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String update(@RequestParam("id") String id, Locale locale, Model model) {
		logger.info("개인정보수정페이지 .", locale);
		
	   LoginDto dto = loginService.getuserinfo(id);
	    
		model.addAttribute("id", id);
		model.addAttribute("name", dto.getName());
		model.addAttribute("address", dto.getAddress());
		model.addAttribute("phone", dto.getPhone());
		model.addAttribute("email", dto.getEmail());
		model.addAttribute("role", dto.getRole());
		
		return "updateform";      
	}
	
  
	@RequestMapping(value = "/after_updateuser.do")
	public String updateuser(@RequestParam("id") String id,@RequestParam("address") String address,
			@RequestParam("phone") String phone, @RequestParam("email") String email, Locale locale, Model model) {
		logger.info("나의정보업데이트.", locale);
  
		
		boolean isS=loginService.updateUser(new LoginDto(id,address,phone,email));
		
		if(isS) {
			return "redirect:userinfo.do?id="+id;    			
		}else {
			
			return "error"; 
		} 
		
	}   
	
//	4.관리자 기능
//	4-1)페이지 이동
	
//	방리스트
	@RequestMapping(value = "/roomlist.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String roomlist(Locale locale, Model model) {
		logger.info("방리스트", locale);
		
		List<RoomupdateDto> rList = roomupdateService.getRoomList();
		List<filedto> fList = fileService.getFileList();
        
		model.addAttribute("fList", fList);
		model.addAttribute("rList", rList);;

	    System.out.println((new StringBuilder("f: ")).append(fList.size()).toString());
	    System.out.println((new StringBuilder("r: ")).append(rList.size()).toString());
		       
		return "roomlist"; 	
	}   
  
//	방추기페이지
	@RequestMapping(value = "/roomadd.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String roomadd(Locale locale) { 
		logger.info("방추가페이지", locale); 
		return "roomupdateform";        
	}         
	   
//	방 등록 FORM
	@RequestMapping(value = "/after_roomupdate.do")  
	public String roomupdate(String lat, String lng, HttpServletRequest request, RoomupdateDto dto, Locale locale, Model model) {
		logger.info("방등록.", locale); 

		boolean isS = roomupdateService.Roomupdate(new RoomupdateDto(dto.getLocation(), dto.getR_title(), dto.getRoom1(), dto.getRoom2(), dto.getR_size(), dto.getCost1(), dto.getCost2(), dto.getCost3(), dto.getCost4(), lat, lng, dto.getParking(), dto.getStare(), dto.getDetail(), dto.getRoomoption(), dto.getInfo()));
		boolean isS2 = fileService.multiInsertFileInfo(request);
  
	    if(isS&&isS2) {  
			return "redirect:roomlist.do";    			
		}else {
			return "error"; 
		}
        
	}
	
	@RequestMapping(value = "/detailroom.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String detail(@RequestParam("f_seq") int seq,Locale locale, Model model, RoomupdateDto dto) { 
		logger.info("방상세보기", locale); 
		System.out.println(seq);
		
        
		RoomupdateDto rDto=roomupdateService.detailRoom(seq);  
        List<filedto>fList=fileService.detailFile(seq);
        
        model.addAttribute("rDto", rDto);  
        model.addAttribute("fList", fList);  
        
		return "detailroom";        
	}  
	
	//방삭제하기
	@RequestMapping(value = "/removeroom.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String removeroom(@RequestParam("f_seq") int seq,Locale locale, Model model, RoomupdateDto dto) { 
		logger.info("방삭제", locale); 
		
		boolean isS = roomupdateService.Rdel(seq);
		boolean isS2= fileService.Fdel(seq);
		
       try{         
    	   
    	   if(isS&&isS2==true) {
    		   model.addAttribute("msg", "게시물이 삭제되었습니다.");
    		   model.addAttribute("url", "roomlist.do");}
    	   
    	   } catch (NullPointerException e) {
               //로그인 실패
               model.addAttribute("msg","방삭제 실패");    
               model.addAttribute("url","roomlist.do");          
           }
       return "redirect"; 
	}
	
	@RequestMapping(value = "/after_search.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String search(HttpServletRequest request, String searchValue, RoomupdateDto dto, Locale locale, Model model) { 
		logger.info("검색기능", locale); 
		
		
		List<RoomupdateDto> rList = roomupdateService.search(searchValue);
		//파일 -> room_seq
		int[] r_seq = new int[rList.size()];
		for (int j = 0; j < rList.size(); j++) {
			RoomupdateDto rDto= rList.get(j);		
			r_seq[j]=rDto.getR_seq();
		}
		
		List<filedto> fList = fileService.searchFile(r_seq);
		
		model.addAttribute("fList", fList);
		model.addAttribute("rList", rList);  

	    return "search_list"; 	          
	}     
	
	
	@RequestMapping(value = "/interestRoom.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String interestRoom(int r_seq, String id, Locale locale, Model model, RoomupdateDto dto, HttpServletRequest request) { 
		logger.info("관심 방 등록", locale); 
		
		
		boolean isS = interestService.addinterest(new InterestDto(id, r_seq));
        if(isS)
        {
            model.addAttribute("msg", "관심방으로 등록되었습니다.");
            model.addAttribute("url", "roomlist.do");
        } else
        {
            return "error";
        }
        return "redirect";
         
	}     
	
	@RequestMapping(value = "/getilist.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String interest(String id, Locale locale, Model model, HttpServletRequest request) { 
		logger.info("관심 방 페이지", locale); 
		
		  List iList = interestService.iroomlist(id);
	        int iseq[] = new int[iList.size()];
	        for(int i = 0; i < iList.size(); i++)
	        {
	            InterestDto idto = (InterestDto)iList.get(i);
	            iseq[i] = idto.getI_roomseq();
	            System.out.println((new StringBuilder("i: ")).append(iseq[i]).toString());
	        }

	        List<RoomupdateDto> RIList = roomupdateService.RIroomlist(iseq);
	        List<filedto> FIList = fileService.FIlist(iseq);
	         
	        model.addAttribute("RIList", RIList);
	        model.addAttribute("FIList", FIList);
	        
	        System.out.println((new StringBuilder("R: ")).append(RIList.size()).toString());
	        System.out.println((new StringBuilder("F: ")).append(FIList.size()).toString());
	        return "interest_room"; 
         
	}      
	
	@RequestMapping(value = "/roommatedetail.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String roommatedetail(int rm_seq, HttpServletResponse response, HttpServletRequest request, Locale locale, Model model) { 
		logger.info("룸메이트 상세보기", locale); 
		
        AnsDto ansDto = ansService.getAnsBoard(rm_seq);
        model.addAttribute("ansDto", ansDto);
        return "detailboard";
         
	}    
	
	@RequestMapping(value = "/insertroommate.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String  insertroommate(String id, HttpServletResponse response, HttpServletRequest request, Locale locale, Model model) { 
		logger.info("룸메이트 글 작성폼으로 이동", locale); 
		
		 model.addAttribute("id", id);
	     return "insertroommate";      
	}       
	
	@RequestMapping(value = "/after_roommateupdate.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String  after_roommateupdate(AnsDto adto, HttpServletRequest request, Locale locale, Model model) { 
		logger.info("룸메이트 글 작성 후", locale); 
		
		 boolean isS = ansService.insertBoard(new AnsDto(adto.getRm_id(), adto.getRm_location(), adto.getRm_mf(), adto.getRm_c(), adto.getRm_title(), adto.getRm_content(), adto.getRm_cost1(), adto.getRm_cost2(), adto.getRm_cost3(), adto.getRm_cost4()));
		 if(isS) {
			return "redirect:roommatelist.do?"+adto.getRm_id(); 
		 } 
	        else {  
	            return "error";
	        	}    
	}
	
	@RequestMapping(value = "/roommatelist.do", method ={RequestMethod.GET, RequestMethod.POST})
	public String  boardList(String id, HttpServletResponse response, HttpServletRequest request, Locale locale, Model model) { 
		logger.info("룸메이트 글 리스트", locale); 
		
		 List<AnsDto> list = ansService.getAllList();
	     model.addAttribute("id", id);
	     model.addAttribute("list", list);
	     return "roommatelist"; 
	}     
	
	
	
	
	
	
	
}



	










