package masawamor.data;

import lombok.Data;

@Data
public class Talent {

	/**
	 * ID
	 */
	private int id;
	
	/**
	 * 姓
	 */
	private String lastName;
	
	/**
	 * 名
	 */
	private String firstName;
	
	/**
	 * 会社情報
	 */
	private Company company;

}
