package kr.or.ddit.api.travel.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.utils.HttpUtils;

@Controller
public class GetTrainInfoController {

	final String API_KEY = "RiRhW5gyS8VRPtTKn0oYUJwUF3JFl3rkxKBDj1XiVMzmthbnyxqLKvdedcAhXYFPtT61VQxtmRkyGcmDdaEJIw%3D%3D";
	
	@ResponseBody
	@RequestMapping(value = "traffic/trainInfo.do", method = RequestMethod.GET , produces ="application/json;charset=UTF-8")
	public String doTrainInfoGet(
				String cityCode
			) throws IOException{
		
		String tempUrl = "http://openapi.tago.go.kr/openapi/service/TrainInfoService/getCtyAcctoTrainSttnList?"
				+ "serviceKey="+API_KEY+""
				+ "&cityCode="+cityCode;
		return HttpUtils.jsonGetData(tempUrl, null);
	}
	
	@ResponseBody
	@RequestMapping(value = "traffic/trainInfo.do", method = RequestMethod.POST , produces ="application/json;charset=UTF-8")
	public String doTrainInfoPost(
			String depPlaceId,
			String arrPlaceId,
			String trainType,
			String depPlandTime
			
			) throws IOException{
		
		depPlandTime.replaceAll("-", "1");
		
		String tempUrl = "http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo?"
				+ "serviceKey="+API_KEY+""
				+ "&pageNo=1&"
				+ "&numOfRows=10"
				+ "&depPlaceId="+depPlaceId
				+ "&arrPlaceId="+arrPlaceId
				+ "&depPlandTime="+depPlandTime
				+ "&trainGradeCode="+trainType;
		
		return HttpUtils.jsonGetData(tempUrl, null);
	}
	
	@ResponseBody
	@RequestMapping(value = "traffic/trainTypeInfo.do", method = RequestMethod.GET , produces ="application/json;charset=UTF-8")
	public String doTrainInfo(
			) throws IOException{
		
		String tempUrl = "http://openapi.tago.go.kr/openapi/service/TrainInfoService/getVhcleKndList?"
				+ "serviceKey="+API_KEY;
		
		return HttpUtils.getData(tempUrl);
	}
	
	
}
