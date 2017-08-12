package br.com.livro.carros.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseWithURL {

	private String status;
	private String msg;
	private String url;

	public static ResponseWithURL Ok(String message, String url) {
		ResponseWithURL r = new ResponseWithURL();
		r.setStatus("OK");
		r.setMsg(message);
		r.setUrl(url);
		
		return r;
	}

	public static ResponseWithURL Error(String message) {
		ResponseWithURL r = new ResponseWithURL();
		r.setStatus("ERROR");
		r.setMsg(message);
		
		return r;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String result) {
		this.url = result;
	}
	
}
