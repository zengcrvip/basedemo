/*
 * Copyright (C), 2002-2013, 苏宁易购电子商务有限公司
 * FileName: StringIntConverter.java
 * Author:   penny_gu/12072585
 * Date:     2013-12-6 下午3:09:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package demo.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author penny_gu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringLongConverter implements Converter<String, Long> {

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Long convert(String source) {
        if(null != source && !source.equals("")){
            return Long.valueOf(source);
        }
        return null;
    }

}
