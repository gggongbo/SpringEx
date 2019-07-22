package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.model.vo.ReplyVO;
import com.sinc.project.board.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes({ "list" })
public class BoardCtrl {

	@Resource(name = "boardS")
	private BoardService service;

	@RequestMapping(value = "/listPage.sinc", method = RequestMethod.GET)
	public String boardList(Model model) {
		System.out.println("board ctrl list");
		List<BoardVO> list = service.listService();
		///// 서비스 객체를 이용해 데이터를 불러오고 데이터를 심어야함
		model.addAttribute("list", list);
		return "/board/listPage";
	}

	@RequestMapping(value = "/register.sinc", method = RequestMethod.GET)
	public void register() {

	}

	@RequestMapping(value = "/registerBoard.sinc", method = RequestMethod.POST)
	public String register(BoardVO board) {
		int resultFlag = service.insertService(board);
		if (resultFlag != 0) {
			return "redirect:/board/listPage.sinc";
		}
		return null;

	}

	@RequestMapping(value = "/search.sinc", method = RequestMethod.POST)
	@ResponseBody // 객체 타입을 제이슨화하여 내려줄 수 있음
	public List<BoardVO> search(String type, String keyword, HashMap<String, String> map) {
		System.out.println(type + ", " + keyword);
		map.put("type", type);
		map.put("keyword", keyword);
		return service.searchService(map);
		///// 동적 쿼리가 필요
	}

	@RequestMapping(value = "/readPage.sinc", method = RequestMethod.GET)
	public String read(BoardVO vo, ModelMap model) {
		System.out.println("board ctrl read");
		//view count 올리는 작업이 필요
		BoardVO board = service.readService(vo);
		model.addAttribute("board", board);

		return "/board/readPage";
	}

	@RequestMapping("/removePage.sinc")
	public String delete(BoardVO vo) {
		System.out.println("board ctrl delete");

		int flag = service.deleteService(vo);

		if (flag != 0) {
			return "redirect:/board/listPage.sinc";
		}

		System.out.println("not deleted");
		return null;
	}

	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.GET)
	public void modifyPage(BoardVO vo) {
		
	}
	
	@RequestMapping("/replyInsert.sinc")
	@ResponseBody
	public List<ReplyVO> insertReply(int seq, String rWriter, String rContent, ReplyVO vo, Model model){
		System.out.println("board ctrl insertReply");
		vo.setSeq(seq);
		vo.setrWriter(rWriter);
		vo.setrContent(rContent);
		int flag = service.insertReplyService(vo);
		////////rlist를 채워주야할듯
		if(flag != 0) {
			List<ReplyVO> list = service.listReplyService(vo.getSeq());
			model.addAttribute("replyList", list );
			return list;
		}
		return null;
	}

//	@RequestMapping(value="/listPage.sinc", method=RequestMethod.GET)
//	public String boardList(ModelMap model) {
//		System.out.println("board ctrl list");
//		List<BoardVO> list = service.listService();
//		/////서비스 객체를 이용해 데이터를 불러오고 데이터를 심어야함
//		model.addAttribute("list", list);
//		return "/board/listPage";
//	}

}
