package SampleCamel.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Greeting implements Serializable {
		
		private String msg;
		private int count;
		public Greeting(){}
		public Greeting(String msg)
		{
			this.msg=msg;
		}
 public String getMsg()
 {
	 return msg;
 }
@Override
public String toString() {
	return "Greeting [msg=" + msg + "]";
}
 
	}


