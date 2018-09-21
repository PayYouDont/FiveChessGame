
package com.payudon.util;

import java.util.UUID;

/** 
* @ClassName: StringUtil 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月20日 上午11:14:57 
*  
*/
public class StringUtil {
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
}
